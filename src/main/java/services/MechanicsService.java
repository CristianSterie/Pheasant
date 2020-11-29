package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.Game;
import model.Player;
import utils.MechanicsConstants;

public class MechanicsService {
	
	private ConsoleService cs;
	private Scanner in;
	
	public MechanicsService() {
		this.cs = new ConsoleService();
		this.in = new Scanner(System.in);
	}

	//TODO: this should start game and all ingame machanics here
	public void startGame() {
		Game currentGame = new Game();
		
		// print hello message
		cs.printMessageScreen(MechanicsConstants.HELLO_MESSAGE);
		
		int totalGamesCounter = 0;
		
		while (!isThereAWinner(currentGame)) {
			totalGamesCounter++;
			
			// Winner copy for final screens
			Player winner = new Player();
			
			// welcome game
			cs.printMessageScreen(MechanicsConstants.GAME_MESSAGE + totalGamesCounter);
			
			// ask number of players
			currentGame = updateNumberOfPlayers(currentGame);
			// update all players names
			currentGame = updatePlayersNames(currentGame);
			
			// Fake counter for players
			int fkCounter = 0;
			
			cs.printFirstGameScreen(currentGame);
			
			while (!isThereAWinner(currentGame)) {
				String word = in.next();
				
				currentGame = makeAMove(currentGame, fkCounter, word);
				
				increaseCount(currentGame, fkCounter);
				
				cs.printGameScreen(currentGame, word, fkCounter);
			} // THE END OF THE GAME
			
			cs.printMessageScreen(MechanicsConstants.WINNER_MESSAGE + winner.getName());
			
			//XXX: might be needed another message here 
			
		}
		
		/* TEST */
		
	}
	
	private Integer increaseCount(Game game, Integer oldCount) {
		if (oldCount > game.getPlayers().size()) {
			oldCount = 0;
		} else {
			oldCount++;
		}
		
		return oldCount;
	}
	
	private Game makeAMove(Game game, int player, String word) {
		cs.printGameScreen(game, word, player);
		
		//TODO: one turn mechanics here
		
		return game;
	}
	
	private Boolean isThereAWinner(Game game) {
		for (Player player : game.getPlayers()) {
			if (player.getPoints() > MechanicsConstants.WINNER_CONDITION) {
				return true;
			}
		}
		
		return false;
	}
	
	/* MENU METHODS */
	
	private Player updatePlayerName(Player player) {
		cs.printMessageScreen(MechanicsConstants.ASK_PLAYER_NAME);
		
		String newName = in.next();
		player.setName(newName);
		
		return player;
	}
	
	/* GAMEPLAY SCREENS */
	
	private Game updateNumberOfPlayers(Game game) {
		cs.printMessageScreen(MechanicsConstants.ASK_NO_PLAYERS);
		
		String newPlayers = in.next();
//		game.setNoPlayers(newPlayers);
		
		return game;
	}
	
	private Game updatePlayersNames(Game game) {
		List<Player> updatedPlayers = new ArrayList<>();
		
		game.getPlayers().forEach(player -> {
			updatedPlayers.add(updatePlayerName(player));
		});
		
		game.setPlayers(updatedPlayers);
		
		return game;
	}
}
