package Tpia3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
    private static class Node {
        String data;
        Node left;
        Node right;
    }
    
    private static Node rootNode;
    private static ArrayList<String> guessedAnimals = new ArrayList<>();
    

    public static void main(String[] args) {

    	// level 0
    	rootNode = new Node();// 0
        rootNode.data = "fur or hair";

        //level 1
        rootNode.left = new Node();//1 (l)
        rootNode.left.data = "mamal";
        
        rootNode.right = new Node();//1 r
        rootNode.right.data = "feathers";
        

 
        
        
        //level 2
        
        rootNode.left.left = new Node();//2(l,l)
        rootNode.left.left.data = "tusks ";
        
        rootNode.right.left = new Node();
        rootNode.right.left.data = "bird and cannot fly";


        rootNode.left.right = new Node();//2(l,r)
        rootNode.left.right.data = "Egg";
        
        rootNode.right.right = new Node();
        rootNode.right.right.data = "scales";
        
        // level 3

        rootNode.left.left.left = new Node();//3(l,l,l)
        
        rootNode.left.left.left.data = "tusker";
        
        rootNode.left.left.right = new Node();//3(l,l,r)
        rootNode.left.left.right.data = "gray skin";
        
        rootNode.left.right.left = new Node();//3(l,r,l)
        rootNode.left.right.left.data = "snake";
        
        rootNode.left.right.right = new Node();//3(l,r,r)
        rootNode.left.right.right.data = "crocodile";
        
        rootNode.right.left.left = new Node();
        rootNode.right.left.left.data = "penguin";
        
        rootNode.right.right.left = new Node();        
        rootNode.right.right.left.data = "reptile";
        
        rootNode.right.right.left.right = new Node();
        rootNode.right.right.left.right.data = "fish";
        rootNode.right.right.left.right.left = new Node();
        rootNode.right.right.left.right.left.data = "eats other animals";
        rootNode.right.right.left.right.left.left = new Node();
        rootNode.right.right.left.right.left.left.data = "Shark";
        
        

        
        //level 4
        
        rootNode.left.left.left.left = null;//4(l,l,l,l)
        rootNode.left.left.left.right = null;//4(l,l,l,r)
        
        

        rootNode.left.left.right.left = new Node();//4(l,l,r,l)
        rootNode.left.left.right.left.data = "elephant";
        
        rootNode.left.left.right.right = null;//4(l,l,r,r)


        rootNode.left.right.left.left = null;//4(l,r,l,l)
        rootNode.left.right.left.right = null;

        rootNode.left.right.right.left = null;//4(l,r,r,l)
        rootNode.left.right.right.right = null;
        

        play();
    }

    public static void play() {
        Node currentNode = rootNode;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (true) {
        	
            if (guessedAnimals.contains(currentNode.data)) {
                System.out.println("I know! It's a " + currentNode.data);
                break;
            }
            
            System.out.println(currentNode.data + " (y/n)");
           
            try {
            	
                input = br.readLine();
                
                if (input.equalsIgnoreCase("y")) {
                	
                    if (currentNode.left == null) {
                        System.out.println("I guessed it! It's a " + currentNode.data);
                        guessedAnimals.add(currentNode.data);
                        break;
                    }
                    currentNode = currentNode.left;
                } 
                
                else if (input.equalsIgnoreCase("n")) {
                    if (currentNode.right == null) {
                        System.out.println("I give up. What animal is it?");
                        String newAnimal = br.readLine();
                        System.out.println("Please provide a question that would help distinguish a " + currentNode.data + " from a " + newAnimal + ":");
                        String newQuestion = br.readLine();
                        System.out.println("Is the answer for a " + newAnimal + " 'y' or 'n'?");
                        input = br.readLine();
                        Node newLeft = new Node();
                        newLeft.data = newAnimal;
                        if (input.equalsIgnoreCase("y")) {
                            newLeft.left = null;
                            newLeft.right = null;
                        } else if (input.equalsIgnoreCase("n")) {
                            newLeft.left = null;
                            newLeft.right = null;
                            System.out.println("Oops! I got it wrong. Please tell me the correct answer.");
                            String correctAnswer = br.readLine();
                            Node newRight = new Node();
                            newRight.data = correctAnswer;
                            newRight.left = null;
                            newRight.right =new Node();
                            newRight.left = null;
                            newRight.right = null;
                            currentNode.right = new Node();
                            currentNode.right.data = newQuestion;
                            currentNode.right.left = newLeft;
                            currentNode.right.right = newRight;
                            break;
                            }
                            }
                            currentNode = currentNode.right;
                            } 
                else {
                            System.out.println("Invalid input. Please enter 'y' or 'n'.");
                            }
                            } catch (IOException e) {
                            e.printStackTrace();
                            }
                            }
        // Start a new game
        System.out.println("Do you want to play again? (y/n)");
        try {
            input = br.readLine();
            if (input.equalsIgnoreCase("y")) {
                play();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
    
    }
