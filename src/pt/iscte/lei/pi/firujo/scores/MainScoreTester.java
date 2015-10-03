package pt.iscte.lei.pi.firujo.scores;
/*
*	Esta classe serve exclusivamente para testar a lista de highscores.
*	Não corram isto quando o trabalho estiver pronto ou podem estragar a lista de scores actual.
*/
public class MainScoreTester {

	public static void main(String[] args) {

		HighScoreManager hsm = new HighScoreManager();
		hsm.addScore(new Score("joao", 1200));
		hsm.addScore(new Score("filipe", 2));
		hsm.addScore(new Score("ruben", 3));
		hsm.addScore(new Score("jesus", 999));
		hsm.addScore(new Score("zrawraw", 12412));
		
		System.out.println(hsm);
		
	}
}
