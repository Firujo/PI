package pt.iscte.lei.pi.firujo.bughierarchy;

import java.awt.Point;
import java.util.Random;

import pt.iscte.lei.pi.firujo.gui.gameGUI;
import pt.iscte.lei.pi.firujo.utils.DiscreteRandomVariable;

public class Animal {

	private Point spawnPoint;
	private int timeToLive;
	private int imageMultiplier;
	
	public Animal(){
		double randomV = new Random().nextDouble();
		if (randomV < 1.0/3.0 && randomV >= 0) imageMultiplier = 1;
		if (randomV < 2.0/3.0 && randomV >= 1.0/3.0) imageMultiplier = 2;
		if (randomV >= 2.0/3.0) imageMultiplier = 3;
		int imageSize = (gameGUI.boardPanel.getHeight()/10) * imageMultiplier;
		
		DiscreteRandomVariable drvX = new DiscreteRandomVariable(0, gameGUI.boardPanel.getWidth() - imageSize);
		DiscreteRandomVariable drvY = new DiscreteRandomVariable(0, gameGUI.boardPanel.getHeight() - imageSize);
		
		setTimeToLive((new DiscreteRandomVariable(1, 3)).generateRV());
		setSpawnPoint(new Point(drvX.generateRV(), drvY.generateRV()));
		
		
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
