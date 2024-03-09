package tp5;

public class Main {
    public static void main(String[] args) {
        int rows = 10;
        int cols = 10;
        MazeGenerator maze = new MazeGenerator(rows, cols);
        maze.generate();
        maze.print();
    }
	
}
