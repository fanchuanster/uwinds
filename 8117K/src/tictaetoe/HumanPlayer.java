/**
 * 
 */
package tictaetoe;
import java.util.Scanner;

/**
 * @author donwen
 *
 */
public class HumanPlayer extends Player {
	private Scanner scanner = new Scanner(System.in);

	/**
	 * @param name
	 * @param symbol
	 */
	public HumanPlayer(String name, int symbol) {
		super(name, symbol);
	}

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
				System.out.println("Failed to play " + number);
			}
		}
		
	}

	@Override
	public String toString() {
		return String.format("HumanPlayer %s _%c", this.name, this.symbol);
	}

}
