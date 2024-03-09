package tp;

public class TSPGene {

	private final int x;
	private final int y;

	public TSPGene(final int x, final int y) {
		this.x = x;
		this.y = y;

	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + this.x + "," + this.y + ")";
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	 
}
