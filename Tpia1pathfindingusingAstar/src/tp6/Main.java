package tp6;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] grid = new int[rows][cols];
        System.out.println("Enter the maze (0 for empty, 1 for wall):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j]);
//                 
            }
            System.out.println("");
        }
        System.out.print("Enter the starting row: ");
        int startRow = scanner.nextInt();

        System.out.print("Enter the starting column: ");
        int startCol = scanner.nextInt();

        Point start = new Point(startRow, startCol);

        System.out.print("Enter the goal row: ");
        int goalRow = scanner.nextInt();

        System.out.print("Enter the goal column: ");
        int goalCol = scanner.nextInt();

  
        Point goal = new Point(goalRow, goalCol);

        AStar astar = new AStar(grid, start, goal);
        astar.solve();
    }
}

