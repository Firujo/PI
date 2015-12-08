package pt.iscte.lei.pi.firujo.cronometro;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class Cronometro implements Runnable {
	
	private JLabel cronLabel;
	private Timer timer;
	private int contador;
	private int segundos;
	private int minutos;
	
	public Cronometro(JLabel label) {
		super();
		this.cronLabel = label;
		contador=0;
	}
	
	@Override
	public void run() {
		timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
        	
		@Override
		public void run() {
			contador++; //a cada 1000 ms acrescenta 1
			segundos = contador % 60;
			minutos = contador / 60;
			minutos %= 60;
			cronLabel.setText(String.format("%02d:%02d",minutos, segundos));
			//digam se ha forma de optimizar esta parte do string format!
		}  
        },1000,1000);
	}

	public int getSegundos() {
		return segundos;
	}

	public int getMinutos() {
		return minutos;
	}

}
