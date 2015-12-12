package pt.iscte.lei.pi.firujo.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Random;

import pt.iscte.lei.pi.firujo.bughierarchy.Pigeon;
import pt.iscte.lei.pi.firujo.bughierarchy.Rat;
import pt.iscte.lei.pi.firujo.bughierarchy.Roach;
import pt.iscte.lei.pi.firujo.gui.gameGUI;

public class MouseGameListener extends Observable implements MouseListener {

	private boolean cantClick; 
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getPoint());
		if(cantClick==false){
			checkIfHitAndRemove(e);
		}
		else System.out.println("the game ended , time is up");
	}

	private void checkIfHitAndRemove(final MouseEvent e) {

		/*
		 * precisa de MUITA optimizacao aqui + limpar codigo
		 * 
		 * o ideal eh pensar no raio (circulo) do bixo e aplicar o pitagoras
		 * entre o click e o centro do circulo.
		 * 
		 * se essa hipotenusa < raio do bixo : sucesso else fail
		 * 
		 * 
		 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				cantClick=GameThread.cantKill;
				for (Rat rat : Board.getInstance().getMyRats()) {
					int imageMultiplier = rat.getImageMultiplier();
					int imageSize = (gameGUI.boardPanel.getHeight()/10) * imageMultiplier;
					if (e.getX() - rat.getSpawnPoint().getX() - (imageSize/2) < (imageSize/2)
							&& e.getY() - rat.getSpawnPoint().getY() - (imageSize/2) < (imageSize/2)
							&& e.getX() - rat.getSpawnPoint().getX() - (imageSize/2) > -(imageSize/2)
							&& e.getY() - rat.getSpawnPoint().getY() - (imageSize/2) > -(imageSize/2)) {
						//int pointsWon = 10 / rat.getImageMultiplier();
						int pointsWon = 0;
						int bonusMultiplier;
						if (imageMultiplier == 3) bonusMultiplier = 1; 
						else if (imageMultiplier == 2) bonusMultiplier = 2;
						else bonusMultiplier = 3;
						double random = new Random().nextDouble();
						if (random >= 0.0 && random < 0.5 ) pointsWon = 10 * bonusMultiplier;
						else if (random >= 0.5 && random < 0.8 ) pointsWon = 6 * bonusMultiplier;
						else if (random >= 0.8 && random < 1.0 ) pointsWon = 2 * bonusMultiplier;
						gameGUI.addPoints(pointsWon);
						System.out.println("pontos ganhos: " + pointsWon);
						if (rat.isPoisoned()){
							double va5 = (new Random()).nextDouble();
							if ( va5 < 0.5 ) gameGUI.hpBar.hpHit(6);
							else if ( va5 >= 0.5 && va5 < (0.5 + (3.0 / 10.0)) ) gameGUI.hpBar.hpHit(4);
							else gameGUI.hpBar.hpHit(2);
						}
						Board.getInstance().getMyRats().remove(rat);
						Board.getInstance().changeNumOfAnimals("-", 1);
						setChanged();
						notifyObservers();
						break;
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (Roach roach : Board.getInstance().getMyRoaches()) {
					int imageMultiplier = roach.getImageMultiplier();
					int imageSize = (gameGUI.boardPanel.getHeight()/10) * imageMultiplier;
					if (e.getX() - roach.getSpawnPoint().getX() - (imageSize/2) < (imageSize/2)
							&& e.getY() - roach.getSpawnPoint().getY() - (imageSize/2) < (imageSize/2)
							&& e.getX() - roach.getSpawnPoint().getX() - (imageSize/2) > -(imageSize/2)
							&& e.getY() - roach.getSpawnPoint().getY() - (imageSize/2) > -(imageSize/2)) {
						//int pointsWon = 30 / roach.getImageMultiplier();
						int pointsWon = 0;
						int bonusMultiplier;
						if (imageMultiplier == 3) bonusMultiplier = 1; 
						else if (imageMultiplier == 2) bonusMultiplier = 2;
						else bonusMultiplier = 3;
						double random = new Random().nextDouble();
						if (random >= 0.0 && random < 0.5 ) pointsWon = 20 * bonusMultiplier;
						else if (random >= 0.5 && random < 0.8 ) pointsWon = 12 * bonusMultiplier;
						else if (random >= 0.8 && random < 1.0 ) pointsWon = 4 * bonusMultiplier;
						gameGUI.addPoints(pointsWon);
						System.out.println("pontos ganhos: " + pointsWon);
						if (roach.isPoisoned()){
							double va5 = (new Random()).nextDouble();
							if ( va5 < 0.5 ) gameGUI.hpBar.hpHit(6);
							else if ( va5 >= 0.5 && va5 < (0.5 + (3.0 / 10.0)) ) gameGUI.hpBar.hpHit(4);
							else gameGUI.hpBar.hpHit(2);
						}
						Board.getInstance().getMyRoaches().remove(roach);
						Board.getInstance().changeNumOfAnimals("-", 1);
						setChanged();
						notifyObservers();
						break;
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (Pigeon pigeon : Board.getInstance().getMyPigeons()) {
					int imageMultiplier = pigeon.getImageMultiplier();
					int imageSize = (gameGUI.boardPanel.getHeight()/10) * imageMultiplier;
					if (e.getX() - pigeon.getSpawnPoint().getX() - (imageSize/2) < (imageSize/2)
							&& e.getY() - pigeon.getSpawnPoint().getY() - (imageSize/2) < (imageSize/2)
							&& e.getX() - pigeon.getSpawnPoint().getX() - (imageSize/2) > -(imageSize/2)
							&& e.getY() - pigeon.getSpawnPoint().getY() - (imageSize/2) > -(imageSize/2)) {
						int pointsWon = 0;
						int bonusMultiplier;
						if (imageMultiplier == 3) bonusMultiplier = 1; 
						else if (imageMultiplier == 2) bonusMultiplier = 2;
						else bonusMultiplier = 3;
						double random = new Random().nextDouble();
						if (random >= 0.0 && random < 0.5 ) pointsWon = 30 * bonusMultiplier;
						else if (random >= 0.5 && random < 0.8 ) pointsWon = 18 * bonusMultiplier;
						else if (random >= 0.8 && random < 1.0 ) pointsWon = 6 * bonusMultiplier;
						gameGUI.addPoints(pointsWon);
						System.out.println("pontos ganhos: " + pointsWon);
						if (pigeon.isPoisoned()){
							double va5 = (new Random()).nextDouble();
							if ( va5 < 0.5 ) gameGUI.hpBar.hpHit(6);
							else if ( va5 >= 0.5 && va5 < (0.5 + (3.0 / 10.0)) ) gameGUI.hpBar.hpHit(4);
							else gameGUI.hpBar.hpHit(2);
						}
						Board.getInstance().getMyPigeons().remove(pigeon);
						Board.getInstance().changeNumOfAnimals("-", 1);
						setChanged();
						notifyObservers();
						break;
					}
				}
			}
		}).start();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
