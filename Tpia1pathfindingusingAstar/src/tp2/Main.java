package tp2;

public class Main {
public static void main(String[] args) {
	// Create a grid representation of the map with different types of cells
	int[][] grid = new int[NUM_ROWS][NUM_COLUMNS]; // assume NUM_ROWS and NUM_COLUMNS are constants
	// initialize the grid here...

	// Define a start node and a goal node in the grid
	Node startNode = new Node(START_ROW, START_COLUMN);
	Node goalNode = new Node(GOAL_ROW, GOAL_COLUMN);

	// Create an open list and a closed list to keep track of the nodes to be explored and the nodes that have already been explored
	List<Node> openList = new ArrayList<>();
	List<Node> closedList = new ArrayList<>();

	// Add the start node to the open list
	openList.add(startNode);

	// While the open list is not empty, do the following:
	while (!openList.isEmpty()) {
	    // Sort the open list by the cost function f(n) = g(n) + h(n)
	    Collections.sort(openList, new Comparator<Node>() {
	        @Override
	        public int compare(Node n1, Node n2) {
	            return Integer.compare(n1.getF(), n2.getF());
	        }
	    });
	    
	    // Select the node with the lowest f(n) value and remove it from the open list
	    Node current = openList.remove(0);
	    
	    // If the selected node is the goal node, we have found the shortest path. Return the path.
	    if (current.equals(goalNode)) {
	        return reconstructPath(current);
	    }
	    
	    // Add the current node to the closed list
	    closedList.add(current);
	    
	    // Expand the selected node by considering its neighbors
	    List<Node> neighbors = getNeighbors(current, grid);
	    for (Node neighbor : neighbors) {
	        // If the neighbor is already in the closed list, skip it
	        if (closedList.contains(neighbor)) {
	            continue;
	        }
	        
	        // Calculate the g(n) and h(n) values for the neighbor
	        int g = current.getG() + 1; // assume the cost of moving from one node to its neighbor is 1
	        int h = calculateHeuristic(neighbor, goalNode); // use a heuristic function to estimate the cost of moving from the neighbor to the goal node
	        int f = g + h; // calculate the cost function f(n) = g(n) + h(n)
	        
	        // If the neighbor is not in the open list, add it
	        if (!openList.contains(neighbor)) {
	            neighbor.setG(g);
	            neighbor.setF(f);
	            neighbor.setParent(current);
	            openList.add(neighbor);
	        }
	        // If the neighbor is already in the open list, update its g(n) and f(n) values if the new values are lower
	        else if (g < neighbor.getG()) {
	            neighbor.setG(g);
	            neighbor.setF(f);
	            neighbor.setParent(current);
	        }
	    }
	}

	// If we get here, there is no path from the start node to the goal node
	return null;
	
}
}
