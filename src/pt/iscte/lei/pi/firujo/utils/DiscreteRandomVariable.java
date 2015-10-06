package pt.iscte.lei.pi.firujo.utils;

import java.util.Random;

public class DiscreteRandomVariable {

	private int minRange;
	private int maxRange;

	public DiscreteRandomVariable(int minRange, int maxRange) {
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	public int generateRV() {
		Random random = new Random();
		return random.nextInt((this.maxRange-this.minRange)+1)+this.minRange;
	}

}
