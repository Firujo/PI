package pt.iscte.lei.pi.firujo.main;

import pt.iscte.lei.pi.firujo.game.BoardPhilips;
import pt.iscte.lei.pi.firujo.gui.boardGUI;
import pt.iscte.lei.pi.firujo.gui.gameGUI;

public class Main {

	public static void main(String[] args){
		BoardPhilips b = new BoardPhilips(300,300);
		boardGUI bg = new boardGUI(b);
		gameGUI gmg = new gameGUI(bg);
		gmg.init();
	}
}
