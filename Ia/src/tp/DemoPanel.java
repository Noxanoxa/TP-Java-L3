package tp;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoPanel extends JPanel{
	final int maxcol =15;
	final int maxrow =10;
	final int nodesize =65;
	final int screenWidth = nodesize * maxcol;
	final int screenhight = nodesize * maxrow;
	
	Node[][] node = new Node[maxcol][maxrow];
	Node startnode, goalnode, currentnode;
	ArrayList<Node> openList = new ArrayList<Node>();
	ArrayList<Node> checkedList = new ArrayList<Node>();
	
	boolean goalReached = false;
	int step =0;
	
	public DemoPanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenhight));
		this.setBackground(Color.black);
		this.setLayout(new GridLayout(maxrow,maxcol));
		this.addKeyListener(new KeyHandler(this));
		this.setFocusable(true);
		
		int col =0;
		int row =0;
		while(col < maxcol && row <maxrow) {
			
			node[col][row] = new Node(col,row);
			this.add(node[col][row]);
			col++;
			if(col==maxcol) {
				col=0;
				row++;
			}
		}
		setStartNode(0, 0);
		setGoalNode(11, 3);
		setSolidNode(10, 2);
		setSolidNode(10, 3);
		setSolidNode(10, 4);
		setSolidNode(10, 5);
		setSolidNode(10, 6);
		setSolidNode(10, 7);
		setSolidNode(6, 2);
		setSolidNode(7, 2);
		setSolidNode(8, 2);
		setSolidNode(9, 2);
		setSolidNode(11, 7);
		setSolidNode(12, 7);
		setSolidNode(6, 1);
//		setWaterNode(4, 2);
//		setWaterNode(5, 3);
//		setWaterNode(6, 4);
//		setWaterNode(7, 5);
//		setWaterNode(8, 6);
//		setWaterNode(9, 7);
		setCostNodes();
	}
	private void setStartNode(int col, int row) {
		node[col][row].setAsStart();
		startnode =node[col][row];
		currentnode =startnode;
	}
	private void setGoalNode(int col, int row) {
		node[col][row].setAsGoal();
		goalnode =node[col][row];
	}
	private void setSolidNode(int col, int row) {
		node[col][row].setAsSolid();
		
	}
	private void setWaterNode(int col, int row) {
		node[col][row].setAsWater();
		
	}
	private void setCostNodes() {
		int col =0;
		int row =0;
		while(col<maxcol && row<maxrow) {
			getCost(node[col][row]);
			col++;
			if(col == maxcol) {
				col=0;
				row++;
			}
		}
		
	}
	private void getCost(Node node) {
		//get g cost(the distance from the start node)
		int xDistance = Math.abs(node.col - startnode.col);
		int yDistance = Math.abs(node.row - startnode.row);
		node.gcost = xDistance + yDistance ;
		//get h cost(the distance from the goal node)
		xDistance = Math.abs(node.col - goalnode.col);
	    yDistance = Math.abs(node.row - goalnode.row);
		node.hcost = xDistance + yDistance ;
		//get f cost(the total cost)
		node.fcost = node.gcost + node.hcost;
		// Display the cost on node 
		if(node!= startnode && node!= goalnode) {
			 node.setText("<html>f:"+node.fcost +"<br>g:"+ node.gcost+"</html>");
			 
		}
	}
	public void search() {
		if(goalReached == false && step<300) {
			int col = currentnode.col;
			int row = currentnode.row;
			currentnode.setAsChecked();
			checkedList.add(currentnode);
			openList.remove(currentnode);
			//open the up node
			if(row -1>=0) {
			openNode(node[col][row-1]);
			}
			//open the left node
			if(col -1>=0) {
			openNode(node[col-1][row]);
			}
			//open the down node
			if(row +1>=0&&row+1<10) {
			openNode(node[col][row+1]);
			}
			//open the right node 
			if(col +1>=0&&col+1<15) {
			openNode(node[col+1][row]);
			}
			//find the best node
			int bestNodeIndex = 0;
			int bestNodefcost = 999;
			for(int i =0; i<openList.size();i++) {
				//check if this node's f cost is better
				if(openList.get(i).fcost< bestNodefcost) {
					bestNodeIndex = i;
					bestNodefcost = openList.get(i).fcost;
				}
				//if f cost is equal, check the g cost
				else if(openList.get(i).fcost == bestNodefcost) {
					if(openList.get(i).gcost < openList.get(bestNodeIndex).gcost) {
						bestNodeIndex = i;
					}
				}
			}
			//after the loop we get the best node which is our next step
			currentnode = openList.get(bestNodeIndex);
			if(currentnode == goalnode) {
				goalReached = true;
				trackthePath();
			}
			
		}
		step++;
	}
	public void autosearch() {
		while(goalReached == false) {
			int col = currentnode.col;
			int row = currentnode.row;
			currentnode.setAsChecked();
			checkedList.add(currentnode);
			openList.remove(currentnode);
			//open the up node
			if(row -1>=0) {
			openNode(node[col][row-1]);
			}
			//open the left node
			if(col -1>=0) {
			openNode(node[col-1][row]);
			}
			//open the down node
			if(row +1>=0&&row+1<10) {
			openNode(node[col][row+1]);
			}
			//open the right node 
			if(col +1>=0&&col+1<15) {
			openNode(node[col+1][row]);
			}
			//find the best node
			int bestNodeIndex = 0;
			int bestNodefcost = 999;
			for(int i =0; i<openList.size();i++) {
				//check if this node's f cost is better
				if(openList.get(i).fcost< bestNodefcost) {
					bestNodeIndex = i;
					bestNodefcost = openList.get(i).fcost;
				}
				//if f cost is equal, check the g cost
				else if(openList.get(i).fcost == bestNodefcost) {
					if(openList.get(i).gcost < openList.get(bestNodeIndex).gcost) {
						bestNodeIndex = i;
					}
				}
			}
			//after the loop we get the best node which is our next step
			currentnode = openList.get(bestNodeIndex);
			step++;
			if(currentnode.getAsOpenWater()) {
				step++;break;
			}
//			if(step==500) {
//				Timer timer =new Timer();
//				TimerTask task =new TimerTask() {	
//					@Override
//					public void run() {
//						
//					}
//				};
//				timer.schedule(task, 1000);
//			}
			if(currentnode == goalnode) {
				goalReached = true;
				trackthePath();
			}
			
		}
	}
	private void openNode(Node node) {
		if(node.open == false && node.checked == false && node.solid == false) {
			//if the node is not open yet add it to the open list
			if(node.water == true) {
				node.setAsOpenWater();
			}
			node.setAsOpen();
			node.parent = currentnode;
			openList.add(node);
		}
		
	}
	private void trackthePath() {
		// backtrack and draw the best path
		Node current = goalnode;
		
		while(current != startnode) {
			current = current.parent;
			if(current != startnode) {
				current.setAsPath();
			}
		}
		
	}

}
