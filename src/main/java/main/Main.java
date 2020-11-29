package main;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// Hopefully not needed
//		ConsoleService console = new ConsoleService();
//		console.printHello();
//		console.printMessageScreen("PLayer 1 Name?");
		
//		MechanicsService mechanics = new MechanicsService();
//		
//		mechanics.startGame();
		coin();
	}
	
	private static void coin() {
		Random rand = new Random();
		
		for (int i = 0; i < 20; i++) {
			System.out.println(rand.nextInt(3));
		}
	}
}
