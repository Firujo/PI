package pt.iscte.lei.pi.firujo.game;

import java.util.ArrayList;
import java.util.List;


import pt.iscte.lei.pi.firujo.bughierarchy.Pigeon;
import pt.iscte.lei.pi.firujo.bughierarchy.Rat;
import pt.iscte.lei.pi.firujo.bughierarchy.Roach;

public class Board {

	private static final Board board = new Board();

	public static Board getInstance() {
		return board;
	}

	private List<Rat> myRats = new ArrayList<Rat>();
	private List<Roach> myRoaches = new ArrayList<Roach>();
	private List<Pigeon> myPigeons = new ArrayList<Pigeon>();

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

	public List<Pigeon> getMyPigeons() {
		return myPigeons;
	}

	public void setMyPigeons(List<Pigeon> myPigeons) {
		this.myPigeons = myPigeons;
	}

	public void addAPigeon(Pigeon pigeon) {
		myPigeons.add(pigeon);
	}
}
