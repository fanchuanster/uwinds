package tictaetoe;

import java.util.Random;

/**
 * the implementation of a AIPlayer
 * @author donwen
 *
 */
public class AIPlayer extends Player {
	
	private Random aR = new Random();

	/**
	 * the constructor of the AIPlayer
	 * @param name name of the player.
	 * @param symbol symbol of the player.
	 */
	public AIPlayer(String name, int symbol) {
		super(name, symbol);
	}


	/**
	 * play a position on the given board.
	 * @param board the board on which to play position.
	 */
	@Override
	public void play(Board board) {
		Block playBlock = senseWin(board);
		if (playBlock != null) {
			playBlock.setState(this.symbol);
//			System.out.println(String.format("sensed win (%d,%d)", playBlock.X, playBlock.Y));
			return;
		}
		playBlock = senseLoss(board);
		if (playBlock != null) {
			playBlock.setState(this.symbol);
//			System.out.println(String.format("sensed loss (%d,%d)", playBlock.X, playBlock.Y));
			return;
		}
		
		Block[][] blocks = board.getBlocks();
		
		Block middleBlock = blocks[1][1];
		if (middleBlock.setState(this.symbol)) {
			return;
		}
		
		/*
		 * pick a random empty block to play. 
		 */
		boolean played = false;
		int r = aR.nextInt(9);
//		System.out.println(String.format("sensed none random r %d", r));
		
		for (int i=0; i<blocks.length && !played; i++) {
			for (int j=0; j<blocks[i].length; j++) {
				if (blocks[i][j].getState() == EMPTY) {
					if (r == 0) {
						boolean ret = blocks[i][j].setState(this.symbol);
						System.out.println(String.format("random play (%d,%d)", i, j));
						assert ret : "Cannot play block";
						assert blocks[i][j].X==i : "X wrong";
						assert blocks[i][j].Y==j : "Y wrong";
						played = true;
						break;
					}
					r--;
//					System.out.println(String.format("r = " + r));
				}
			}
			
			/*
			 * circulate.
			 */
			if (i == blocks.length) {
				i = 0;
			}
		}
	}
	
	/**
	 * check if in the given array there is a win chance
	 * @param blocks the blocks to check
	 * @return the win block in the array, null if no such case.
	 */
	private Block senseWin(Block[] blocks) {
		Block win = null;
		int emptyCount = 0;
		int myBlocksCount = 0;
		for (int i=0; i<blocks.length; i++) {
			if (this.symbol == blocks[i].getState()) {
				myBlocksCount++;
			} else if (EMPTY == blocks[i].getState()) {
				emptyCount++;
				win = blocks[i];
			}
		}
		if (emptyCount == 1 && myBlocksCount == blocks.length - 1) {
			return win;
		} else {
			return null;
		}
	}
	
	/**
	 * check if in the given array there is a block which can lead to loss if play by opponent
	 * @param blocks the blocks to check
	 * @return the index of the loss block in the array, -1 if no such case.
	 */
	private Block senseLoss(Block[] blocks) {
		Block loss = null;
		int emptyCount = 0;
		int enemyBlocksCount = 0;
		for (int i=0; i<blocks.length; i++) {
			if (EMPTY == blocks[i].getState()) {
				emptyCount++;
				loss = blocks[i];
			} else if (this.symbol != blocks[i].getState()) {
				enemyBlocksCount++;
			} 
		}
		if (emptyCount == 1 && enemyBlocksCount == blocks.length - 1) {
			return loss;
		} else {
			return null;
		}
	}
	
	/**
	 * sense the VIP block that can lead to a win.
	 * @param board the board.
	 * @return the loss block.
	 */
	private Block senseWin(Board board) {
		Block[][] blocks = board.getBlocks();
		/*
		 * check rows
		 */
		for (int i=0; i<blocks.length; i++) {
			Block win = senseWin(blocks[i]);
			if (win != null) {
				return win;
			}
		}
		
		/*
		 * check columns
		 */
		for (int i=0; i<blocks.length; i++) {
			Block win = senseWin(new Block[] { blocks[0][i], blocks[1][i], blocks[2][i] });
			if (win != null) {
				return win;
			}
		}
		
		/*
		 * check diagonals
		 */
		Block win = senseWin(new Block[] { blocks[0][0], blocks[1][1], blocks[2][2] });
		if (win != null) {
			return win;
		}
		win = senseWin(new Block[] { blocks[0][2], blocks[1][1], blocks[2][0] });
		if (win != null) {
			return win;
		}
		
		return null;
	}
	
	/**
	 * sense the VIP block that can lead to loss if it's played by the opponent.
	 * @param board the board.
	 * @return the loss block.
	 */
	private Block senseLoss(Board board) {
		Block[][] blocks = board.getBlocks();
		
		/*
		 * check rows
		 */
		for (int i=0; i<blocks.length; i++) {
			Block loss = senseLoss(blocks[i]);
			if (loss != null) {
				return loss;
			}
		}
		
		/*
		 * check columns
		 */
		for (int i=0; i<blocks.length; i++) {
			Block loss = senseLoss(new Block[] { blocks[0][i], blocks[1][i], blocks[2][i] });
			if (loss != null) {
				return loss;
			}
		}
		
		/*
		 * check diagonals
		 */
		Block loss = senseLoss(new Block[] { blocks[0][0], blocks[1][1], blocks[2][2] });
		if (loss != null) {
			return loss;
		}
		loss = senseLoss(new Block[] { blocks[0][2], blocks[1][1], blocks[2][0] });
		if (loss != null) {
			return loss;
		}
		
		return null;
	}


	/**
	 * get a string representation of the player.
	 */
	@Override
	public String toString() {
		return String.format("AIPlayer %s _%c", this.name, this.symbol);
	}

}
