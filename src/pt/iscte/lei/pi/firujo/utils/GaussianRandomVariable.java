package pt.iscte.lei.pi.firujo.utils;

import java.util.Random;

public class GaussianRandomVariable {

	private double mean;
	private double standardDeviation;

	public GaussianRandomVariable(double mean, double standardDeviation) {
		this.mean = mean;
		this.standardDeviation = standardDeviation;
	}

	public double generateRV() {
		Random U1 = new Random();
		Random U2 = new Random();

		double rv = standardDeviation * Math.sqrt(-2 * Math.log(U1.nextDouble()))
				* Math.cos(2 * Math.PI * U2.nextDouble()) + mean;

		return rv;
	}

}
