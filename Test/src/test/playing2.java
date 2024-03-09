package test;


import java.util.ArrayList;
import java.util.Scanner;

public class playing2 {

	ArrayList<String> final_con = new ArrayList<>();
	ArrayList<String> facts = new ArrayList<>();
	//ArrayList<String> mylist = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	
	public playing2() {
		final_con.add("elephant");
		final_con.add("penguine");
		final_con.add("shark");
		System.out.println("the animal is : " +questions());
		//newfacts();
		//System.out.println(conclution());
		
	}
	
	String questions () {
		String inputString;
		
		System.out.println("answer with yes or no the following questions : ");
		//1
		System.out.println("does this animal have fur or hair ?");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			facts.add("fur or hair");
			System.out.println("does this animal has tusks");
			inputString = scan.nextLine();
			if (inputString.equals("yes")) {
				facts.add("tusks");
				System.out.println("does this animal has gray skin");
				inputString = scan.nextLine();
				if (inputString.equals("yes")) {
					return "elephant";
				}
			}
		}
		
		System.out.println("does this animal have feathers");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			System.out.println("does this animal fly");
			inputString = scan.nextLine();
			if (inputString.equals("yes")) {
				return "penguin";
			}
		}
			
		System.out.println("does this animal have live in water");
		inputString = scan.nextLine();
		if (inputString.equals("yes")) {
			System.out.println("does this animal eat other animals");
			inputString = scan.nextLine();
			if (inputString.equals("yes")) {
				return "shark";
			}
		}
		
		return "no animal found";
			
	}
}
 