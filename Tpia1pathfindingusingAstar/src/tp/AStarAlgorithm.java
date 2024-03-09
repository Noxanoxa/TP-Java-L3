//package tp;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.PriorityQueue;
//import java.util.Set;
//
//public class AStarAlgorithm {
//
//    // Define the types of terrain that the robot can traverse
//    public enum TerrainType {
//        WALL,
//        WATER,
//        SAND,
//        GRASS,
//        EMPTY
//    }
//
//    // Define the structure of a cell in the grid
//    public class Cell {
//        public int x, y;
//        public TerrainType terrainType;
//        public int f, g, h;
//        public Cell parent;
//
//        public Cell(int x, int y, TerrainType terrainType) {
//            this.x = x;
//            this.y = y;
//            this.terrainType = terrainType;
//        }
//    }
//
//    // Define the Manhattan distance heuristic function
//    private int heuristic(Cell current, Cell goal) {
//        return Math.abs(current.x - goal.x) + Math.abs(current.y - goal.y);
//    }
//
//    // Define the A* algorithm
//    public ArrayList<Cell> findShortestPath(Cell[][] grid, Cell start, Cell goal, int battery) {
//        // Create the open and closed sets
//        PriorityQueue<Cell> openSet = new PriorityQueue<Cell>((a, b) -> a.f - b.f);
//        Set<Cell> closedSet = new HashSet<Cell>();
//
//        // Add the starting cell to the open set
//        start.g = 0;
//        start.h = heuristic(start, goal);
//        start.f = start.g + start.h;
//        openSet.add(start);
//
//        // Run the A* algorithm
//        while (!openSet.isEmpty()) {
//            // Get the cell with the lowest f value from the open set
//            Cell current = openSet.poll();
//
//            // Check if the current cell is the goal cell
//            if (current == goal) {
//                // Construct the path by following the parent pointers
//                ArrayList<Cell> path = new ArrayList<Cell>();
//                while (current.parent != null) {
//                    path.add(current);
//                    current = current.parent;
////                }
//                Collections.reverse(path);
//                return path;
//            }
//
//            // Add the current cell to the closed set
//            closedSet.add(current);
//
//            // Explore the neighbors of the current cell
//            for (int dx = -1; dx <= 1; dx++) {
//                for (int dy = -1; dy <= 1; dy++) {
//                    if (dx == 0 && dy == 0) {
//                        continue;
//                    }
//                    int x = current.x + dx;
//                    int y = current.y + dy;
//                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
//                        continue;
//                    }
//                    Cell neighbor = grid[x][y];
//                    if (neighbor.terrainType == TerrainType.WATER && battery <= 0) {
//                        // The robot can't move through water without battery
//                        continue;
//                    }
//                    if (neighbor.terrainType == TerrainType.WALL) {
//                        // The robot can't move through walls
//                        continue;
//                    }
//                    if (closedSet.contains(neighbor)) {
//                        // The neighbor has already been explored
//                        continue;
//                    }
//                    int g = current
