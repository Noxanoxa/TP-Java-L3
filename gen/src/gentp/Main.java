package gentp;

/*
 * import java.util.*;
 * 
 * public class Main { public static void main(String[] args) { int numColors =
 * 6; int codeLength = 4; int maxRounds = 12; int populationSize = 100; double
 * mutationRate = 0.1;
 * 
 * CodeBreaker codeBreaker = new CodeBreaker(numColors, codeLength, maxRounds,
 * populationSize, mutationRate);
 * 
 * // Define the required colors and fixed positions for the secret code
 * List<Integer> requiredColors = Arrays.asList(0, 1, 2); Map<Integer, Integer>
 * fixedPositions = new HashMap<>(); fixedPositions.put(0, 3);
 * 
 * // Guess the secret code List<Integer> guess =
 * codeBreaker.guessSecretCode(requiredColors, fixedPositions);
 * 
 * // Print the guess and whether it matches the secret code
 * System.out.println("Guess: " + guess);
 * System.out.println("Matches secret code? " +
 * guess.equals(codeBreaker.generateSecretCode(requiredColors,
 * fixedPositions))); } }
 */

/*
 * import java.util.*;
 * 
 * public class Main { public static void main(String[] args) { // Set up game
 * parameters with random values Random random = new Random(); int numColors =
 * random.nextInt(6) + 4; // number of colors between 4 and 9 int codeLength =
 * random.nextInt(5) + 3; // code length between 3 and 7 int maxRounds =
 * random.nextInt(10) + 10; // max rounds between 10 and 19 int populationSize =
 * random.nextInt(100) + 100; // population size between 100 and 199 double
 * mutationRate = random.nextDouble() * 0.2; // mutation rate between 0 and 0.2
 * 
 * // Print out game parameters System.out.println("Game Parameters:");
 * System.out.println("Number of colors: " + numColors);
 * System.out.println("Code length: " + codeLength);
 * System.out.println("Max rounds: " + maxRounds);
 * System.out.println("Population size: " + populationSize);
 * System.out.println("Mutation rate: " + mutationRate);
 * 
 * // Set up required colors and fixed positions with random values
 * List<Integer> requiredColors = new ArrayList<>(); for (int i = 0; i <
 * codeLength; i++) { requiredColors.add(random.nextInt(numColors)); }
 * Map<Integer, Integer> fixedPositions = new HashMap<>(); int numFixedPositions
 * = random.nextInt(codeLength); for (int i = 0; i < numFixedPositions; i++) {
 * int position = random.nextInt(codeLength); int color =
 * random.nextInt(numColors); fixedPositions.put(position, color); }
 * 
 * // Print out required colors and fixed positions
 * System.out.println("\nRequired colors:"); System.out.println(requiredColors);
 * System.out.println("Fixed positions:"); System.out.println(fixedPositions);
 * 
 * // Create a new instance of the CodeBreaker game CodeBreaker game = new
 * CodeBreaker(numColors, codeLength, maxRounds, populationSize, mutationRate);
 * 
 * // Guess the secret code List<Integer> guess =
 * game.guessSecretCode(requiredColors, fixedPositions);
 * 
 * // Print out the guess System.out.println("\nGuess:");
 * System.out.println(guess); } }
 */

//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        int numColors = 6;
//        int codeLength = 4;
//        int maxRounds = 100;
//        int populationSize = 100;
//        double mutationRate = 0.1;
//        Map<Integer, Integer> fixedPositions = new HashMap<>();
//        fixedPositions.put(0, 0);
//        fixedPositions.put(1, 1);
//        List<Integer> requiredColors = new ArrayList<>();
//        requiredColors.add(0);
//        requiredColors.add(1);
//        requiredColors.add(2);
//
//        CodeBreaker codeBreaker = new CodeBreaker(numColors, codeLength, maxRounds, populationSize, mutationRate);
//        int generationCount = 0;
//        List<Integer> guess;
//        do {
//            generationCount++;
//            guess = codeBreaker.guessSecretCode(requiredColors, fixedPositions);
//            System.out.println("Generation: " + generationCount + ", Guess: " + guess);
//        } while (!guess.equals(codeBreaker.generateSecretCode(requiredColors, fixedPositions)) && generationCount < maxRounds);
//
//        if (guess.equals(codeBreaker.generateSecretCode(requiredColors, fixedPositions))) {
//            System.out.println("Correct guess: " + guess);
//        } else {
//            System.out.println("No correct guess found within " + maxRounds + " generations.");
//        }
//    }
//}





