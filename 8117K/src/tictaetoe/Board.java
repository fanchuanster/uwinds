/**
 * 
 */
package tictaetoe;

/**
 * @author donwen
 *
 */
public class Board implements Global {
	private Block[][] blocks;

	/**
	 * the constructor.
	 */
	Board() {
		blocks = new Block[3][3];
	}
	
	/**
	 * output the board with block positions.
	 */
	void displayBoard() {
		for (int i=0; i<blocks.length; i++) {
			for (int j=0; j< blocks[i].length; j++) {
				System.out.print(String.format("%c ", blocks[i][j]));
			}
			System.out.println();
		}
	}
	
	/**
	 * calculate the game state from the distribution of the stated blocks.
	 * @return the state of the game board - EMPTY, DRAW, O, or X.
	 */
	int getState() {
		return EMPTY;
	}
}
