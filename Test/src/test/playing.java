package test;

import java.util.ArrayList;
import java.util.Scanner;

public class playing {

	ArrayList<String> final_con = new ArrayList<>();
	ArrayList<String> facts = new ArrayList<>();
	//ArrayList<String> mylist = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	
	public playing() {
		final_con.add("elephant");
		final_con.add("penguine");
		final_con.add("shark");
		questions();
		newfacts();
		System.out.println(conclution());
		
	}
	
	void questions () {
		String inputString;
		
		System.out.println("answer with yes or no the following questions : ");
		//1
		System.out.println("does this animal have fur or hair ?");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			facts.add("fur or hair");
		}
		//2
		System.out.println("does this animal have tusks ?");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			facts.add("tusks");
		}
		//3
		System.out.println("does this animal have gray skin ?");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			facts.add("gray skin");
		}
		//4
		System.out.println("does this animal have feathers ?");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			facts.add("feathers");
		}
		//5
		System.out.println("does this animal can't fly ?");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			facts.add("can't fly");
		}
		//6
		System.out.println("does this animal eat other animals ?");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			facts.add("eat animals");
		}
		//7
		System.out.println("does this animal live in water ?");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			facts.add("live in water");
		}
		//8
		System.out.println("does this animal have scales ?");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			facts.add("scales");
		}
		//9
		System.out.println("does this animal live on land ?");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			facts.add("live on land");
		}
		//10
		System.out.println("does this animal eat plants ?");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			facts.add("eat plants");
		}
		
		System.out.println("the facts are :"+facts);
	}
	
	void  newfacts() {
		if (facts.contains("fur or hair")) {
			facts.add("mammal");
		}
		
		if (facts.contains("tusks") && facts.contains("mammal")) {
			facts.add("tusker");
		}
		
		if (facts.contains("feathers")) {
			facts.add("bird");
		}
		
		if (facts.contains("eat animals")) {
			facts.add("carnivore");
		}
		
		if (facts.contains("live in water")) {
			facts.add("fish");
		}
		
		if (facts.contains("scales")) {
			facts.add("reptile");
		}
		
		if (facts.contains("live on land")) {
			facts.add("terrestrial animal");
		}
		
		if (facts.contains("live on land") && facts.contains("live in water")) {
			facts.add("amphibian");
		}
		
		if (facts.contains("eat plants")) {
			facts.add("herbivore");
		}
		
		System.out.println("the new facts are : "+facts);
		
	}
	
	String conclution () {
		if (facts.contains("tusker") && facts.contains("gray skin")) {
			return "the animal is : elephant";
		}
		
		if (facts.contains("bird") && facts.contains("can't fly")) {
			return "the animal is : penguin";
		}
		
		if (facts.contains("carnivore") && facts.contains("fish")) {
			return "the animal is : shark";
		}
		
		return "no animal found";
	}
	
	
	
	
	
}
 