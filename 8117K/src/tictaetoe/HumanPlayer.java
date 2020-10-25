/**
 * 
 */
package tictaetoe;
import java.util.Scanner;

/**
 * represents a human player
 * @author donwen
 *
 */
public class HumanPlayer extends Player {
	private Scanner scanner = new Scanner(System.in);

	/**
	 * constructor of the class.
	 * @param name player's name
	 * @param symbol player's symbol
	 */
	public HumanPlayer(String name, int symbol) {
		super(name, symbol);
	}

	/**
	 * play a position on the given board.
	 * @param board the board on which to play block.
	 */
	@Override
	public void play(Board board) {
		boolean played = false;
		while (!played) {
			System.out.println(toString() + ", Select the position number you would like to play");
			int number = scanner.nextInt();
			int index = number -1;
			int x = index / 3;
			int y = index % 3;
			
			if (x<0 || x>2 || y<0 || y>2)
				continue;
			Block block = board.getBlocks()[x][y];
			if (block.setState(this.symbol)) {
				played = true;
			} else {
				System.out.println("Cannot play position " + number);
			}
		}		
	}
	
	/**
	 * get the string representation of the player.
	 * @return  the string representation of the player.
	 */

	@Override
	public String toString() {
		return String.format("HumanPlayer %s _%c", this.name, this.symbol);
	}

}
