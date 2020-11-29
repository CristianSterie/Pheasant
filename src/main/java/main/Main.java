package main;

import services.ConsoleService;

public class Main {

	public static void main(String[] args) {
		// Hopefully not needed
		ConsoleService console = new ConsoleService();
		console.printHello();
		console.printMessageScreen("PLayer 1 Name?");
		
//		MechanicsService mechanics = new MechanicsService();
//		
//		mechanics.startGame();
	}

}
