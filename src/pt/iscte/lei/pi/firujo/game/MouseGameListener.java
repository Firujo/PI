package pt.iscte.lei.pi.firujo.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Observable;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import pt.iscte.lei.pi.firujo.bughierarchy.Bomb;
import pt.iscte.lei.pi.firujo.bughierarchy.Hp;
import pt.iscte.lei.pi.firujo.bughierarchy.Pigeon;
import pt.iscte.lei.pi.firujo.bughierarchy.Rat;
import pt.iscte.lei.pi.firujo.bughierarchy.Roach;
import pt.iscte.lei.pi.firujo.gui.gameGUI;

public class MouseGameListener extends Observable implements MouseListener {

	private boolean cantClick; 
	
	@Override
	public void mousePressed(MouseEvent e) {
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
						new Thread(new Runnable() {
							  // The wrapper thread is unnecessary, unless it blocks on the
							  // Clip finishing; see comments.
							    public void run() {
							      try {
							        Clip clip = AudioSystem.getClip();
							        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("sound" + File.separator + "ratdieing.wav"));
							        clip.open(inputStream);
							        clip.start(); 
							      } catch (Exception e) {
							        System.err.println(e.getMessage());
							      }
							    }
							  }).start();
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
						new Thread(new Runnable() {
							  // The wrapper thread is unnecessary, unless it blocks on the
							  // Clip finishing; see comments.
							    public void run() {
							      try {
							        Clip clip = AudioSystem.getClip();
							        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("sound" + File.separator + "cockroachdieing.wav"));
							        clip.open(inputStream);
							        clip.start(); 
							      } catch (Exception e) {
							        System.err.println(e.getMessage());
							      }
							    }
							  }).start();
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
						new Thread(new Runnable() {
							  // The wrapper thread is unnecessary, unless it blocks on the
							  // Clip finishing; see comments.
							    public void run() {
							      try {
							        Clip clip = AudioSystem.getClip();
							        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("sound" + File.separator + "pigeondieing.wav"));
							        clip.open(inputStream);
							        clip.start(); 
							      } catch (Exception e) {
							        System.err.println(e.getMessage());
							      }
							    }
							  }).start();
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
				cantClick=GameThread.cantKill;
				for (Bomb bomb : Board.getInstance().getMyBombs()) {
					int imageMultiplier = bomb.getImageMultiplier();
					int imageSize = (gameGUI.boardPanel.getHeight()/10) * imageMultiplier;
					if (e.getX() - bomb.getSpawnPoint().getX() - (imageSize/2) < (imageSize/2)
							&& e.getY() - bomb.getSpawnPoint().getY() - (imageSize/2) < (imageSize/2)
							&& e.getX() - bomb.getSpawnPoint().getX() - (imageSize/2) > -(imageSize/2)
							&& e.getY() - bomb.getSpawnPoint().getY() - (imageSize/2) > -(imageSize/2)) {
						//int pointsWon = 10 / rat.getImageMultiplier();
//						int pointsWon = 0;
//						int bonusMultiplier;
//						if (imageMultiplier == 3) bonusMultiplier = 1; 
//						else if (imageMultiplier == 2) bonusMultiplier = 2;
//						else bonusMultiplier = 3;
//						double random = new Random().nextDouble();
//						if (random >= 0.0 && random < 0.5 ) pointsWon = 10 * bonusMultiplier;
//						else if (random >= 0.5 && random < 0.8 ) pointsWon = 6 * bonusMultiplier;
//						else if (random >= 0.8 && random < 1.0 ) pointsWon = 2 * bonusMultiplier;
//						gameGUI.addPoints(pointsWon);
//						System.out.println("pontos ganhos: " + pointsWon);
//						if (rat.isPoisoned()){
//							double va5 = (new Random()).nextDouble();
//							if ( va5 < 0.5 ) gameGUI.hpBar.hpHit(6);
//							else if ( va5 >= 0.5 && va5 < (0.5 + (3.0 / 10.0)) ) gameGUI.hpBar.hpHit(4);
//							else gameGUI.hpBar.hpHit(2);
//						}
						Board.getInstance().getMyBombs().remove(bomb);
//						Board.getInstance().changeNumOfAnimals("-", 1);
						new Thread(new Runnable() {
							  // The wrapper thread is unnecessary, unless it blocks on the
							  // Clip finishing; see comments.
							    public void run() {
							      try {
							        Clip clip = AudioSystem.getClip();
							        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("sound" + File.separator + "bombexploding.wav"));
							        clip.open(inputStream);
							        clip.start(); 
							      } catch (Exception e) {
							        System.err.println(e.getMessage());
							      }
							    }
							  }).start();
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
				cantClick=GameThread.cantKill;
				for (Hp hp : Board.getInstance().getMyHps()) {
					int imageMultiplier = hp.getImageMultiplier();
					int imageSize = (gameGUI.boardPanel.getHeight()/10) * imageMultiplier;
					if (e.getX() - hp.getSpawnPoint().getX() - (imageSize/2) < (imageSize/2)
							&& e.getY() - hp.getSpawnPoint().getY() - (imageSize/2) < (imageSize/2)
							&& e.getX() - hp.getSpawnPoint().getX() - (imageSize/2) > -(imageSize/2)
							&& e.getY() - hp.getSpawnPoint().getY() - (imageSize/2) > -(imageSize/2)) {
						//int pointsWon = 10 / rat.getImageMultiplier();
//						int pointsWon = 0;
//						int bonusMultiplier;
//						if (imageMultiplier == 3) bonusMultiplier = 1; 
//						else if (imageMultiplier == 2) bonusMultiplier = 2;
//						else bonusMultiplier = 3;
//						double random = new Random().nextDouble();
//						if (random >= 0.0 && random < 0.5 ) pointsWon = 10 * bonusMultiplier;
//						else if (random >= 0.5 && random < 0.8 ) pointsWon = 6 * bonusMultiplier;
//						else if (random >= 0.8 && random < 1.0 ) pointsWon = 2 * bonusMultiplier;
//						gameGUI.addPoints(pointsWon);
//						System.out.println("pontos ganhos: " + pointsWon);
//						if (rat.isPoisoned()){
//							double va5 = (new Random()).nextDouble();
//							if ( va5 < 0.5 ) gameGUI.hpBar.hpHit(6);
//							else if ( va5 >= 0.5 && va5 < (0.5 + (3.0 / 10.0)) ) gameGUI.hpBar.hpHit(4);
//							else gameGUI.hpBar.hpHit(2);
//						}
						Board.getInstance().getMyHps().remove(hp);
//						Board.getInstance().changeNumOfAnimals("-", 1);
						setChanged();
						notifyObservers();
						break;
					}
				}
			}
		}).start();
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// N/A
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
