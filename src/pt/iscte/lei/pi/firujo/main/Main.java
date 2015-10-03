package pt.iscte.lei.pi.firujo.main;

import pt.iscte.lei.pi.firujo.game.board;
import pt.iscte.lei.pi.firujo.gui.boardGUI;
import pt.iscte.lei.pi.firujo.gui.gameGUI;

public class Main {

	public static void main(String[] args){
		System.out.println("trololololol");
		board b=new board(300,300);
		boardGUI bg = new boardGUI(b);
		gameGUI gmg=new gameGUI(bg);
		gmg.init();
	}
}
