package ColorsGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class Chromosome {
	ArrayList<Color> colors=new ArrayList<>();
	double fitnes=0;
	public Chromosome(Color color1, Color color2, Color color3, Color color4) {
		super();
		colors.add(color1);
		colors.add(color2);
		colors.add(color3);
		colors.add(color4);

	}
	public void Fitnes(Chromosome c) {
		double hit=0,mis=0;
		int test=0;
		 for(int i=0;i<c.colors.size();i++) {
			 test=0;
			 if(colors.get(i)==c.colors.get(i)) {
				 
				 hit=hit+2;
			 }else {
				for(int j=0;j<colors.size();j++) {
					 if(colors.get(j)==c.colors.get(i)) {
						 if(test==0) {
							 mis++;
							 test=1;
						 }
						 
					 }
			 } 
			 }
			 
		 }
		 this.fitnes=hit+mis;
		
	}
	public double getFitnes() {
		return fitnes;
	}
	public void setFitnes(int fitnes) {
		this.fitnes = fitnes;
	}

}
