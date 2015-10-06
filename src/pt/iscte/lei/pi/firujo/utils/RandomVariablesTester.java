package pt.iscte.lei.pi.firujo.utils;

public class RandomVariablesTester {

	public static void main(String[] args) {
		DiscreteRandomVariable drv1 = new DiscreteRandomVariable(20, 21);
		System.out.println(drv1.generateRV());
	}

}
