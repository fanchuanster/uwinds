/**
 * 
 */
package tictaetoe;

import java.util.Random;
import java.util.Scanner;

/**
 * @author donwen
 *
 */
public class Game implements Global {
	
	private Player player_x;
	private Player player_o;
	
	private void choosePlayers() {
		System.out.println("Game Bot:Welcome to TicTacToe for the Java 212 Kobti class.");
		
		Scanner sc = new Scanner(System.in);
		int select = 0;
		while ( select != 1 && select != 2 && select != 3) {
			System.out.println("Game Bot:Please select players to play.");
			System.out.println("Game Bot:1 human to human; 2 human to bot; 3 bot to bot");
			
			select = sc.nextInt();
			sc.nextLine();
			System.out.println("You entered: " + select);
		}
		
		/*
		 * input name for players.
		 */
		System.out.println("Game Bot:Please enter name for first player.");
		String nameX = sc.nextLine();
		System.out.println("You entered: " + nameX);
		System.out.println("Game Bot:Please enter name for escond player.");
		String nameO = sc.nextLine();
		System.out.println("You entered: " + nameO);
		
		switch (select) {
		case 1:
			player_x = PlayerFactory.getPlayer("human", nameX, (int)'X');
			player_o = PlayerFactory.getPlayer("human", nameO, (int)'O');
			break;
		case 2:
			player_x = PlayerFactory.getPlayer("human", nameX, (int)'X');
			player_o = PlayerFactory.getPlayer("ai", nameO, (int)'O');
			break;
		case 3:
			player_x = PlayerFactory.getPlayer("ai", nameX, (int)'X');
			player_o = PlayerFactory.getPlayer("ai", nameO, (int)'O');
			break;
		}
		
	}
	
	
	/**
	 * start the game.
	 */
	public void start() {
		Board board = new Board();
		
		choosePlayers();
		
		Random aR = new Random();
		int dice = aR.nextInt(10);
		int turn = dice % 2;
		
		while (board.getState() == EMPTY) {
			System.out.println(String.format("--------turn %d---------", turn));
			board.displayBoard();
			
			switch (turn++ % 2) {
			case 0:
				player_x.play(board);
				break;
			case 1:
				player_o.play(board);
				break;
			default:
				System.out.println("Unknown player turn..");
				break;
			}
			
		}
		if (DRAW == board.getState()) {
			System.out.println(String.format("=====Game over with DRAW====="));
		} else {
			System.out.println(String.format("=====Game over, winner is %c", board.getState()));
		}		
		board.displayBoard();
	}

}
