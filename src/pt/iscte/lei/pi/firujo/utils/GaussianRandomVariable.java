package pt.iscte.lei.pi.firujo.utils;

import java.util.ArrayList;
import java.util.Random;

public class GaussianRandomVariable {

	private ArrayList<Double> grvResults = new ArrayList<Double>();
	private double mean;
	private double standardDeviation;
	
	private int width = 0;
	private int height = 0;
	private int level = 1;
	
	public GaussianRandomVariable(double mean, double standardDeviation) {
		this.mean = mean;
		this.standardDeviation = standardDeviation;
	}
	
	public GaussianRandomVariable() {}
	
	public void setParameters(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public int getY(int quadrant){
		Integer y;
		int lvlMean = ((height / 2) //altura do ecran de jogo a dividir por 2 para ter o valor de altura de um quadrante
					  / 4)  //altura de um quadrante a dividir por 4 de modo a ter 3 linhas de orientação para media
					  * (4 - level); //escolha da linha de orientaçao da media 
									 //(4 - lvl para que a orientação seja feita do centro para a extremidade do campo) 
					  
		int lvlDeviation = 0;
		if (level == 2) {
			lvlDeviation = ((height / 2)  / 4) * 2; //pode ser simplificado mas fica assim para explicar
		} else {
			lvlDeviation = ((height / 2)  / 4) * 3;
		}
		
		while (true){
			double rv = lvlDeviation * 
					Math.sqrt(-2 * Math.log((new Random()).nextDouble())) * 
					Math.cos(2 * Math.PI * (new Random()).nextDouble()) + 
					lvlMean;
			y = (int) rv;
			if (y > -1 && y < (height / 2)){
				break;
			}
		}
		
		if (quadrant == 3 || quadrant == 4){
			y = (height - 1) - y;
		} 
		
		return y;
	}
	
	public void levelUp(){
		if (level < 3) level++;
	}
	
	public int getX(int quadrant){
		Integer x;
		int lvlMean = ((width / 2) / 4) * (4 - level);					  
		int lvlDeviation = 0;
		if (level == 2) {
			lvlDeviation = (width / 4);
		} else {
			lvlDeviation = (width / 8) * 3;
		}
		
		while (true){
			double rv = lvlDeviation * 
					Math.sqrt(-2 * Math.log((new Random()).nextDouble())) * 
					Math.cos(2 * Math.PI * (new Random()).nextDouble()) + 
					lvlMean;
			x = (int) rv;
			if (x > -1 && x < (width / 2)){
				break;
			}
		}
		
		if (quadrant == 1 || quadrant == 4){
			x = (width - 1) - x;
		} 
		
		return x;
	}

	public double generateRV() {
		Random U1 = new Random();
		Random U2 = new Random();

		double rv = standardDeviation * Math.sqrt(-2 * Math.log(U1.nextDouble()))
				* Math.cos(2 * Math.PI * U2.nextDouble()) + mean;
		grvResults.add(rv);
		return rv;
	}

}