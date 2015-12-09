package pt.iscte.lei.pi.firujo.game;

import java.util.Observable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.SliderUI;

import pt.iscte.lei.pi.firujo.bughierarchy.Pigeon;
import pt.iscte.lei.pi.firujo.bughierarchy.Rat;
import pt.iscte.lei.pi.firujo.bughierarchy.Roach;
import pt.iscte.lei.pi.firujo.gui.HpBar;
import pt.iscte.lei.pi.firujo.gui.gameGUI;
import pt.iscte.lei.pi.firujo.utils.DiscreteRandomVariable;

public class GameThread extends Observable implements Runnable {
	private long last;
	private int timeBetweenBugSpawning;
	private int actualMinute;

	public GameThread() {
		last = System.currentTimeMillis();
		timeBetweenBugSpawning = 2;
	}

	@Override
	public void run() {

		while (!Thread.interrupted()) { // logo se vê como vamos parar o jogo
			if (System.currentTimeMillis() - last > TimeUnit.SECONDS.toMillis(timeBetweenBugSpawning)) {
				
				gameGUI.hpBar.hpHit(10);
				gameGUI.hpBar.repaint();
				actualMinute=gameGUI.cronometro.getMinutos();
				if(actualMinute==2){
					System.out.println("Cheguei aos 2 min, vou parar !!!!!!!!!!!!!");
					System.exit(0);
				}
				spawnBug();

				last = System.currentTimeMillis();
				timeBetweenBugSpawning = 1;

				this.setChanged();
				this.notifyObservers();
			}
		}
	}

	private void spawnBug() {
		
		//DiscreteRandomVariable drv = new DiscreteRandomVariable(0, 2);
		int choice = 0;
		//V.A. discreta 1)
		double va1 = (new Random()).nextDouble();
		if ( va1 < 0.5 ) choice = 2;
		else if ( va1 >= 0.5 && va1 < (0.5 + ((double) 1 / (double) 3)) ) choice = 0;
		else choice = 1;
	
		
		switch (choice) {
		case 0:
			Rat rat = new Rat();
			Board.getInstance().addARat(rat);
			break;
		case 1:
			Pigeon pigeon = new Pigeon();
			Board.getInstance().addAPigeon(pigeon);
			break;
		case 2:		
			Roach roach = new Roach();
			Board.getInstance().addARoach(roach);
			break;
		default:
			System.out.println("DiscreveRandomVariable is wrong!");
			break;
		}
		
	}

}
