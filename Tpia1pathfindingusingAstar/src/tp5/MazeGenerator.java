package tp5;

import java.util.*;

public class MazeGenerator {
    private final int rows;
    private final int cols;
    private final boolean[][] visited;
    private final boolean[][] horizontalWalls;
    private final boolean[][] verticalWalls;
    private final Random random;

    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        visited = new boolean[rows][cols];
        horizontalWalls = new boolean[rows - 1][cols];
        verticalWalls = new boolean[rows][cols - 1];
        random = new Random();
    }

    public void generate() {
        Stack<Point> stack = new Stack<Point>();
        Point current = new Point(0, 0);
        visited[0][0] = true;

        while (true) {
            List<Point> neighbors = getUnvisitedNeighbors(current);
            if (!neighbors.isEmpty()) {
                Point neighbor = neighbors.get(random.nextInt(neighbors.size()));
                removeWall(current, neighbor);
                stack.push(current);
                current = neighbor;
                visited[current.row][current.col] = true;
            } else if (!stack.isEmpty()) {
                current = stack.pop();
            } else {
                break;
            }
        }
    }

    private List<Point> getUnvisitedNeighbors(Point point) {
        List<Point> neighbors = new ArrayList<Point>();
        if (point.row > 0 && !visited[point.row - 1][point.col]) {
            neighbors.add(new Point(point.row - 1, point.col));
        }
        if (point.row < rows - 1 && !visited[point.row + 1][point.col]) {
            neighbors.add(new Point(point.row + 1, point.col));
        }
        if (point.col > 0 && !visited[point.row][point.col - 1]) {
            neighbors.add(new Point(point.row, point.col - 1));
        }
        if (point.col < cols - 1 && !visited[point.row][point.col + 1]) {
            neighbors.add(new Point(point.row, point.col + 1));
        }
        return neighbors;
    }

    private void removeWall(Point p1, Point p2) {
        if (p1.row == p2.row) {
            verticalWalls[p1.row][Math.min(p1.col, p2.col)] = true;
        } else {
            horizontalWalls[Math.min(p1.row, p2.row)][p1.col] = true;
        }
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            builder.append("__");
        }
        builder.append("\n");
        for (int i = 0; i < rows; i++) {
            builder.append("|");
            for (int j = 0; j < cols - 1; j++) {
                builder.append(verticalWalls[i][j] ? " " : "|");
                builder.append(" ");
            }
            builder.append("|\n");
            if (i < rows - 1) {
                builder.append("|");
                for (int j = 0; j < cols - 1; j++) {
                    builder.append(" ");
                    builder.append(horizontalWalls[i][j] ? "_" : " ");
                    builder.append(" ");
                }
                builder.append("|\n");
            }
        }
        System.out.println(builder.toString());
    }



}


