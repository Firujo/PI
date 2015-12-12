package pt.iscte.lei.pi.firujo.utils;

import java.util.LinkedList;
import java.util.Random;

public class Tester{

	private int numberOfOcurrences;

	//p1)
	private int numberOfRats = 0;
	private int numberOfRoach = 0;
	private int numberOfPigeon = 0;
	private LinkedList<Integer> valorGeradoP1 = new LinkedList<Integer>();
	
	//p2)
	private int numImgGrandes = 0;
	private int numImgMedias = 0;
	private int numImgPequenas = 0;
	private LinkedList<Integer> valorGeradoP2 = new LinkedList<Integer>();
	
	//p3)
	private int numOcurrFirstQuadrant = 0;
	private int numOcurrSecondQuadrant = 0;
	private int numOcurrThirdQuadrant = 0;
	private int numOcurrFourthQuadrant = 0;
	private LinkedList<Integer> valorGeradoQuadranteP3 = new LinkedList<Integer>();
	private LinkedList<Integer> valorXGeradoLvlOneP3 = new LinkedList<Integer>();
	private LinkedList<Integer> valorYGeradoLvlOneP3 = new LinkedList<Integer>();
	private LinkedList<Integer> valorXGeradoLvlTwoP3 = new LinkedList<Integer>();
	private LinkedList<Integer> valorYGeradoLvlTwoP3 = new LinkedList<Integer>();
	private LinkedList<Integer> valorXGeradoLvlThreeP3 = new LinkedList<Integer>();
	private LinkedList<Integer> valorYGeradoLvlThreeP3 = new LinkedList<Integer>();
	
	//p4)
	private int numOcurrPontMax = 0;
	private int numOcurrPontMedia = 0;
	private int numOcurrPontMin = 0;
	private LinkedList<Integer> valorGeradoP4 = new LinkedList<Integer>();
	
	//p5)
	private int numOcurrDanoMax = 0;
	private int numOcurrDanoMedio = 0;
	private int numOcurrDanoMin = 0;
	private LinkedList<Integer> valorGeradoP5 = new LinkedList<Integer>();
	
	//p6)
	private int numOcurrEnvenenado = 0;
	private LinkedList<Integer> valorGeradoP6 = new LinkedList<Integer>();
	
	//p7)
	private int numOcurrBombas = 0;
	private int numOcurrVidas = 0;
	private LinkedList<Integer> valorGeradoP7 = new LinkedList<Integer>();

	public Tester(int numbOc){
		
		numberOfOcurrences = numbOc;
		
		for (int i = 0; i < numberOfOcurrences; i++){
			//Tipo animal(p1)
			double va1 = (new Random()).nextDouble();
			if ( va1 < 0.5 ){
				valorGeradoP1.add(0);
				numberOfRats++; //Rato = 0
			} else if ( va1 >= 0.5 && va1 < (0.5 + (1.0 / 3.0)) ){
				valorGeradoP1.add(1);
				numberOfRoach++; //Roach = 1
			} else {
				valorGeradoP1.add(2);
				numberOfPigeon++; //Pigeon = 2
			}
			
			//Tamanho imagem (p2)
			double randomV = new Random().nextDouble();
			if (randomV < 1.0/3.0 && randomV >= 0){
				valorGeradoP2.add(0);
				numImgGrandes++; //Grande = 0
			} else if (randomV < 2.0/3.0 && randomV >= 1.0/3.0){
				valorGeradoP2.add(1);
				numImgMedias++; //Media = 1
			} else {
				valorGeradoP2.add(2);
				numImgPequenas++; //Pequena = 2
			}
			
			//Local onde animal é criado (p3)
			DiscreteRandomVariable dVA = new DiscreteRandomVariable(1, 4);
			int quadrant = dVA.generateRV();
			valorGeradoQuadranteP3.add(quadrant);
			if (quadrant == 1) numOcurrFirstQuadrant++;
			else if (quadrant == 2) numOcurrSecondQuadrant++;
			else if (quadrant == 3) numOcurrThirdQuadrant++;
			else numOcurrFourthQuadrant++;
			
			//valores para 1º quadrante com o objectivo de testar valores pretendidos
			GaussianRandomVariable gVA = new GaussianRandomVariable();
			gVA.setLvl(1);
			gVA.setParameters(100, 100); // media de X e y = 25 | desvio padrao = 25
			valorXGeradoLvlOneP3.add(gVA.getX(1));
			valorYGeradoLvlOneP3.add(gVA.getY(1));
			gVA.setLvl(2);
			gVA.setParameters(100, 100); // media de X e y = 50 | desvio padrao = 25
			valorXGeradoLvlTwoP3.add(gVA.getX(1));
			valorYGeradoLvlTwoP3.add(gVA.getY(1));
			gVA.setLvl(3);
			gVA.setParameters(100, 100); // media de X e y = 75 | desvio padrao = 25
			valorXGeradoLvlThreeP3.add(gVA.getX(1));
			valorYGeradoLvlThreeP3.add(gVA.getY(1));
			
			//Pontos que animal oferece ao ser morto (p4)
			double random = new Random().nextDouble();
			if (random >= 0.0 && random < 0.5 ){
				valorGeradoP4.add(0);
				numOcurrPontMax++; //valor maximo = 0
			} else if (random >= 0.5 && random < 0.8 ){
				valorGeradoP4.add(1);
				numOcurrPontMedia++; //valor media = 1
			} else {
				valorGeradoP4.add(2);
				numOcurrPontMin++; //valor minimo = 2
			}
			
			//Quantidade de vida que tira animal envenenado (p5)
			double random2 = new Random().nextDouble();
			if (random2 >= 0.0 && random2 < 0.5){
				valorGeradoP5.add(0);
				numOcurrDanoMax++; //dano maximo = 0
			} else if (random2 >= 0.5 && random2 < 0.8 ){
				valorGeradoP5.add(1);
				numOcurrDanoMedio++; //dano medio = 1
			} else {
				valorGeradoP5.add(2);
				numOcurrDanoMin++; //dano minimo = 2
			}
			
			//Animal estar envenenado (p6)
			double random3 = new Random().nextDouble();
			if (random3 < 0.1){
				valorGeradoP6.add(0); //animal gerado envenenado = 0
				numOcurrEnvenenado++;
			} else valorGeradoP6.add(1); //animal gerado não está envenenado = 1
			
			//Aparecimento de item extra (p7)
			double va7 = (new Random()).nextDouble();
			if ( va7 < 0.1 ){
				valorGeradoP7.add(0); //bomba gerada = 0
				numOcurrBombas++;
			} else if ( va7 >= 0.1 && va7 < 0.2){
				valorGeradoP7.add(1); //vida gerada = 1
				numOcurrVidas++;
			} else {
				valorGeradoP7.add(2); //nada gerado = 2
			}
		}
		
		gerarResultadosP1();
		System.out.println("");
		gerarResultadosP2();
		System.out.println("");
		gerarResultadosP3();
		System.out.println("");
		gerarResultadosP4();
		System.out.println("");
		gerarResultadosP5();
		System.out.println("");
		gerarResultadosP6();
		System.out.println("");
		gerarResultadosP7();
		
	}
	
