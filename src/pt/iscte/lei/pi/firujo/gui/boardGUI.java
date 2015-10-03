package pt.iscte.lei.pi.firujo.gui;


import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import pt.iscte.lei.pi.firujo.game.board;

public class boardGUI extends JComponent implements Observer{
	//para desenhar o tabuleiro e cenas no tabuleiro. (por os bonecos etc)
	
	private board b;
	private int x;
	private int y;
	
	public boardGUI(board board) {
		super();
		this.b = board;
		this.x=board.x;
		this.y=board.y;
		
	}
	
	public void drawRats(Graphics g){
		//desenhar os ratos
	}
	
	public void drawMosquitos(Graphics g){
		//desenhar os mosquitos
	}
	
	public void drawCockroaches(Graphics g){
		//desenhar as baratas
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

//		drawRats(g);
//		drawMosquitos(g);
//		drawCockroaches(g);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		repaint();
	}

	
}
