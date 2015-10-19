package pt.iscte.lei.pi.firujo.gui;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import pt.iscte.lei.pi.firujo.game.board;
import pt.iscte.lei.pi.firujo.utils.GaussianRandomVariable;

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

		GaussianRandomVariable gr = new GaussianRandomVariable();
		gr.setParameters(getWidth(), getHeight());
		
		/* LVL 1 | QUADRANTE 1 E 3 */
		for (int i = 0; i < 10000; i++){
			g.drawOval(gr.getX(1), gr.getY(1), 5, 5);
		}
		for (int i = 0; i < 10000; i++){
			g.drawOval(gr.getX(3), gr.getY(3), 5, 5);
		}
		/* LVL 1 | QUADRANTE 1 E 3 */
		
		/* LVL 3 | QUADRANTE 2 E 4 */
		gr.levelUp();
		gr.levelUp();
		for (int i = 0; i < 10000; i++){
			g.drawOval(gr.getX(2), gr.getY(2), 5, 5);
		}
		for (int i = 0; i < 10000; i++){
			g.drawOval(gr.getX(4), gr.getY(4), 5, 5);
		}
		/* LVL 3 | QUADRANTE 2 E 4 */
		
		/* LVL 3 | QUADRANTE 1 E 3 XXXX
		gr.levelUp();
		for (int i = 0; i < 10; i++){
			g.drawOval(gr.getX(1), gr.getY(1), 5, 5);
		}
		for (int i = 0; i < 10; i++){
			g.drawOval(gr.getX(3), gr.getY(3), 5, 5);
		}
		/* LVL 3 | QUADRANTE 1 E 3 */
		
		//g.drawOval(0, 0, 10, 10);
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
