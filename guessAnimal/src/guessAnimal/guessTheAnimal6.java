package guessAnimal;

import java.util.ArrayList;
import java.util.Scanner;
public class guessTheAnimal6 {

public static void Guess1() {
	
	 Scanner input = new Scanner(System.in);
   boolean animalGuessed = false;
   String fact = "";
   String animal = "", animals = "";
   ArrayList<String> facts = new ArrayList<>();
   ArrayList<String> animalsCaract = new ArrayList<>();
   ArrayList<String> animalsGuess = new ArrayList<>();

   
   while (true) {
	   
	   
       if (animalsGuess.contains(animalGuessed)) {
           System.out.println("I know! It's a " + animals);
           break;
       }
       System.out.println("Think of an animal and I'll try to guess it!");
       System.out.println("Press enter when you're ready");
       input.nextLine();

       System.out.println("Does the animal have fur or hair? => (y|n)");
       String response = input.nextLine().toLowerCase();
       if (response.equals("y")) {
           fact = "fur or hair";
           facts.add(fact);
           animal = "mammal";
           animalsCaract.add(animal);
//           animalGuessed = true;
       } else if (!response.equals("n ")) {
           System.out.println("Please answer with yes or no.");
           continue;
       }
       
       

       
       
       if (!animalGuessed) {
           System.out.println("Has the animal  feathers? => (yes|no)");
			response = input.nextLine().toLowerCase() ;
           if (response.equals("y")) {
               fact = "feathers";
               facts.add(fact);
               animal = "bird";
               animalsCaract.add(animal);
               animalGuessed = true;
           } else if (!response.equals("n")) {
               System.out.println("Please answer with yes or no.");
               continue;
           }
       }
       
       

       
       
       if (!animalGuessed) {
           System.out.println("Does the animal live in water? => (yes|no)");
           response = input.nextLine().toLowerCase();
           if (response.equals("y")) {
           	fact = "live in water";
           	facts.add(fact);
               animal = "fish";
               animalsCaract.add(animal);
//               animalGuessed = true;
           } else if (!response.equals("n")) {
               System.out.println("Please answer with yes or no.");
               continue;
           }
       }
       
       

       if (!animalGuessed) {
           System.out.println("Does the animal have scales? => (yes|no)");
           response = input.nextLine().toLowerCase();
           if (response.equals("y")) {
           	fact = "have scales";
           	facts.add(fact);
           	animal = "reptile";
           	animalsCaract.add(animal);
               animalGuessed = true;
           } else if (!response.equals("n")) {
               System.out.println("Please answer with yes or no.");
               continue;
           }
       }
              
       if (!animalGuessed || animalsCaract.get(0).toString() == "mammal") {
       	System.out.println("Can the animal can live on land? => (yes|no)");
       	response = input.nextLine().toLowerCase() ;
       	if (response.equals("y")) {
       		fact = "live on land";
               facts.add(fact);
               animal = "terrestrial";
               animalsCaract.add(animal);
//       		animalGuessed = true;
       	} else if (!response.equals("n")) {
       		System.out.println("Please answer with yes or no x(");
       		continue;
       	}
       }
       
//       ====================================================================================
       
       
       if (!animalGuessed && animalsCaract.get(0).toString() == "mammal" ) {
          	
       System.out.println("the animal is  has tusks? => (yes|no)");
        response = input.nextLine().toLowerCase();
       
       if (response.equals("y")) {
       	
       	for (String string : facts) {
				System.out.print(string+",");
			}
       	fact = "tusks";
       	facts.add(fact);
       	animal = "tusker";
       	animalsGuess.add(animal);
       	animalGuessed = true;
       } else if (!response.equals("n")) {
       	System.out.println("Please answer with yes or no.");
       	continue;
       }
   }

       
       
       
       if (animalGuessed && animalsCaract.get(0).toString() == "bird" ) {
          	
          	System.out.println("The animal is a bird and cannot fly? => (yes|no)");
          	response = input.nextLine().toLowerCase();
          	
          	if (response.equals("y")) {
          		fact = "cannot fly";
          		facts.add(fact);
          		animal = "Penguins";
          		animalsGuess.add(animal);
          		animalGuessed = true;
          	} else if (!response.equals("n")) {
          		System.out.println("Please answer with yes or no.");
          		continue;
          	}
          }
          
       

       if (!animalGuessed && !(animalsCaract.get(0).toString() == "carnivore")) {
           System.out.println("Is the animal eats plants ? => (yes|no)");
           response = input.nextLine().toLowerCase();
           if (response.equals("y")) {
               fact = "eats plants";
               facts.add(fact);
               animal = "herbivore";
               animalsCaract.add(animal);
//               animalGuessed = true;
           } else if (!response.equals("n")) {
               System.out.println("Please answer with yes or no x(");
               continue;
           }
       }

       
       
       if (!animalGuessed &&( animalsCaract.get(0).toString() == "mammal" ||  animalsCaract.get(0).toString() == "fish")) {
           System.out.println("is the animal which eats other animals? => (yes|no)");
           response = input.nextLine().toLowerCase();
           facts.add(fact);
           if (response.equals("y")) {
               fact = "eats other animals";
               facts.add(fact);
               animal = "carnivore";
               animalsCaract.add(animal);
               animalGuessed = true;
           } else if (!response.equals("n")) {
               System.out.println("Please answer with yes or no x(");
               continue;
           }
           
       }
       
       if (!animalGuessed || animalsCaract.get(0).toString() == "fish") {
           System.out.println("Can the animal live on both land and water? => (yes|no)");
			response = input.nextLine().toLowerCase() ;
           if (response.equals("y")) {
           	fact = "live on both land and water";
           	facts.add(fact);
               animal = "amphibian";
               animalsCaract.add(animal);
//               animalGuessed = true;
           } else if (!response.equals("n")) {
               System.out.println("Please answer with yes or no x(");
               continue;
           }
       }
       
//       System.out.println(animalsCaract.get(0).toString());
//       System.out.println(animalsCaract.get(1).toString());
       
       if (!animalGuessed && animalsCaract.get(2).toString() == "carnivore" && animalsCaract.get(1).toString() == "terrestrial") {
       	System.out.println("is the animal which eats other animals? => (yes|no)");
       	response = input.nextLine().toLowerCase();
       	facts.add(fact);
       	if (response.equals("y")) {
       		fact = "[ "+facts.get(0)+" , "+facts.get(1)+" , "+facts.get(2) + " ]";
       		facts.add(fact);
       		animal = "tiger";
       		animalsGuess.add(animal);
       		animalGuessed = true;
       	} else if (!response.equals("n")) {
       		System.out.println("Please answer with yes or no x(");
       		continue;
       	}
       	
       }
       
       
       if (animalGuessed && (animalsCaract.get(0).toString() == "fish" && animalsCaract.get(1).toString() == "carnivore")) {
       	System.out.println("is the animal is a fish and a carnivore? => (yes|no)");
       	response = input.nextLine().toLowerCase();
       	if (response.equals("y")) {
       		fact = "[ " + facts.get(0) + " , " + facts.get(1) + " ]" ;
       		facts.add(fact);
       		animal = "shark";
       		animalsGuess.add(animal);
       		animalGuessed = true;
       	} else if (!response.equals("n")) {
       		System.out.println("Please answer with yes or no x(");
       		continue;
       	}
       }
       
       

       if (!animalGuessed) {
           System.out.println("I'm sorry, I couldn't guess the animal :( ");
           System.out.println("Please try again :)");
       } else {
           System.out.println("The animal you're thinking of is a " + animal + ";)");
            animals = animal;
           
	       System.out.print("[");
			for (String string : facts) {
				System.out.print(  string + " , " );
			} 
			System.out.println("]");
			
           System.out.println("Do you like to see List of Animals Guessed ?");
       	response = input.nextLine().toLowerCase();
       	if (response.equals("y")) {
       		for (String string : animalsGuess) {
					System.out.println(string);
				}
       	}

         
       }
   }

   input.close();
	
}

public static void main(String[] args) {

	Guess1();
}
}



