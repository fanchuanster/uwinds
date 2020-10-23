/**
 * 
 */
package tictaetoe;

/**
 * @author donwen
 *
 */
public abstract class Player {
	private String name;
	private int symbol;
	
	public Player(String name, int symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	public String toString() {
		return String.format("%s _%c", this.name, this.symbol);
	}
	
	public abstract void paly(Board board);

}
