package pt.iscte.lei.pi.firujo.scores;

import java.util.Comparator;

/*
*	Comparador de resultados, recebe 2 e devolve o resultado - maior - menor - igual em int.
*	-1 : maior é o primeiro
*	1  : maior é o segundo
*	0  : são iguais
*/
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
