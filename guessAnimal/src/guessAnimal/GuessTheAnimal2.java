package guessAnimal;

import java.util.ArrayList;
import java.util.Scanner;

public class GuessTheAnimal2 {
	
    private static final String[][] RULES = {
            {"fur or hair", "mammal"},
            /*{"mammal and gray skin", "elephant"},*/
            {"gray skin", "gray skin"},
//            {"mammal and tusks", "tusker"},
            {"tusks", "tusks"},
            {"feathers", "bird"},
            {"water", "fish"},
//            {"bird and cannot fly", "penguin"},
            {"cannot fly", "cannot fly"},
            {"scales", "reptile"},
            {"live on land", "terrestrial animals"},
            {"live on land and water", "amphibian"},
            {"eats plants", "herbivore"},
            {"eats other animals", "carnivore"},
            {"fish and carnivore", "shark"},
            {"eats flies", "frog"},
            {"Green Color", "Green"},
            {"Jump Skills", "jump"}
        };
    
	 
	 public static void Guess() {
		 

		 Scanner input = new Scanner(System.in);
		 ArrayList<String> facts = new ArrayList<>();


	        for (int i = 0; i < RULES.length; i++) {
	        	
	            String[] rule = RULES[i];
	            String question = "Does the animal have " + rule[0] + "? ";
	            System.out.print(question);
	            String answer = input.nextLine().toLowerCase();
	            if (answer.equals("yes")) {
	                facts.add(rule[1]);
	                	System.out.print("["+rule[1]+"]");
	                
	                RULES[i] = new String[] {"", ""};  
	            }
	            else
            	System.out.print("["+rule[1]+"]");
	            System.out.println();
	        }
	        
//	        for (String string : facts) {
//				System.out.println(string);
//			}

			if (  facts.contains("mammal")&& facts.contains("tusker")  && facts.contains("gray skin") ) 
	            System.out.println("The animal is an elephant!");
	        
			else if (facts.contains("penguin") && facts.contains("bird") && facts.contains("feathers") && facts.contains("cannot fly") && facts.contains("amphibian")) 
	            System.out.println("The animal is a penguin!");
	        
			else if (facts.contains("shark") && facts.contains("fish") && facts.contains("carnivore")) 
	            System.out.println("The animal is a shark!");
	        
	        else if (facts.contains("Green") && facts.contains("jump") && facts.contains("eats flies")) 
	        	System.out.println("The animal is a frog!");
	        
	        else if (facts.contains("herbivore") && facts.contains("jump") && facts.contains("terrestrial animals")) 
	        	System.out.println("The animal is a Rabit!");
	        
	        else 
	            System.out.println("I don't know what animal you're thinking of.");
			
	       System.out.print("[");
			for (String string : facts) {
				System.out.print(  string );
			} 
			System.out.println("]");
	 }

	
	
    
    public static void main(String[] args) {
Guess();

    }
}
