/**
 * 
 */
package tictaetoe;

/**
 * represent a block on the game bord.
 * @author donwen
 *
 */
public class Block implements Global {
	
	private int state;
	public final int X;
	public final int Y;
	
	/**
	 * constructor
	 * @param x coordinate x
	 * @param y coordinate y
	 */
	public Block(int x, int y) {
		this.state = EMPTY;
		this.X = x;
		this.Y = y;
	}
	
	/**
	 * get the state of the block - empty, or occupied by player's symbol.
	 * @return the statue of the block.
	 */
	public int getState() {
		return state;
	}
	
	/**
	 * set state of the block.
	 * @param state the state to set.
	 * @return indicate whether the operation is completed successfully.
	 */
	public boolean setState(int state) {
		if (this.state != EMPTY) {
			return false;
		}
		this.state = state;
		return true;
	}
	
	/**
	 * get the string representation of the block.
	 */
	public String toString() {
		if (this.state != EMPTY) {
			return String.format("%c", this.state);
		} else {
			return String.format("%d", this.X * 3 + this.Y + 1);
		}
		
	}

}
