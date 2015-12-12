package pt.iscte.lei.pi.firujo.bughierarchy;

import java.awt.Point;
import java.util.Random;

import pt.iscte.lei.pi.firujo.game.GameThread;
import pt.iscte.lei.pi.firujo.gui.gameGUI;
import pt.iscte.lei.pi.firujo.utils.DiscreteRandomVariable;
import pt.iscte.lei.pi.firujo.utils.GaussianRandomVariable;

public class Animal {

	private Point spawnPoint;
	private int timeToLive;
	private int imageMultiplier;
	private boolean poisoned;
	
	public Animal(int lvl){
		double randomV = new Random().nextDouble();
		if (randomV < 1.0/3.0 && randomV >= 0) imageMultiplier = 1;
		else if (randomV < 2.0/3.0 && randomV >= 1.0/3.0) imageMultiplier = 2;
		else imageMultiplier = 3;
		int imageSize = (gameGUI.boardPanel.getHeight()/10) * imageMultiplier;
		
		//DiscreteRandomVariable drvX = new DiscreteRandomVariable(0, gameGUI.boardPanel.getWidth() - imageSize);
		//DiscreteRandomVariable drvY = new DiscreteRandomVariable(0, gameGUI.boardPanel.getHeight() - imageSize);
		DiscreteRandomVariable dVA = new DiscreteRandomVariable(1, 4);
		int quadrant = dVA.generateRV();
		
		GaussianRandomVariable gVA = new GaussianRandomVariable();
		gVA.setLvl(lvl);
		gVA.setParameters(gameGUI.boardPanel.getWidth() - imageSize, gameGUI.boardPanel.getHeight() - imageSize);
		
		setTimeToLive((new DiscreteRandomVariable(1, 3)).generateRV());
		setSpawnPoint(new Point(gVA.getX(quadrant), gVA.getY(quadrant)));
		//setSpawnPoint(new Point(drvX.generateRV(), drvY.generateRV()));
		
		double random = new Random().nextDouble();
		if (random < 0.1) poisoned = true;
		else poisoned = false;
		
	}
	
	public boolean isPoisoned(){
		return poisoned;
	}
	
	public int getImageMultiplier(){
		return imageMultiplier;
	}
	
	private void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}
	
	private int getTimeToLive(){
		return this.timeToLive;
	}

	public Point getSpawnPoint() {
		return spawnPoint;
	}

	public void setSpawnPoint(Point spawnPoint) {
		System.out.println(spawnPoint);
		this.spawnPoint = spawnPoint;
	}

}
