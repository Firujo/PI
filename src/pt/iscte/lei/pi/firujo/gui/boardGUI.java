package pt.iscte.lei.pi.firujo.gui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import pt.iscte.lei.pi.firujo.bughierarchy.Pigeon;
import pt.iscte.lei.pi.firujo.bughierarchy.Rat;
import pt.iscte.lei.pi.firujo.bughierarchy.Roach;
import pt.iscte.lei.pi.firujo.game.Board;
import pt.iscte.lei.pi.firujo.utils.GaussianRandomVariable;

public class boardGUI extends JComponent implements Observer{
	//para desenhar o tabuleiro e cenas no tabuleiro. (por os bonecos etc)
	
	private Board b;
	private int x;
	private int y;
	
	public boardGUI(Board board) {
		super();
		this.b = board;
		//this.x=board.x;
		//this.y=board.y;
		
	}
	
	public void drawRats(Graphics g){
		for (Rat rat : Board.getInstance().getMyRats()) {
			Image img = Toolkit.getDefaultToolkit().getImage("images" + File.separator + "rat-sf.png");
			g.drawImage(img, (int)rat.getSpawnPoint().getX(), (int)rat.getSpawnPoint().getY(), 50, 50, null);
			//g.setColor(Color.RED);
			//g.fillOval((int)rat.getSpawnPoint().getX(), (int)rat.getSpawnPoint().getY(), 50, 50);
			//g.setColor(Color.BLACK);
		}
		
	}
	
	public void drawPigeons(Graphics g){
		for (Pigeon pigeon : Board.getInstance().getMyPigeons()) {
			Image img = Toolkit.getDefaultToolkit().getImage("images" + File.separator + "pigeon-sf.png");
			g.drawImage(img, (int)pigeon.getSpawnPoint().getX(), (int)pigeon.getSpawnPoint().getY(), 50, 50, null);
			//g.setColor(Color.GREEN);
			//g.fillOval((int)mosquito.getSpawnPoint().getX(), (int)mosquito.getSpawnPoint().getY(), 50, 50);
			//g.setColor(Color.BLACK);
		}
	}
	
	public void drawCockroaches(Graphics g){
		for (Roach roach: Board.getInstance().getMyRoaches()) {
			Image img = Toolkit.getDefaultToolkit().getImage("images" + File.separator + "roach-sf.png");
			g.drawImage(img, (int)roach.getSpawnPoint().getX(), (int)roach.getSpawnPoint().getY(), 50, 50, null);
			//g.setColor(Color.BLUE);
			//g.fillOval((int)roach.getSpawnPoint().getX(), (int)roach.getSpawnPoint().getY(), 50, 50);
			//g.setColor(Color.BLACK);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//alguem que faca classes de teste para este codigo, isto fica para o fim - que é as variaveis
//		GaussianRandomVariable gr = new GaussianRandomVariable();
//		gr.setParameters(getWidth(), getHeight());
		
		
		
		/* LVL 1 | QUADRANTE 1 E 3 */
//		for (int i = 0; i < 10000; i++){
//			g.drawOval(gr.getX(1), gr.getY(1), 5, 5);
//		}
//		for (int i = 0; i < 10000; i++){
//			g.drawOval(gr.getX(3), gr.getY(3), 5, 5);
//		}
//		/* LVL 1 | QUADRANTE 1 E 3 */
//		
//		/* LVL 3 | QUADRANTE 2 E 4 */
//		gr.levelUp();
//		gr.levelUp();
//		for (int i = 0; i < 10000; i++){
//			g.drawOval(gr.getX(2), gr.getY(2), 5, 5);
//		}
//		for (int i = 0; i < 10000; i++){
//			g.drawOval(gr.getX(4), gr.getY(4), 5, 5);
//		}
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
		drawRats(g);
		drawPigeons(g);
		drawCockroaches(g);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

	
}
