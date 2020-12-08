package services;

import java.util.List;

import model.Game;
import model.Player;
import utils.ConsoleConstants;

public class ConsoleService {

	/* PRINT METHODS */

	public void printHello() {
		// First let's clear the screen
		clearScreen();
		
		StringBuilder sb = new StringBuilder();

		sb.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_ENTER).append(ConsoleConstants.HELLO_MESSAGE)
				.append(ConsoleConstants.SCREEN_ENTER).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER);

		System.out.println(sb.toString());
	}

	/**
	 * Prints a formatted message. The message is centered in and filled with ***
	 * above and below
	 * 
	 * @param message The message to print
	 */
	public void printMessageScreen(String message) {
		// First let's clear the screen
		clearScreen();
				
		StringBuilder sb = new StringBuilder();

		sb.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_ENTER);

		Integer spaces = (ConsoleConstants.SCREEN_LINE.length() - message.length()) / 2;

		for (int i = 0; i < (spaces > 0 ? spaces : 0); i++) {
			sb.append(ConsoleConstants.SPACE);
		}

		sb.append(message);

		for (int i = 0; i < (spaces > 0 ? spaces : 0); i++) {
			sb.append(ConsoleConstants.SPACE);
		}

		sb.append(ConsoleConstants.SCREEN_ENTER).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER)
				.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER);

		System.out.println(sb.toString());
	}
	
	public void printFirstGameScreen(Game game) {
		// First let's clear the screen
		clearScreen();
				
		StringBuilder sb = new StringBuilder();
		
		sb.append(getScoreBoard(game.getPlayers()))
			.append(ConsoleConstants.SCREEN_ENTER)
			.append(ConsoleConstants.SCREEN_ENTER)
			.append(ConsoleConstants.FIRST_MESSAGE)
			.append(ConsoleConstants.SCREEN_LINE)
			.append(ConsoleConstants.SCREEN_ENTER)
			.append(ConsoleConstants.SCREEN_LINE)
			.append(ConsoleConstants.SCREEN_ENTER);
		
		System.out.println(sb.toString());
	}
	
	public void printGameScreen(Game game, String message, int player) {
		// First let's clear the screen
		clearScreen();
				
		StringBuilder sb = new StringBuilder();
		
		sb.append(getScoreBoard(game.getPlayers()))
			.append(ConsoleConstants.SCREEN_ENTER)
			.append(ConsoleConstants.GAME_LAST_WORD)
			.append(message)
			.append(ConsoleConstants.SCREEN_ENTER)
			.append(ConsoleConstants.LABEL_PLAYER_GENERIC)
			.append(player)
			.append(ConsoleConstants.LBL_PLR_HALF)
			.append(ConsoleConstants.SCREEN_ENTER)
			.append(ConsoleConstants.SCREEN_LINE)
			.append(ConsoleConstants.SCREEN_ENTER)
			.append(ConsoleConstants.SCREEN_LINE)
			.append(ConsoleConstants.SCREEN_ENTER);
		
		System.out.println(sb.toString());
	}
	
	/* HELPER METHODS */

	@Deprecated
	@SuppressWarnings("unused")
	private String getScreen() {
		StringBuilder sb = new StringBuilder();
//		sb.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER).append(getScoreBoard())
//				.append(getPlayBoard()).append(ConsoleConstants.SCREEN_ENTER).append(ConsoleConstants.SCREEN_LINE);

		return sb.toString();
	}

	/**
	 * Returns a String object containing the format as example:
	 * <p>
	 * ****************************
	 * <p>
	 * P1: Andrei - 2 pct *********
	 * <p>
	 * P2: George - 3 pct *********
	 * <p>
	 **************************** <p>
	 * 
	 * @param playerList The list of players to get data from
	 * @return formatted String as example with the list of players
	 */
	private String getScoreBoard(List<Player> playerList) {
		StringBuilder sb = new StringBuilder();

		playerList.forEach(player -> {
			sb.append(getPlayerLine(player));
		});

		sb.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER);

		return sb.toString();
	}

	// TODO: Implement Specific Gamplay Screen: (@see model: fazan.model)
	private String getPlayBoard() {
		StringBuilder sb = new StringBuilder();

		sb.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER)
//			.append(geSpecificSCreen())
				.append(ConsoleConstants.SCREEN_LINE).append(ConsoleConstants.SCREEN_ENTER);

		return sb.toString();
	}

	/**
	 * Returns as a String a line filled as the example: ( P1: Andrei - 2 pct
	 * ********* ), with * dynamically at the end ;)
	 * 
	 * @param player The Player object to get data (name, points) from
	 * @return A full formatted line as the example but with current data from
	 *         player
	 */
	private String getPlayerLine(Player player) {
		StringBuilder sb = new StringBuilder();

		sb.append(ConsoleConstants.LABEL_PLAYER_1).append(player.getName()).append(ConsoleConstants.MINUS)
				.append(player.getPoints());

		Integer lengthSoFar = ConsoleConstants.LABEL_PLAYER_1.length() + player.getName().length()
				+ +ConsoleConstants.MINUS.length() + player.getPoints().toString().length();

		for (int i = 0; i < ConsoleConstants.SCREEN_LINE.length() - lengthSoFar; i++) {
			sb.append("*");
		}

		sb.append(ConsoleConstants.SCREEN_ENTER);

		return sb.toString();
	}

	@Deprecated
	@SuppressWarnings("unused")
	private String createScreen() {
		StringBuilder sb = new StringBuilder();

		return sb.toString();
	}
	
	/**
	 * This method clears the screen in Windows CLI only
	 */
    public static void clearScreen(){
        try {

            if (System.getProperty("os.name").contains("Windows")) {
            	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
            	Runtime.getRuntime().exec("clear");
            }

        } catch (Exception ex) {
        	// If any Exception occurs print generic message and exception message
        	System.out.println(ConsoleConstants.EX_MESSAGE_CLRSCR);
        	System.out.println(ex.getMessage());
        }
    }

	/* GETTER AND SETTERS */

}
