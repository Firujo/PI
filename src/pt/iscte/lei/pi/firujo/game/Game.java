package pt.iscte.lei.pi.firujo.game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import pt.iscte.lei.pi.firujo.ui.GameWindow;

public class Game {

	private JFrame frame = new JFrame("PI GAME PLACEHOLDER");;
	private GameWindow gw;

	public Game() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 768);
		frame.setLocation(dimension.width / 2 - frame.getWidth() / 2, dimension.height / 2 - frame.getHeight() / 2);
		gw = new GameWindow();
		frame.add(gw);
	}

	public void showWindow() {
		frame.setVisible(true);
	}
}
