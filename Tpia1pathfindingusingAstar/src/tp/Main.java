package tp;

public class Main {
    public static void main(String[] args) {
        // Create a new grid with 5 rows and 6 columns
        int rows = 5;
        int cols = 6;
        Cell[][] grid = new Cell[rows][cols];
        
        // Populate the grid with cells of different types
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Set the start node
                if (i == 0 && j == 0) {
                    grid[i][j] = new Cell(CellType.START);
                }
                // Set the goal node
                else if (i == rows - 1 && j == cols - 1) {
                    grid[i][j] = new Cell(CellType.GOAL);
                }
                // Set a cell of type obstacle
                else if (Math.random() < 0.3) {
                    grid[i][j] = new Cell(CellType.OBSTACLE);
                }
                // Set a cell of type empty
                else {
                    grid[i][j] = new Cell(CellType.EMPTY);
                }
            }
        }
        
        // Print the grid to the console
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j].getType().toString().charAt(0) + " ");
            }
            System.out.println();
        }
    }
}

class Cell {
    private CellType type;

    public Cell(CellType type) {
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }
}


