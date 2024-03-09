package tp4;

public class MazeGen_SearchAlgo_YT {
	
	int cols;
	int rows ;
	public int size = 40;
	Block block;
	
	void setup() {
		size(480,480);
		rows = height /size; 
		cols = width /size; 
		block = new Block(0, 0);
		
	} 
	
	void draw() {
		block.show();
	}
}
