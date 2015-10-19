package pt.iscte.lei.pi.firujo.game;

import java.util.ArrayList;
import java.util.List;

import pt.iscte.lei.pi.firujo.bughierarchy.*;

public class board {
	
	//aqui tera as informacoes todas do tabuleiro
	
	private List<Rat> myRats = new ArrayList<Rat>();
	private List<Roach> myRoaches = new ArrayList<Roach>();
	private List<Mosquito> myMosquitos = new ArrayList<Mosquito>();
	
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
