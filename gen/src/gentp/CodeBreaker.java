package gentp;

import java.util.*;

public class CodeBreaker {

    private final int numColors;
    private final int codeLength;
    private final int maxRounds;
    private final int populationSize;
    private final double mutationRate;
    private final Random random;

    public CodeBreaker(int numColors, int codeLength, int maxRounds, int populationSize, double mutationRate) {
        this.numColors = numColors;
        this.codeLength = codeLength;
        this.maxRounds = maxRounds;
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.random = new Random();
    }

    public List<Integer> generateSecretCode(List<Integer> requiredColors, Map<Integer, Integer> fixedPositions) {
        List<Integer> secretCode = new ArrayList<>();
        for (int i = 0; i < codeLength; i++) {
            if (fixedPositions.containsKey(i)) {
                secretCode.add(fixedPositions.get(i));
            } else if (i < requiredColors.size()) {
                secretCode.add(requiredColors.get(i));
            } else {
                int color;
                do {
                    color = random.nextInt(numColors);
                } while (requiredColors.contains(color) || fixedPositions.containsValue(color));
                secretCode.add(color);
            }
        }
        return secretCode;
    }

    public int[] evaluateGuess(List<Integer> guess, List<Integer> secretCode, Map<Integer, Integer> fixedPositions, List<Integer> requiredColors) {
        int hits = 0;
        int misses = 0;
        List<Integer> secretCodeCopy = new ArrayList<>(secretCode);
        for (int i = 0; i < guess.size(); i++) {
            if(guess.get(i).equals(secretCode.get(i))) {
hits++;
secretCodeCopy.set(i, null);
}
}
for (int i = 0; i < guess.size(); i++) {
if (guess.get(i).equals(secretCode.get(i))) {
continue;
}
if (fixedPositions.containsKey(i) && guess.get(i).equals(fixedPositions.get(i))) {
continue;
}
if (requiredColors.contains(guess.get(i))) {
int idx = secretCodeCopy.indexOf(guess.get(i));
if (idx != -1) {
misses++;
secretCodeCopy.set(idx, null);
}
}
}
return new int[]{hits, misses};
}
public List<List<Integer>> generatePopulation(List<Integer> requiredColors, Map<Integer, Integer> fixedPositions) {
    List<List<Integer>> population = new ArrayList<>();
    for (int i = 0; i < populationSize; i++) {
        List<Integer> guess = new ArrayList<>();
        for (int j = 0; j < codeLength; j++) {
            if (fixedPositions.containsKey(j)) {
                guess.add(fixedPositions.get(j));
            } else if (j < requiredColors.size()) {
                guess.add(requiredColors.get(j));
            } else {
                guess.add(random.nextInt(numColors));
            }
        }
        population.add(guess);
    }
    return population;
}

public List<Integer> mutate(List<Integer> guess) {
    List<Integer> mutatedGuess = new ArrayList<>(guess);
    for (int i = 0; i < codeLength; i++) {
        if (random.nextDouble() < mutationRate) {
            int color;
            do {
                color = random.nextInt(numColors);
            } while (color == guess.get(i));
            mutatedGuess.set(i, color);
        }
    }
    return mutatedGuess;
}

public List<Integer> crossover(List<Integer> parent1, List<Integer> parent2) {
    int crossoverPoint = random.nextInt(codeLength - 1) + 1;
    List<Integer> child = new ArrayList<>(parent1.subList(0, crossoverPoint));
    child.addAll(parent2.subList(crossoverPoint, codeLength));
    return child;
}

public List<List<Integer>> selectFittest(List<List<Integer>> population, List<List<Integer>> offspring, List<Integer> secretCode) {
    List<List<Integer>> mergedPopulation = new ArrayList<>(population);
    mergedPopulation.addAll(offspring);
    mergedPopulation.sort((g1, g2) -> {
        int[] fitness1 = evaluateGuess(g1, secretCode, Collections.emptyMap(), Collections.emptyList());
        int[] fitness2 = evaluateGuess(g2, secretCode, Collections.emptyMap(), Collections.emptyList());
        int score1 = fitness1[0] * codeLength + fitness1[1];
        int score2 = fitness2[0] * codeLength + fitness2[1];
        return Integer.compare(score2, score1);
    });
    return mergedPopulation.subList(0, populationSize);
}

public List<Integer> guessSecretCode(List<Integer> requiredColors, Map<Integer, Integer> fixedPositions) {
    List<List<Integer>> population = generatePopulation(requiredColors, fixedPositions);
    List<Integer> secretCode = generateSecretCode(requiredColors, fixedPositions);
    int round = 0;
    while (round < maxRounds) {
        List<List<Integer>> offspring = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            List<Integer> parent1 = population.get(random.nextInt(populationSize));
            List<Integer> parent2 = population.get(random.nextInt(populationSize));
            List<Integer> child = crossover(parent1, parent2);
List<Integer> mutatedChild = mutate(child);
offspring.add(mutatedChild);
}
population = selectFittest(population, offspring, secretCode);
List<Integer> bestGuess = population.get(0);
int[] fitness = evaluateGuess(bestGuess, secretCode, fixedPositions, requiredColors);
if (fitness[0] == codeLength) {
return bestGuess;
}
round++;
}
throw new RuntimeException("Failed to guess secret code within max rounds");
}

}








