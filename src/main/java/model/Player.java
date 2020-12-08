package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private List<Game> games;
	
	public Player() {
		this.games = new ArrayList<Game>(); 
	}
	
	public Player(String newName) {
		this.games = new ArrayList<Game>();
//		this.name = newName;
		setName(newName);
	}
	
	//TODO: some way to get total points of a player
	public Integer getPoints() {
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

}
