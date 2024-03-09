package tp6;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;

public class AStar {
    private final int[][] grid;
    private final int rows;
    private final int cols;
    private final Point start;
    private final Point goal;

    public AStar(int[][] grid, Point start, Point goal) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.start = start;
        this.goal = goal;
    }

    public void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        Set<Point> closedSet = new HashSet<>();
        Node startNode = new Node(start, 0, heuristic(start));
        pq.offer(startNode);

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.point.equals(goal)) {
                reconstructPath(current);
                return;
            }

            closedSet.add(current.point);

            for (Point neighbor : getNeighbors(current.point)) {
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                int tentativeG = current.g + 1;
                int heuristic = heuristic(neighbor);
                int f = tentativeG + heuristic;

                Node neighborNode = new Node(neighbor, tentativeG, heuristic);
                if (pq.contains(neighborNode) && f >= neighborNode.f) {
                    continue;
                }

                neighborNode.parent = current;
                pq.offer(neighborNode);
            }
        }
    }

    private int heuristic(Point p) {
        return Math.abs(p.row - goal.row) + Math.abs(p.col - goal.col);
    }

    private Set<Point> getNeighbors(Point p) {
        Set<Point> neighbors = new HashSet<>();
        int row = p.row;
        int col = p.col;

        if (row > 0 && grid[row - 1][col] == 0) {
            neighbors.add(new Point(row - 1, col));
        }
        if (row < rows - 1 && grid[row + 1][col] == 0) {
            neighbors.add(new Point(row + 1, col));
        }
        if (col > 0 && grid[row][col - 1] == 0) {
            neighbors.add(new Point(row, col - 1));
        }
        if (col < cols - 1 && grid[row][col + 1] == 0) {
            neighbors.add(new Point(row, col + 1));
        }

        return neighbors;
    }

    private void reconstructPath(Node node) {
        if (node.parent != null) {
            reconstructPath(node.parent);
        }
        System.out.println(node.point.row + "," + node.point.col);
    }

    private static class Node {
        public final Point point;
        public final int g;
        public final int h;
        public final int f;
        public Node parent;

        public Node(Point point, int g, int h) {
            this.point = point;
            this.g = g;
            this.h = h;
            this.f = g + h;
            this.parent = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return point.equals(node.point);
        }

        @Override
        public int hashCode() {
            return point.hashCode();
        }
    }
}

