package pt.iscte.lei.pi.firujo.game;

import pt.iscte.lei.pi.firujo.gui.boardGUI;

public class board {
	//aqui tera as informacoes todas do tabuleiro
	public int x;
	public int y;
	
	public board(int x, int y) {
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
}
