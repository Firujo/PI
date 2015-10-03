package pt.iscte.lei.pi.firujo.scores;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {

	@Override
	public int compare(Score sc1, Score sc2) {
		if (sc1.getScore() > sc2.getScore()) {
			return -1;
		} else if (sc1.getScore() < sc2.getScore()) {
			return 1;
		} else
			return 0;
	}

}
