/**
 * 
 */
package tictaetoe;

/**
 * @author donwen
 *
 */
public class Block implements Global {
	
	private int state;
	public final int X;
	public final int Y;
	
	public Block(int x, int y) {
		this.state = EMPTY;
		this.X = x;
		this.Y = y;
	}
	public int getState() {
		return state;
	}
	public boolean setState(int state) {
		if (this.state != EMPTY) {
			return false;
		}
		this.state = state;
		return true;
	}
	public String toString() {
		if (this.state != EMPTY) {
			return String.format("%c", this.state);
		} else {
			return String.format("%d", this.X * 3 + this.Y + 1);
		}
		
	}

}
