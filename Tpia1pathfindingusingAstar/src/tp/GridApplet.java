//package tp;
//
//import javax.swing.JFrame;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.util.Random;
//
//
//public class GridApplet extends JFrame {
//    private int width;
//    private int height;
//    private Cell[][] cells;
//    private Random random;
//
//    public void init() {
//        this.width = 10;
//        this.height = 10;
//        this.cells = new Cell[width][height];
//        this.random = new Random();
//
//        // initialize the cells with random terrain types
//        for (int x = 0; x < width; x++) {
//            for (int y = 0; y < height; y++) {
//                TerrainType terrain = getRandomTerrainType();
//                cells[x][y] = new Cell(x, y, terrain);
//            }
//        }
//    }
//
//    public void paint(Graphics g) {
//        int cellSize = 20;
//        int xPadding = 20;
//        int yPadding = 20;
//
//        // draw the cells
//        for (int x = 0; x < width; x++) {
//            for (int y = 0; y < height; y++) {
//                int xPos = xPadding + x * cellSize;
//                int yPos = yPadding + y * cellSize;
//
//                TerrainType terrain = cells[x][y].getTerrain();
//                switch (terrain) {
//                    case WALL:
//                        g.setColor(Color.BLACK);
//                        break;
//                    case WATER:
//                        g.setColor(Color.BLUE);
//                        break;
//                    case SAND:
//                        g.setColor(Color.YELLOW);
//                        break;
//                    case GRASS:
//                        g.setColor(Color.GREEN);
//                        break;
//                    case EMPTY:
//                        g.setColor(Color.WHITE);
//                        break;
//                    default:
//                        g.setColor(Color.BLACK);
//                }
//
//                g.fillRect(xPos, yPos, cellSize, cellSize);
//                g.setColor(Color.BLACK);
//                g.drawRect(xPos, yPos, cellSize, cellSize);
//            }
//        }
//    }
//
////    private TerrainType getRandomTerrainType() {
////        int randomIndex = random.nextInt(TerrainType.values().length);
////        return TerrainType.values()[randomIndex];
////    }
//}