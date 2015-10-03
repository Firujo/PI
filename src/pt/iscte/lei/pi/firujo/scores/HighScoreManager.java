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

	private ArrayList<Score> scores;

	private static final String HIGHSCORE_FILE = "highscores.dat";

	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;

	public HighScoreManager() {
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

	public ArrayList<Score> getScores() {
		loadScoreFile();
		sort();
		return scores;
	}

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

	private void sort() {
		ScoreComparator comparator = new ScoreComparator();
		Collections.sort(scores, comparator);
		updateScoreFile();

	}

	public void addScore(Score sc) {
		loadScoreFile();
		scores.add(sc);
		updateScoreFile();
	}

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

	public String getHighscoreString() {
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
