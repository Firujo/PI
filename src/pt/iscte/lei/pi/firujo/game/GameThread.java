package pt.iscte.lei.pi.firujo.game;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

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
			if(System.currentTimeMillis() - last > TimeUnit.SECONDS.toMillis(timeBetweenBugSpawning)){
				
			
			// TODO loop de jogo aqui
			System.out.println("bixarada nasce");
			
			last = System.currentTimeMillis();
			timeBetweenBugSpawning = 1;
			}
			
			
			notifyObservers();
		}
	}

}
