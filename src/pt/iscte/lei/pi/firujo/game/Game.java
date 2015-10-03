package pt.iscte.lei.pi.firujo.game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import pt.iscte.lei.pi.firujo.gui.gameGUI;

public class Game {
	//ESTA CLASSE NAO SERVE PRA NADA AINDA
	//SERA PARA ORGANIZAR TUDO O QUE TENHA A HAVER COM O JOGO, MAS NAO COM O ASPECTO GRAFICO
	//TAL COMO SE FEZ NO SNAKE (ACONSELHADO PELO PROF. SANCHO)
	
	
	private JFrame frame = new JFrame("PI GAME PLACEHOLDER");;
	private gameGUI gw;

	public Game() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 768);
		frame.setLocation(dimension.width / 2 - frame.getWidth() / 2, dimension.height / 2 - frame.getHeight() / 2);
//		gw = new GameWindow();
//		frame.add(gw);
	}

	public void showWindow() {
		frame.setVisible(true);
	}
}
