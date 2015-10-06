package pt.iscte.lei.pi.firujo.utils;

import java.util.ArrayList;
import java.util.Random;

public class DiscreteRandomVariable {

	private ArrayList<Integer> drvResults = new ArrayList<Integer>();
	private int minRange;
	private int maxRange;

	public DiscreteRandomVariable(int minRange, int maxRange) {
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	public int generateRV() {
		Random random = new Random();
		int rv = random.nextInt((this.maxRange-this.minRange)+1)+this.minRange;
		drvResults.add(rv);
		return rv;
	}

}
