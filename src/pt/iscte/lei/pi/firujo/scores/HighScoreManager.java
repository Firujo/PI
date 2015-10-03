package pt.iscte.lei.pi.firujo.scores;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class HighScoreManager {

	// lista de scores
	private ArrayList<Score> scores;

	// ficheiro onde vamos guardar scores - é .dat para ninguem modificar e dar banhada nos resultados :D
	private static final String HIGHSCORE_FILE = "highscores.dat";

	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;

	public HighScoreManager() {
		//se ainda nao existir o ficheiro (1o carregamento) ele cria
		File scoresdat = new File(HIGHSCORE_FILE);
		if (!scoresdat.exists()) {
			try {
				scoresdat.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		scores = new ArrayList<Score>();

	}

	/*
	* Retorna uma lista de resultados ordenada do melhor para o pior
	*/
	public ArrayList<Score> getScores() {
		loadScoreFile();
		sort();
		return scores;
	}

	/*
	*	Lê o ficheiro scores.dat e carrega a lista no array de scores
	*/ 
	private void loadScoreFile() {
		try {
			ois = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
			scores = (ArrayList<Score>) ois.readObject();
		} catch (EOFException e) {
			System.out.println("first load");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	*	Ordenar a lista de scores, do melhor para o pior
	*/
	private void sort() {
		ScoreComparator comparator = new ScoreComparator();
		Collections.sort(scores, comparator);
		updateScoreFile();

	}
	
	/*
	*	Funcao para adicionar score à lista
	*/
	public void addScore(Score sc) {
		loadScoreFile();
		scores.add(sc);
		updateScoreFile();
	}

	/*
	*	Escrever a lista de scores actualizada (depois de nova entrada) no ficheiro scores.dat
	*/
	private void updateScoreFile() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
			oos.writeObject(scores);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	*	Mandar os top scores para a consola	
	*/ 
	@Override
	public String toString() {
		String highscoreString = "";
		int topmax = 3;

		ArrayList<Score> scores;

		scores = getScores();

		int i = 0;
		int x = scores.size();

		if (x > topmax) {
			x = topmax;
		}

		while (i < x) {
			highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
			i++;
		}
		return highscoreString;
	}
}
