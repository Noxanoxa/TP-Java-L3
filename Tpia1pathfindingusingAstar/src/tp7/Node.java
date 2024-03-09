package tp7;

import java.util.ArrayList;

public class Node implements Comparable<Node> {
    public Node parentNode;
    public Node node_goal;
    public int action;
    public int x;
    public int y;
    public int g;
    public int h;
    
    public Node(Node parentNode, Node node_goal, int action, int x, int y) {
        this.parentNode = parentNode;
        this.node_goal = node_goal;
        this.action = action;
        this.x = x;
        this.y = y;
        this.g = 0;
        this.h = 0;
    }
    
    public boolean isMatch(Node node) {
        return this.x == node.x && this.y == node.y;
    }
    
    public ArrayList<Node> getSuccessors() {
        ArrayList<Node> successors = new ArrayList<Node>();
        // generate successors here
        return successors;
    }
    
    public int f() {
        return this.g + this.h;
    }
    
    @Override
    public int compareTo(Node other) {
        if (this.f() < other.f()) {
            return -1;
        } else if (this.f() > other.f()) {
            return 1;
        } else {
            return 0;
        }
    }
    public Node getParentNode() {
        return this.parentNode;
    }
    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public int getG() {
        return this.g;
    }

}
