package pt.iscte.lei.pi.firujo.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class HpBar extends JComponent{

	private int hp = 375;
	
	public void hpHit(int hit){
		hp = hp - hit;
	}
	
	public void hpPowerUp(int pu){
		hp = hp + pu;
	}
	
	public boolean isDead(){
		if (hp <= 0) return true;
		return false;
	}
	
	public void paint(Graphics g){
		super.paintComponent(g);
		double barSize = (double)getWidth()/375.0;
		if (hp < 187 &&  hp > 75) g.setColor(Color.YELLOW);
		else if (hp <= 75) g.setColor(Color.RED);
		else g.setColor(Color.GREEN);
		
		for (int currentHP = 0; currentHP < hp; currentHP++){
			for (int i = 0; i <= ((int)barSize); i++){
				g.drawLine(i + (currentHP * (int)barSize), 0, i + (currentHP * (int)barSize), getHeight());
			}
		}
	}
	
}
