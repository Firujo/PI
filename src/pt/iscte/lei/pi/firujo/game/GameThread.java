package pt.iscte.lei.pi.firujo.game;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.SliderUI;

import pt.iscte.lei.pi.firujo.bughierarchy.Rat;

public class GameThread extends Observable implements Runnable {
	private long last;
	private int timeBetweenBugSpawning;

	public GameThread() {
		last = System.currentTimeMillis();
		timeBetweenBugSpawning = 2;
	}

	@Override
	public void run() {

		while (!Thread.interrupted()) { // logo se vê como vamos parar o jogo
			if (System.currentTimeMillis() - last > TimeUnit.SECONDS.toMillis(timeBetweenBugSpawning)) {

				spawnBug();

				last = System.currentTimeMillis();
				timeBetweenBugSpawning = 1;

				this.setChanged();
				this.notifyObservers();
			}
		}
	}

	private void spawnBug() {
		Rat rat = new Rat();
		Board.getInstance().addARat(rat);
	}

}
