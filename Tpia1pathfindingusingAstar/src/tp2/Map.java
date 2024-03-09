package tp2;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int[][] grid; // the 2D array representing the grid
    private Node startNode; // the starting node
    private Node goalNode; // the goal node
    private List<Node> openList; // the open list
    private List<Node> closedList; // the closed list
    
    public Map(int[][] grid, Node startNode, Node goalNode) {
        this.grid = grid;
        this.startNode = startNode;
        this.goalNode = goalNode;
        this.openList = new ArrayList<Node>();
        this.closedList = new ArrayList<Node>();
        this.openList.add(startNode); // add the start node to the open list
    }
    
    // other methods and classes...


}

