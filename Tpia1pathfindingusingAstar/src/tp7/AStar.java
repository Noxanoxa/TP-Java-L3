package tp7;

import java.util.ArrayList;

public class AStar {
	public static void main(String[] args) {
	

    ArrayList<Node> SolutionPathList = new ArrayList<Node>();

    // Create a node containing the goal state node_goal
    Node node_goal = new Node(null, null, 1, 15, 15);

    // Create a node containing the start state node_start
    Node node_start = new Node(null, node_goal, 1, 0, 0);

    // Create OPEN and CLOSED list
    SortedCostNodeList OPEN = new SortedCostNodeList();
    SortedCostNodeList CLOSED = new SortedCostNodeList();

    // Put node_start on the OPEN list
    OPEN.push(node_start);

    // while the OPEN list is not empty
    while(!(OPEN.isEmpty())) {

        // Get the node off the open list with the lowest f and call it node_current
        Node node_current = OPEN.pop();

        // if node_current is the same state as node_goal we have found the solution; break from the while loop
        if (node_current.isMatch(node_goal)) {
            node_goal.parentNode = node_current.parentNode;
            break;
        }

        // Generate each state node_successor that can come after node_current
        ArrayList<Node> successors = node_current.getSuccessors();

        // for each node_successor or node_current
        for (Node node_successor : successors) {
            // Set the cost of node_successor to be the cost of node_current plus the cost to get to node_successor
            // from node_current --> already set while we were getting successors

            // find node_successor on the OPEN list
            int oFound = OPEN.indexOf(node_successor);

            // if node_successor is on the OPEN list but the existing one is as good or better then discard this successor and continue
            if (oFound >= 0) {
                Node existing_node = OPEN.nodeAt(oFound);
                if (existing_node.compareTo(node_current) <= 0)
                    continue;
            }

            // find node_successor on the CLOSED list
            int cFound = CLOSED.indexOf(node_successor);

            // if node_successor is on the CLOSED list but the existing one is as good or better then discard this
            // successor and continue
            if (cFound >= 0) {
                Node existing_node = CLOSED.nodeAt(cFound);
                if (existing_node.compareTo(node_current) <= 0)
                    continue;
            }

            // Remove occurrences of node_successor from OPEN and CLOSED
            if (oFound >= 0)
                OPEN.removeAt(oFound);
            if (cFound >= 0)
                CLOSED.removeAt(cFound);

            // Set the parent of node_successor to node_current --> already set while we were getting successors

            // Set h to be the estimated distance to node_goal (Using heuristic function) --> already set while we were getting successors

            // Add node_successor to the OPEN list
            OPEN.push(node_successor);
        }

        // Add node_current to the CLOSED list
        CLOSED.push(node_current);
    }
}
}