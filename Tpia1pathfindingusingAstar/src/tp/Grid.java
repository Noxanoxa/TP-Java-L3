package tp;

public class Grid {
    private int numRows;
    private int numCols;
    private Node[][] grid;
    private Node startNode;
    private Node goalNode;

    public Grid(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.grid = new Node[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = new Node(i, j, true);
            }
        }

        // Define start and goal nodes
        startNode = getNode(0, 0);
        goalNode = getNode(numRows-1, numCols-1);
    }

    public Node getNode(int row, int col) {
        return grid[row][col];
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getGoalNode() {
        return goalNode;
    }
}

class Node {
    private int row;
    private int col;
    private boolean passable;

    public Node(int row, int col, boolean passable) {
        this.row = row;
        this.col = col;
        this.passable = passable;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isPassable() {
        return passable;
    }
}
