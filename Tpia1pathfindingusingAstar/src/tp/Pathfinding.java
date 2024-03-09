//package tp;
//
//import java.util.*;
//
//public class Pathfinding {
//    
//    // Define the different types of terrain
//    public enum TerrainType {
//        WALL, WATER, SAND, GRASS, EMPTY
//    }
//    
//    // Define the cell class for each location in the grid
//    public class Cell {
//        private int row;
//        private int col;
//        private TerrainType terrainType;
//        private int cost;
//        
//        public Cell(int row, int col, TerrainType terrainType, int cost) {
//            this.row = row;
//            this.col = col;
//            this.terrainType = terrainType;
//            this.cost = cost;
//        }
//        
//        public int getRow() {
//            return row;
//        }
//        
//        public int getCol() {
//            return col;
//        }
//        
//        public TerrainType getTerrainType() {
//            return terrainType;
//        }
//        
//        public int getCost() {
//            return cost;
//        }
//        
//        // Override the equals method to compare cells
//        @Override
//        public boolean equals(Object obj) {
//            if (obj instanceof Cell) {
//                Cell other = (Cell) obj;
//                return this.row == other.row && this.col == other.col;
//            }
//            return false;
//        }
//        
//        // Override the hashcode method for the equals method
//        @Override
//        public int hashCode() {
//            return Objects.hash(row, col);
//        }
//    }
//    
//    // Define the pathfinding algorithm
//    public List<Cell> findPath(Cell[][] grid, Cell start, Cell goal, int maxSteps, TerrainType allowedTerrain, Set<Cell> dangerousCells) {
//        // Initialize the open and closed sets
//        Set<Cell> openSet = new HashSet<>();
//        Set<Cell> closedSet = new HashSet<>();
//        openSet.add(start);
//        
//        // Initialize the scores for each cell
//        Map<Cell, Integer> gScores = new HashMap<>();
//        gScores.put(start, 0);
//        Map<Cell, Integer> fScores = new HashMap<>();
//        fScores.put(start, heuristic(start, goal));
//        
//        // Initialize the cameFrom map for reconstructing the path
//        Map<Cell, Cell> cameFrom = new HashMap<>();
//        
//        // Keep track of the steps taken by the robot
//        int steps = 0;
//        
//        // Loop until the open set is empty or the goal is found
//        while (!openSet.isEmpty()) {
//            // Find the cell in the open set with the lowest f score
//            Cell current = null;
//            int minFScore = Integer.MAX_VALUE;
//            for (Cell cell : openSet) {
//                int fScore = fScores.getOrDefault(cell, Integer.MAX_VALUE);
//                if (fScore < minFScore) {
//                    current = cell;
//                    minFScore = fScore;
//                }
//            }
//            
//            // Check if the current cell is the goal
//            if (current.equals(goal)) {
//                return reconstructPath(cameFrom, current);
//            }
//            
//            // Remove the current cell from the open set and add it to the closed set
//            openSet.remove(current);
//            closedSet.add(current);
//            
//            // Check if the robot has taken too many steps
//            if (++steps > maxSteps) {
//                return null;
//            }
//            
//            // Loop through the neighbors of the current cell
//            for (Cell neighbor : getNeighbors(grid, current)) {
//                // Check if the neighbor is in the closed set or is a dangerous cell
//                if (closedSet.contains(neighbor) || dangerousCells.contains(neighbor)) {
//                    continue;
//                }
//                
//                // Check if the robot is allowed to move on the terrain type of the
