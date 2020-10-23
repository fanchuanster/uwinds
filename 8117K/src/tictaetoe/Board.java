/**
 * 
 */
package tictaetoe;
import java.util.Arrays;

/**
 * representation of the game borad.
 * @author donwen
 *
 */
public class Board implements Global {
	private Block[][] blocks;
	
	/**
	 * return the state if all blocks are with a same valid state X or O, otherwise EMPTY.
	 * @param blocks to check.
	 * @return the state of the blocks as an array.
	 */
	private int getArrayState(Block[] blocks) {
		boolean allmatch = Arrays.stream(blocks).allMatch(b -> b.getState() == blocks[0].getState());
		if (allmatch) {
			return blocks[0].getState();
		} else {
			return EMPTY;
		}
	}

	/**
	 * the constructor.
	 */
	public Board() {
		blocks = new Block[3][3];
		for (int i=0; i<blocks.length; i++) {
			for (int j=0; j<blocks[i].length; j++) {
				blocks[i][j] = new Block(i, j);
			}
		}			
	}
	
	/**
	 * get all blocks on the board.
	 * @return all the blocks in two-dimension array
	 */
	public Block[][] getBlocks() {
		return blocks;
	}
	
	/**
	 * output the board with block positions.
	 */
	public void displayBoard() {
		for (int i=0; i<blocks.length; i++) {
			for (int j=0; j< blocks[i].length; j++) {
				System.out.print(String.format("%s ", blocks[i][j].toString()));
			}
			System.out.println();
		}
	}
	
	
	/**
	 * calculate the game state from the distribution of the stated blocks.
	 * @return the state of the game board - EMPTY, DRAW, O, or X.
	 */
	public int getState() {
		
		/*
		 * check rows
		 */
		for (int i=0; i<this.blocks.length; i++) {
			int arrayState = getArrayState(this.blocks[i]);
			if (arrayState != EMPTY) {
				return arrayState;
			}
		}
		
		/*
		 * check columns
		 */
		for (int i=0; i<this.blocks.length; i++) {
			int arrayState = getArrayState(new Block[] {this.blocks[0][i], this.blocks[1][i], this.blocks[2][i]});
			if (arrayState != EMPTY) {
				return arrayState;
			}
		}
		
		/*
		 * check diagonals
		 */
		int arrayState = getArrayState(new Block[] {this.blocks[0][0], this.blocks[1][1], this.blocks[2][2]});
		if (arrayState != EMPTY) {
			return arrayState;
		}
		arrayState = getArrayState(new Block[] {this.blocks[0][2], this.blocks[1][1], this.blocks[2][0]});
		if (arrayState != EMPTY) {
			return arrayState;
		}
		
		/*
		 * check draw
		 */
		boolean anyEmpty = false;
		for (int i=0; i<blocks.length && !anyEmpty; i++) {
			for (int j=0; j<blocks[i].length; j++) {
				if (EMPTY == blocks[i][j].getState()) {
					anyEmpty = true;
				}
			}
		}
		
		if (anyEmpty)
			return EMPTY;
		else
			return DRAW;
	}
}
