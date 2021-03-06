package pt.iscte.lei.pi.firujo.game;

import java.io.File;
import java.util.Observable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.plaf.SliderUI;

import pt.iscte.lei.pi.firujo.bughierarchy.Bomb;
import pt.iscte.lei.pi.firujo.bughierarchy.Hp;
import pt.iscte.lei.pi.firujo.bughierarchy.Pigeon;
import pt.iscte.lei.pi.firujo.bughierarchy.Rat;
import pt.iscte.lei.pi.firujo.bughierarchy.Roach;
import pt.iscte.lei.pi.firujo.gui.HpBar;
import pt.iscte.lei.pi.firujo.gui.gameGUI;
import pt.iscte.lei.pi.firujo.main.Main;
import pt.iscte.lei.pi.firujo.scores.HighScoreManager;
import pt.iscte.lei.pi.firujo.scores.Score;
import pt.iscte.lei.pi.firujo.utils.DiscreteRandomVariable;

public class GameThread extends Observable implements Runnable {
	private long last;
	private int timeBetweenBugSpawning;
	private int actualMinute;
	private int gameLvl = 1;
	public static boolean cantKill=false;

	public GameThread() {
		last = System.currentTimeMillis();
		timeBetweenBugSpawning = 2;
	}

	@Override
	public void run() {

		playBackgroundMusic();
		while (!Thread.interrupted()) { // logo se vê como vamos parar o jogo
			actualMinute=gameGUI.cronometro.getMinutos();
			if(actualMinute < 2 && !gameGUI.hpBar.isDead()){
				if (System.currentTimeMillis() - last > TimeUnit.SECONDS.toMillis(timeBetweenBugSpawning)) {
					
					gameGUI.hpBar.hpHit(10 * Board.getInstance().getNumOfAnimals());
					gameGUI.hpBar.repaint();
					actualMinute=gameGUI.cronometro.getMinutos();
					int seconds = gameGUI.cronometro.getSegundos();
					if (actualMinute < 1 && seconds >= 20 && seconds < 60) gameLvl = 2;
					else if (actualMinute >= 1) gameLvl = 3;
					
					if (actualMinute >= 1 && seconds < 45) spawnBug();
					else if (actualMinute >= 1 && seconds >= 45){
						spawnBug();
						spawnBug();
					}
					spawnBug();

					last = System.currentTimeMillis();
					timeBetweenBugSpawning = 1;

					this.setChanged();
					this.notifyObservers();
				}
			}else{
//				System.out.println("YOU DIED!!!!");
				cantKill=true;
				Thread.currentThread().interrupt();
				//acao que se deve fazer quando acaba - nova janela e pedir nome ?
//				System.exit(0);
			}
		}
		Object nickname = JOptionPane.showInputDialog("Game Over!\nPlease enter your nickname:");
		
		if(nickname != null && nickname != ""){
			HighScoreManager hsm = new HighScoreManager();
			hsm.addScore(new Score(nickname.toString(), gameGUI.points));
		}
		
		System.exit(0);
	}

	private void playBackgroundMusic() {
		new Thread(new Runnable() {
			  // The wrapper thread is unnecessary, unless it blocks on the
			  // Clip finishing; see comments.
			    public void run() {
			      try {
			        Clip clip = AudioSystem.getClip();
			        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("sound" + File.separator + "bgmusic.wav"));
			        clip.open(inputStream);
			        clip.start(); 
			      } catch (Exception e) {
			        System.err.println(e.getMessage());
			      }
			    }
			  }).start();
	}

	private void spawnBug() {
		
		//DiscreteRandomVariable drv = new DiscreteRandomVariable(0, 2);
		int choice = 0;
		//V.A. discreta 1)
		double va1 = (new Random()).nextDouble();
		if ( va1 < 0.5 ) choice = 0;
		else if ( va1 >= 0.5 && va1 < (0.5 + (1.0 / 3.0)) ) choice = 2;
		else choice = 1;
		
		double va7 = (new Random()).nextDouble();
		if ( va7 < 0.1 ){
			Bomb bomb = new Bomb(gameLvl);
			Board.getInstance().addABomb(bomb);
		} else if ( va7 >= 0.1 && va7 < 0.2){
			Hp hp = new Hp(1);
			Board.getInstance().addHP(hp);
		}
		
		switch (choice) {
		case 0:
			Rat rat = new Rat(gameLvl);
			Board.getInstance().addARat(rat);
			Board.getInstance().changeNumOfAnimals("+", 1);
			break;
		case 1:
			Pigeon pigeon = new Pigeon(gameLvl);
			Board.getInstance().addAPigeon(pigeon);
			Board.getInstance().changeNumOfAnimals("+", 1);
			break;
		case 2:		
			Roach roach = new Roach(gameLvl);
			Board.getInstance().addARoach(roach);
			Board.getInstance().changeNumOfAnimals("+", 1);
			break;
		default:
			System.out.println("DiscreveRandomVariable is wrong!");
			break;
		}
		
	}

}
