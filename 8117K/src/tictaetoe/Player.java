/**
 * 
 */
package tictaetoe;

/**
 * @author donwen
 *
 */
public abstract class Player implements Global {
	final protected String name;
	final protected int symbol;
	
	public Player(String name, int symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	public String getName( ) {
		return name;
	}
	
	public abstract String toString();
	
	public abstract void play(Board board);

}
