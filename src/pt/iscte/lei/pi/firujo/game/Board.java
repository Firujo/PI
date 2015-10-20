package pt.iscte.lei.pi.firujo.game;

import java.util.ArrayList;
import java.util.List;

import pt.iscte.lei.pi.firujo.bughierarchy.Mosquito;
import pt.iscte.lei.pi.firujo.bughierarchy.Rat;
import pt.iscte.lei.pi.firujo.bughierarchy.Roach;

public class Board {

	private static final Board board = new Board();

	public static Board getInstance() {
		return board;
	}

	private List<Rat> myRats = new ArrayList<Rat>();
	private List<Roach> myRoaches = new ArrayList<Roach>();
	private List<Mosquito> myMosquitos = new ArrayList<Mosquito>();

	public List<Rat> getMyRats() {
		return myRats;
	}

	public void setMyRats(List<Rat> myRats) {
		this.myRats = myRats;
	}

	public void addARat(Rat rat) {
		myRats.add(rat);
	}

	public List<Roach> getMyRoaches() {
		return myRoaches;
	}

	public void setMyRoaches(List<Roach> myRoaches) {
		this.myRoaches = myRoaches;
	}

	public void addARoach(Roach roach) {
		myRoaches.add(roach);
	}

	public List<Mosquito> getMyMosquitos() {
		return myMosquitos;
	}

	public void setMyMosquitos(List<Mosquito> myMosquitos) {
		this.myMosquitos = myMosquitos;
	}

	public void addAMosquito(Mosquito mosquito) {
		myMosquitos.add(mosquito);
	}
}
