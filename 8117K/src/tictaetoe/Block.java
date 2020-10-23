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
	
	public Block() {
		this.state = EMPTY;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String toString() {
		return String.format("%c", this.state);
	}

}
