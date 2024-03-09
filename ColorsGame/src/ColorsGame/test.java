package ColorsGame;

import java.awt.Color;

public class test {
     
	public static void main(String[] args) {
		Chromosome c1= new Chromosome(Color.red,Color.blue,Color.green,Color.orange);
		Chromosome c2= new Chromosome(Color.red,Color.blue,Color.green,Color.orange);
		if(c1==c2) {
			System.out.println("true");
		}else {
			System.out.println("hoho");
		}

	}

}
