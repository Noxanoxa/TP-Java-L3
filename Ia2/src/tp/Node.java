package tp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Node extends JButton implements ActionListener {

	Node parent;
	int col;
	int row;
	int gcost;
	int hcost;
	int fcost;
	int fcostg;
	int fcostw;
	int fcosts;
	boolean start;
	boolean goal;
	boolean solid;
	boolean water;
	boolean grass;
	boolean Sand;	
	boolean open;
	boolean openw;
	boolean checked;

	public Node(int col, int row) {
		this.col = col;
		this.row = row;

		setBackground(Color.white);
		setForeground(Color.black);
		addActionListener(this);

	}

	public void setAsStart() {
		setBackground(Color.green);
		setForeground(Color.white);
		setText("Start");
		start = true;
	}

	public void setAsGoal() {
		setBackground(Color.red);
		setForeground(Color.black);
		setText("Goal");
		goal = true;
	}

	public void setAsSolid() {
		setBackground(Color.black);
		setForeground(Color.white);
		setText("Wall");
		solid = true;
	}

	public void setAsWater() {
		setBackground(Color.CYAN);
		setForeground(Color.white);
		setText("Water");
		water = true;
	}

	public void setAsGrass() {
		setBackground(Color.green);
		setForeground(Color.black);
		setText("Grass");
		grass = true;
	}
	public void setAsSand() {
		setBackground(Color.yellow);
		setForeground(Color.black);
		setText("Sand");
		Sand = true;
	}

	public void setAsOpen() {
		open = true;
	}

	public void setAsOpenWater() {
		openw = true;
	}

	public boolean getAsOpenWater() {
		return openw;
	}

	public void setAsOpenGrass() {
		openw = true;
	}

	public boolean getAsOpenGrass() {
		return openw;
	}
	public void setAsOpenSand() {
		openw = true;
	}
	
	public boolean getAsOpenSand() {
		return openw;
	}

	public void setAsChecked() {
		if (start == false && goal == false) {
//			setBackground(Color.orange);
//			setForeground(Color.red);
		}
		checked = true;
	}

	public void setAsPath() {
		setBackground(Color.PINK);
		setForeground(Color.blue);
	}

	public void actionPerformed(ActionEvent e) {
		setBackground(Color.orange);
	}
	

//    public boolean isSolidNode(int col,int row) {
//				return solid;
//				
//    }
//
//    public boolean isWaterNode(int col,int row) {    		
//		return water;
//}
//
//    public boolean isStartNode(int col,int row) {
//    		return start;
//}
//
//    public boolean isGoalNode(int col,int row) {
//    		return goal;
//}
//    public int getStartNode(Node node) {
//        return startnod
//    }
//
//    public int getStartNodeY(Node node) {
//    }




}
