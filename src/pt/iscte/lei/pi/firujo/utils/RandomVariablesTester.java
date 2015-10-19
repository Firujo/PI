package pt.iscte.lei.pi.firujo.utils;

public class RandomVariablesTester {

	public static void main(String[] args) {
		DiscreteRandomVariable drv1 = new DiscreteRandomVariable(20, 45);
		System.out.println("Discrete: "+ drv1.generateRV());
		
		GaussianRandomVariable grv1 = new GaussianRandomVariable(0,1);
		System.out.println("Gaussian: " + grv1.generateRV());
	}

}
