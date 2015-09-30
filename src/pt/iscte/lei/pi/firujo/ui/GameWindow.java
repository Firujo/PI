package pt.iscte.lei.pi.firujo.ui;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class GameWindow extends JLabel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
