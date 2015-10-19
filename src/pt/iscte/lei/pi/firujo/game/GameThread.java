package pt.iscte.lei.pi.firujo.game;

import java.util.Observable;

public class GameThread extends Observable implements Runnable {

	public GameThread() {
		// TODO construtor do motor de jogo
	}

	@Override
	public void run() {

		while (!Thread.interrupted()) { // logo se vê como vamos parar o jogo

			// TODO loop de jogo aqui
			
			notifyObservers();
		}
	}

}