	public void gerarResultadosP1(){
		System.out.println("Ocurrencias de P1: ");
		for (int i = 0; i < numberOfOcurrences; i++){
			System.out.println(valorGeradoP1.get(i));
		}
		System.out.println("Ratos gerados : " + numberOfRats + " | Baratas geradas : " + numberOfRoach + " | Pombos gerados : " + numberOfPigeon);
	}
	
	public void gerarResultadosP2(){
		System.out.println("Ocurrencias de P2: ");
		for (int i = 0; i < numberOfOcurrences; i++){
			System.out.println(valorGeradoP2.get(i));
		}
		System.out.println("Imagens grandes : " + numImgGrandes + " | Imagens medias : " + numImgMedias + " | Imagens pequenas : " + numImgPequenas);
	}
	
	public void gerarResultadosP3(){
		System.out.println("Ocurrencias de P3(quadrante): ");
		for (int i = 0; i < numberOfOcurrences; i++){
			System.out.println(valorGeradoQuadranteP3.get(i));
		}
		System.out.println("1º quadrante : " + numOcurrFirstQuadrant + " | 2º quadrante : " + numOcurrSecondQuadrant + " | 3º quadrante : " + numOcurrThirdQuadrant + " | 4º quadrante : " + numOcurrFourthQuadrant);
		System.out.println("");
		System.out.println("Ocurrencias de P3(posicao x|y no nivel 1): ");
		for (int i = 0; i < numberOfOcurrences; i++){
			System.out.println(valorXGeradoLvlOneP3.get(i) + " | " + valorYGeradoLvlOneP3.get(i));
		}
		System.out.println("");
		System.out.println("Ocurrencias de P3(posicao x|y no nivel 2): ");
		for (int i = 0; i < numberOfOcurrences; i++){
			System.out.println(valorXGeradoLvlTwoP3.get(i) + " | " + valorYGeradoLvlTwoP3.get(i));
		}
		System.out.println("");
		System.out.println("Ocurrencias de P3(posicao x|y no nivel 3): ");
		for (int i = 0; i < numberOfOcurrences; i++){
			System.out.println(valorXGeradoLvlThreeP3.get(i) + " | " + valorYGeradoLvlThreeP3.get(i));
		}
	}
	
	public void gerarResultadosP4(){
		System.out.println("Ocurrencias de P4: ");
		for (int i = 0; i < numberOfOcurrences; i++){
			System.out.println(valorGeradoP4.get(i));
		}
		System.out.println("Maximo : " + numOcurrPontMax + " | Medio : " + numOcurrPontMedia + " | Minimo : " + numOcurrPontMin);
	}
	
	public void gerarResultadosP5(){
		System.out.println("Ocurrencias de P5: ");
		for (int i = 0; i < numberOfOcurrences; i++){
			System.out.println(valorGeradoP5.get(i));
		}
		System.out.println("Maximo : " + numOcurrDanoMax + " | Medio : " + numOcurrDanoMedio + " | Minimo : " + numOcurrDanoMin);
	}
	
	public void gerarResultadosP6(){
		System.out.println("Ocurrencias de P6: ");
		for (int i = 0; i < numberOfOcurrences; i++){
			System.out.println(valorGeradoP6.get(i));
		}
		System.out.println("Nº ocurrencias animal envenenado : " + numOcurrEnvenenado + " | Neutro : " + (numberOfOcurrences - numOcurrEnvenenado));
	}
	
	public void gerarResultadosP7(){
		System.out.println("Ocurrencias de P7: ");
		for (int i = 0; i < numberOfOcurrences; i++){
			System.out.println(valorGeradoP7.get(i));
		}
		System.out.println("Nº Bombas : " + numOcurrBombas + " | Nº Vidas : " + numOcurrVidas + " | Sem bonus : " + (numberOfOcurrences - (numOcurrBombas + numOcurrVidas)));
	}
	
	public static void main(String[] args){
		new Tester(1000);
	}
	
}
