package ColorsGame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class Game {

	private JFrame frame;
	Panel[][] cases = new Panel[8][4];
	Color []color= {Color.red,Color.blue,Color.green,Color.orange,Color.yellow,Color.magenta};
	Chromosome codeMaker=new Chromosome(null, null, null, null);
	ArrayList<Chromosome> listChromosome=new ArrayList<>();
	ArrayList<Chromosome> listnewChromosome=new ArrayList<>();
	ArrayList<Chromosome> listcrossover=new ArrayList<>(); 
	final int crossover=7 ;
	final int emitation=2 ;

	int []test= {7,7,7,7};
    int nbrChromosome=50;
	private JPanel panel, panel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
		CasesMake();
		Codemaker();
		emulation();
	}
	void Codemaker() {
		int i=new Random().nextInt(6);
		codeMaker.colors.set(0, color[i]);
		test[0]=i;
		int j;
		for(j=1;j<4;j++) {
			int nbr=new Random().nextInt(6);
			while(test_color(nbr)){
			 nbr=new Random().nextInt(6);
			}
			test[j]=nbr;
			codeMaker.colors.set(j, color[nbr]);
		}
		for(int g=0;g<4;g++) {
			cases[7][g].setBackground(codeMaker.colors.get(g));
		}
		
	}
	boolean test_color(int j) {
		for(int i=0;i<test.length;i++) {
			if(test[i]==j) {
				return true;
			}
		}
		return false;
	}

	void CasesMake() {

		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 4; j++) {
				cases[i][j] = new Panel();
				cases[i][j].setBackground(Color.LIGHT_GRAY);
				panel2.add(cases[i][j]);
			}
		}
	}
	boolean testcreation(Chromosome c) {
		int s;
		for(int i=0;i<listChromosome.size();i++) {
			s=0;
			 for(int j=0;j<4;j++) {
				 if(listChromosome.get(i).colors.get(j)==c.colors.get(j)) {
					    s++;
					 } 
			 }
			 if(s==4) {
				 return false;
			 }
			 
			 }
		return true;
	}
	void CreateChromosome() {
		Chromosome c=new Chromosome(color[new Random().nextInt(6)],color[new Random().nextInt(6)],color[new Random().nextInt(6)],color[new Random().nextInt(6)]);
		c.Fitnes(codeMaker);
		int nbr = 0;
		listChromosome.add(c);
		for(int i=0;i<nbrChromosome;i++) {
			
			Chromosome c1;
			do {
			 c1=new Chromosome(color[new Random().nextInt(6)],color[new Random().nextInt(6)],color[new Random().nextInt(6)],color[new Random().nextInt(6)]);
			}while(!testcreation(c1));
			
			c1.Fitnes(codeMaker);
			
			listChromosome.add(c1);
		}
	}
	  void selectionRandom(List<Chromosome> list) {
		      Chromosome c=null;
		      double [] percentage=new double[nbrChromosome];
		      double x=0;
		      double TNF=0;
		    		  int index = 0;
		       for(int i=0;i<nbrChromosome;i++) {
		    	   TNF=TNF+list.get(i).getFitnes();
		    	   
		       }
		       
		      for(int i=0;i<nbrChromosome;i++) {
		    	  x=x+((list.get(i).getFitnes()/TNF)*100);
		    	   percentage[i]=x;
		      }
		      for(int i=0;i<nbrChromosome;i++) {
		    	  int r=new Random().nextInt(100);
		    	    for(int j=0;j<nbrChromosome;j++) {
		    	    	   if(r<=percentage[j]) {
		    	    		   index=j;
		    	    		    break;
		    	    	   }
		    	    }
		    	    c=new Chromosome(list.get(index).colors.get(0), list.get(index).colors.get(1),list.get(index).colors.get(2), list.get(index).colors.get(3));
		    	    c.Fitnes(codeMaker);
		    	    listnewChromosome.add(c);
		    	  
		      }
		  
	  }
	
	boolean Crossover(int line) {
		
		Chromosome c1,c2;
		double bigFitnes; int index;
	      for(int i=0;i<listnewChromosome.size();i=i+2) {
	    	  if(new Random().nextInt(10)<7) {
	    		  c1=new Chromosome(listnewChromosome.get(i).colors.get(0), listnewChromosome.get(i).colors.get(1),
	    				  listnewChromosome.get(i+1).colors.get(2), listnewChromosome.get(i+1).colors.get(3));
	    			c2=new Chromosome(listnewChromosome.get(i+1).colors.get(0), listnewChromosome.get(i+1).colors.get(1),
	    					listnewChromosome.get(i).colors.get(2), listnewChromosome.get(i).colors.get(3));
	    			c1.Fitnes(codeMaker);
	    			c2.Fitnes(codeMaker);
	    			listcrossover.add(c1);
	    			listcrossover.add(c2);

	    			
	    	  }else {
	    		  c1=new Chromosome(listnewChromosome.get(i).colors.get(0), listnewChromosome.get(i).colors.get(1),
	    				  listnewChromosome.get(i).colors.get(2), listnewChromosome.get(i).colors.get(3));
	    			c2=new Chromosome(listnewChromosome.get(i+1).colors.get(0), listnewChromosome.get(i+1).colors.get(1),
	    					listnewChromosome.get(i+1).colors.get(2), listnewChromosome.get(i+1).colors.get(3));
	    			c1.Fitnes(codeMaker);
	    			c2.Fitnes(codeMaker);
	    			listcrossover.add(c1);
	    			listcrossover.add(c2);
	    	  }
	      }

	      bigFitnes=listcrossover.get(0).getFitnes();
	      index=0;
	        for(int i=1;i<listcrossover.size();i++) {
	        	if(bigFitnes<listcrossover.get(i).getFitnes()) {
	        		bigFitnes=listcrossover.get(i).getFitnes();
	        		index=i;
	        	}
	        }
	        if(bigFitnes==8) {
	        	for(int i=0;i<4;i++) {
	        		cases[line][i].setBackground(listcrossover.get(index).colors.get(i));
	        		
	        	}
	        	return true;
	        }else {
	        	if(new Random().nextInt(200)<emitation) {
	        		emitation(index);
	        		listcrossover.get(index).Fitnes(codeMaker);
	        		if(bigFitnes==8) {
	    	        	for(int i=0;i<4;i++) {
	    	        		cases[line][i].setBackground(listcrossover.get(index).colors.get(i));
	    	        		
	    	        	}
	    	        	return true;
	    	        }else {
	    	        	for(int i=0;i<4;i++) {
	    	        		cases[line][i].setBackground(listcrossover.get(index).colors.get(i));
	    	        		
	    	        	}
	    	        	return false;
	    	        }
	        		
	        	}else {
	        		for(int i=0;i<4;i++) {
	        		cases[line][i].setBackground(listcrossover.get(index).colors.get(i));
	        		
	        	}
	        	return false;
	        }
	        	}
	        	
		
	}
	void emitation(int g) {
		System.out.println("emitation");
		for(int i=0;i<4;i++){
			if(listcrossover.get(g).colors.get(i)!=codeMaker.colors.get(i))  {
				listcrossover.get(g).colors.set(i, color[new Random().nextInt(6)] );
			}
		}
	}
	void emulation() {
		boolean x;
		CreateChromosome();
		selectionRandom(listChromosome);
		for(int i=0;i<6;i++) {
			x=Crossover(i);
			if(x) {
				break;
			} 
			listnewChromosome.removeAll(listnewChromosome);
			selectionRandom(listcrossover);
			listcrossover.removeAll(listcrossover);
						
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		panel2 = new JPanel();
		panel2.setBackground(Color.white);
		panel2.setPreferredSize(new Dimension(400, 500));

		panel2.setLayout(new GridLayout(8, 4, 1, 1));
		//
		panel = new JPanel();
		panel.setBackground(Color.white);
		frame.getContentPane().add(panel, "name_1822150289279300");
		panel.add(panel2);
		// panel.setLayout(new GridLayout(8, 4, 1, 1));
	}
}
