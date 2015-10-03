package pt.iscte.lei.pi.firujo.scores;

import java.io.Serializable;

/*
* 	objecto score, contem um nome string e resultado int
*	serializable para se poder gravar o estado do objecto em ficheiro 
*/
public class Score implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int score;
	private String name;
	
	public Score(String name, int score){
		this.score = score;
		this.name = name;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public String getName(){
		return this.name;
	}

}
