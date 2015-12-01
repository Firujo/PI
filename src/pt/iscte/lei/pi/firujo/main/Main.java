package pt.iscte.lei.pi.firujo.main;

import pt.iscte.lei.pi.firujo.game.Board;
import pt.iscte.lei.pi.firujo.gui.boardGUI;
import pt.iscte.lei.pi.firujo.gui.gameGUI;

public class Main {

	public static void main(String[] args){
		Board b = new Board();
		boardGUI bg = new boardGUI(b);
		gameGUI gmg = new gameGUI(bg);
		gmg.init();
	}
}
