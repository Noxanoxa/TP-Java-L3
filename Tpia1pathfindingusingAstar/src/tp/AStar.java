//package tp;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.Set;
//
//public class AStar {
//    
//    // The heuristic function estimates the distance between two points.
//    private static int heuristic(Node a, Node b) {
//        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
//    }
//    
//    // A* search algorithm
//    public static List<Node> astarSearch(Graph graph, Node start, Node goal) {
//        // Create priority queue for open nodes
//        PriorityQueue<Node> open = new PriorityQueue<Node>();
//        open.add(start);
//        
//        // Create set for closed nodes
//        Set<Node> closed = new HashSet<Node>();
//        
//        // Set distances from start to all other nodes to infinity
//        graph.setAllDistances(Integer.MAX_VALUE);
//        start.setDistance(0);
//        
//        // Set parent of start node to null
//        start.setParent(null);
//        
//        while (!open.isEmpty()) {
//            // Get the node with the lowest f-score from the priority queue
//            Node current = open.poll();
//            
//            // If the current node is the goal, return the path
//            if (current == goal) {
//                List<Node> path = new ArrayList<Node>();
//                while (current.getParent() != null) {
//                    path.add(current);
//                    current = current.getParent();
//                }
//                Collections.reverse(path);
//                return path;
//            }
//            
//            // Add the current node to the closed set
//            closed.add(current);
//            
//            // Check all neighbors of the current node
//            for (Edge edge : current.getEdges()) {
//                Node neighbor = edge.getDestination();
//                
//                // If the neighbor is already in the closed set, skip it
//                if (closed.contains(neighbor)) {
//                    continue;
//                }
//                
//                // Calculate tentative g-score
//                int tentative_g_score = current.getDistance() + edge.getWeight();
//                
//                // If the neighbor is not in the open set, add it
//                if (!open.contains(neighbor)) {
//                    open.add(neighbor);
//                }
//                else if (tentative_g_score >= neighbor.getDistance()) {
//                    // If the tentative g-score is greater than or equal to the neighbor's g-score, skip it
//                    continue;
//                }
//                
//                // Update neighbor's parent and g-score
//                neighbor.setParent(current);
//                neighbor.setDistance(tentative_g_score);
//                neighbor.setHeuristic(heuristic(neighbor, goal));
//            }
//        }
//        
//        // No path found
//        return null;
//    }
//}