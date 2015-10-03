package pt.iscte.lei.pi.firujo.game;

public class cell {
	private int x;
	private int y;
	
	
	public cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	@Override
	public String toString() {
		return "cell [x=" + x + ", y=" + y + "]";
	}
	
	
}
