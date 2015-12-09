package pt.iscte.lei.pi.firujo.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

import pt.iscte.lei.pi.firujo.bughierarchy.Pigeon;
import pt.iscte.lei.pi.firujo.bughierarchy.Rat;
import pt.iscte.lei.pi.firujo.bughierarchy.Roach;
import pt.iscte.lei.pi.firujo.gui.gameGUI;

public class MouseGameListener extends Observable implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getPoint());

		checkIfHitAndRemove(e);

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
				for (Rat rat : Board.getInstance().getMyRats()) {
					int imageMultiplier = rat.getImageMultiplier();
					int imageSize = (gameGUI.boardPanel.getHeight()/10) * imageMultiplier;
					if (e.getX() - rat.getSpawnPoint().getX() - (imageSize/2) < (imageSize/2)
							&& e.getY() - rat.getSpawnPoint().getY() - (imageSize/2) < (imageSize/2)
							&& e.getX() - rat.getSpawnPoint().getX() - (imageSize/2) > -(imageSize/2)
							&& e.getY() - rat.getSpawnPoint().getY() - (imageSize/2) > -(imageSize/2)) {
						int pointsWon = 30 / rat.getImageMultiplier();
						gameGUI.addPoints(pointsWon);
						System.out.println("pontos ganhos: " + pointsWon);
						Board.getInstance().getMyRats().remove(rat);
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
						int pointsWon = 30 / roach.getImageMultiplier();
						gameGUI.addPoints(pointsWon);
						System.out.println("pontos ganhos: " + pointsWon);
						Board.getInstance().getMyRoaches().remove(roach);
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
						int pointsWon = 30 / pigeon.getImageMultiplier();
						gameGUI.addPoints(pointsWon);
						System.out.println("pontos ganhos: " + pointsWon);
						Board.getInstance().getMyPigeons().remove(pigeon);
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
