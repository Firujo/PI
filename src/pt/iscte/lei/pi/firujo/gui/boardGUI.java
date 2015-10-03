package pt.iscte.lei.pi.firujo.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import pt.iscte.lei.pi.firujo.game.board;

public class boardGUI extends JComponent implements Observer{
	//para desenhar o tabuleiro e cenas no tabuleiro. (por os bonecos etc)
	
	private board b;
	private int linhas;
	private int colunas;
	
	private final int tab_width=450;
	private final int tab_height=450;
	public static final int cell_width=15;
	public static final int cell_height=15;
	
	
	public boardGUI(board board) {
		super();
		this.b = board;
		linhas=b.linhas;
		colunas=b.colunas;
		
	}

	public void drawGrid(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawRect(0,0,tab_width,tab_height);
		System.out.println("LINHAS = " +linhas+"  colunas = "+colunas);
		for (int i = 1; i < linhas; i++) {
			g.drawLine(0, i * cell_height, tab_width, i * cell_height);
		}
		for (int i = 0; i < colunas; i++) {
			g.drawLine(i * cell_width, 0, i * cell_width, tab_height);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGrid(g);
//		drawRatos(g);
//		drawBaratas(g);
//		drawMosquitos(g);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		repaint();
	}

	
}
