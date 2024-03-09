package tp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class DemoPanel extends JPanel {

	final int maxcol = 15;
	final int maxrow = 15;
	final int nodesize = 70;
	final int screenWidth = nodesize * maxcol;
	final int screenhight = nodesize * maxrow;
	Random r;
	Node[][] node = new Node[maxcol][maxrow];
	Node startnode, goalnode, currentnode;
	ArrayList<Node> openList = new ArrayList<Node>();
	ArrayList<Node> checkedList = new ArrayList<Node>();

	boolean goalReached = false;
	int step = 0;

	public Node getStartnode() {
		return startnode;
	}

	public void setStartnode(Node startnode) {
		this.startnode = startnode;
	}

	public DemoPanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenhight));
		this.setBackground(Color.black);
		this.setLayout(new GridLayout(maxrow, maxcol));
		this.addKeyListener(new KeyHandler(this));
		this.setFocusable(true);

		int col = 0;
		int row = 0;
		while (col < maxcol && row < maxrow) {

			node[col][row] = new Node(col, row);
			this.add(node[col][row]);
			col++;
			if (col == maxcol) {
				col = 0;
				row++;
			}
		}

		r = new Random();
		Node node = new Node(col, row);
		int x, y;

		// Generate start node location randomly until it is not on a solid or water
		// node
		do {
			x = r.nextInt(2) + 5;
			y = r.nextInt(10) + 5;
		} while (node.isSolidNode(x, y) || node.isWaterNode(x, y));
		setStartNode(x, y);

		// Generate goal node location randomly until it is not on a solid or water node
		do {
			x = r.nextInt(2) + 5;
			y = r.nextInt(10) + 5;
		} while (node.isSolidNode(x, y) || node.isWaterNode(x, y)
				|| (x == getStartnode().getX() && y == getStartnode().getY()));
		setGoalNode(x, y);

		// Generate solid nodes
		for (int i = 0; i < 20; i++) {
			int z = r.nextInt(10) + 3;
			int w = r.nextInt(10) + 2;
			if (!(z == getStartnode().getX() && w == getStartnode().getY())
					&& !(w == getStartnode().getX() && z == getStartnode().getY())) {
				setSolidNode(z, w);
			}
		}

		// Generate water nodes
		for (int i = 0; i < 10; i++) {
			int z, w;
			do {
				z = r.nextInt(6) + 1;
				w = r.nextInt(5) + 1;
			} while (node.isSolidNode(z, w) || node.isWaterNode(z, w)
					|| (z == getStartnode().getX() && w == getStartnode().getY())
					|| (z == getStartnode().getX() && w == getStartnode().getY()));
			setWaterNode(z, w);
		}
		// Generate Grass nodes
		for (int i = 0; i < 20; i++) {
			int z = r.nextInt(10) + 3;
			int w = r.nextInt(10) + 2;
			if (!(z == getStartnode().getX() && w == getStartnode().getY())
					&& !(w == getStartnode().getX() && z == getStartnode().getY()) && !(node.isSolidNode(z, w))
					&& !(node.isWaterNode(z, w))) {
				setGrassNode(z, w);
			}
		}
		// Generate Sand nodes
		for (int i = 0; i < 20; i++) {
			int z = r.nextInt(10) + 3;
			int w = r.nextInt(10) + 2;
			if (!(z == getStartnode().getX() && w == getStartnode().getY())
					&& !(w == getStartnode().getX() && z == getStartnode().getY()) && !(node.isSolidNode(z, w))
					&& !(node.isWaterNode(z, w)) && !(node.isGrassNode(z, w))) {
				setSandNode(z, w);
			}
		}
		setCostNodes();
	}

	protected void setStartNode(int x, int row) {
		node[x][row].setAsStart();
		startnode = node[x][row];
		currentnode = startnode;
	}

	protected void setGoalNode(int col, int row) {
		node[col][row].setAsGoal();
		goalnode = node[col][row];
	}

	protected void setSolidNode(int col, int row) {
		node[col][row].setAsSolid();

	}

	protected void setWaterNode(int col, int row) {
		node[col][row].setAsWater();

	}

	protected void setGrassNode(int col, int row) {
		node[col][row].setAsGrass();

	}

	protected void setSandNode(int col, int row) {
		node[col][row].setAsSand();

	}

	protected void setCostNodes() {
		int col = 0;
		int row = 0;
		while (col < maxcol && row < maxrow) {
			getCost(node[col][row]);
			col++;
			if (col == maxcol) {
				col = 0;
				row++;
			}
		}

	}

	protected void getCost(Node node) {
		// get g cost(the distance from the start node)
		int xDistance = Math.abs(node.col - startnode.col);
		int yDistance = Math.abs(node.row - startnode.row);
		node.gcost = xDistance + yDistance;
		// get h cost(the distance from the goal node)
		xDistance = Math.abs(node.col - goalnode.col);
		yDistance = Math.abs(node.row - goalnode.row);
		node.hcost = xDistance + yDistance;
		// get f cost(the total cost)
		int f = node.gcost + node.hcost;

		node.fcost = f;
		node.fcostg = f + 2;
		node.fcostw = f + 3;
		node.fcosts = f + 1;

		if (node.water == true)
			node.fcost = node.fcostg;

		if (node.water == true)
			node.fcost = node.fcostw;

		if (node.Sand == true)
			node.fcost = node.fcosts;

		// Display the cost on node
		if (node != startnode && node != goalnode && node.solid == false && node.water == false && node.grass == false
				&& node.Sand == false)
			node.setText("<html>F:" + node.fcost + "<br>G:" + node.gcost + "  (H:" + node.hcost + ")" + "</html>");

		// Display the cost on node water
//		if( node.water == true ) 
//			node.setText("<html>Fw:"+node.fcostw +"<br>G:"+ node.gcost+"  (H:"+ node.hcost + ")" + "</html>");
//			
//		
//		// Display the cost on node grass
//		if( node.grass == true  )
//			node.setText("<html>Fg:"+node.fcostg +"<br>G:"+ node.gcost+"  (H:"+ node.hcost + ")" + "</html>");
//			
//		// Display the cost on node Sand
//		if(node.Sand == true)
//			node.setText("<html>Fs:"+node.fcosts +"<br>G:"+ node.gcost+"  (H:"+ node.hcost + ")" + "</html>");

	}

	public void search() {
		if (goalReached == false && step < 300) {
			int col = currentnode.col;
			int row = currentnode.row;
			currentnode.setAsChecked();
			checkedList.add(currentnode);
			openList.remove(currentnode);
			// open the up node
			if (row - 1 >= 0)
				openNode(node[col][row - 1]);

			// open the left node
			if (col - 1 >= 0)
				openNode(node[col - 1][row]);

			// open the down node
			if (row + 1 >= 0 && row + 1 < maxrow)
				openNode(node[col][row + 1]);

			// open the right node
			if (col + 1 >= 0 && col + 1 < maxcol)
				openNode(node[col + 1][row]);

			// find the best node
			int bestNodeIndex = 0;
			int bestNodefcost = 999;
			for (int i = 0; i < openList.size(); i++) {
				// check if this node's f cost is better
				if (openList.get(i).fcost < bestNodefcost) {
					bestNodeIndex = i;
					bestNodefcost = openList.get(i).fcost;
				}
				// if f cost is equal, check the g cost
				else if (openList.get(i).fcost == bestNodefcost) {
					if (openList.get(i).gcost < openList.get(bestNodeIndex).gcost) {
						bestNodeIndex = i;
					}
				}
			}
			// after the loop we get the best node which is our next step
			currentnode = openList.get(bestNodeIndex);
			if (currentnode == goalnode) {
				goalReached = true;
				trackthePath();
			}

		}
		step++;
	}

	public void autosearch() {
		while (goalReached == false) {
			int col = currentnode.col;
			int row = currentnode.row;
			currentnode.setAsChecked();
			checkedList.add(currentnode);
			openList.remove(currentnode);
			// open the up node
			if (row - 1 >= 0)
				openNode(node[col][row - 1]);

			// open the left node
			if (col - 1 >= 0)
				openNode(node[col - 1][row]);

			// open the down node
			if (row + 1 >= 0 && row + 1 < maxrow)
				openNode(node[col][row + 1]);

			// open the right node
			if (col + 1 >= 0 && col + 1 < maxcol)
				openNode(node[col + 1][row]);

			// find the best node
			int bestNodeIndex = 0;
			int bestNodefcost = 999;
			for (int i = 0; i < openList.size(); i++) {
				// check if this node's f cost is better
				if (openList.get(i).fcost < bestNodefcost) {
					bestNodeIndex = i;
					bestNodefcost = openList.get(i).fcost;
				}
				// if f cost is equal, check the g cost
				else if (openList.get(i).fcost == bestNodefcost) {
					if (openList.get(i).gcost < openList.get(bestNodeIndex).gcost) {
						bestNodeIndex = i;
					}
				}
			}
			// after the loop we get the best node which is our next step
			currentnode = openList.get(bestNodeIndex);
			step++;

			if (currentnode == goalnode) {
				goalReached = true;
				trackthePath();
			}

		}
	}

	private void openNode(Node node) {
		if (node.open == false && node.checked == false && node.solid == false) {
			// if the node is not open yet add it to the open list
			if (node.water == true)
				node.setAsOpenWater();

			if (node.grass == true)
				node.setAsOpenGrass();

			if (node.Sand == true)
				node.setAsOpenSand();

			node.setAsOpen();
			node.parent = currentnode;
			openList.add(node);
		}
	}

	private void trackthePath() {
		// backtrack and draw the best path
		Node current = goalnode;

		while (current != startnode) {
			current = current.parent;
			if (current != startnode)
				current.setAsPath();

		}

	}

}
