package pt.iscte.lei.pi.firujo.bughierarchy;

import java.awt.Point;

import pt.iscte.lei.pi.firujo.utils.DiscreteRandomVariable;

public class Rat extends Animal{
	
	private Point spawnPoint;
	private int timeToLive;
	
	public Rat(){
		DiscreteRandomVariable drvX = new DiscreteRandomVariable(0, 800);
		DiscreteRandomVariable drvY = new DiscreteRandomVariable(0, 500);
		
		setTimeToLive((new DiscreteRandomVariable(1, 3)).generateRV());
		setSpawnPoint(new Point(drvX.generateRV(), drvY.generateRV()));
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
