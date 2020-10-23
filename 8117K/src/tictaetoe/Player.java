/**
 * 
 */
package tictaetoe;

/**
 * the base class for all players classes.
 * @author donwen
 *
 */
public abstract class Player implements Global {
	final protected String name;
	final protected int symbol;
	
	/**
	 * constructor
	 * @param name player's name
	 * @param symbol player's symbol
	 */
	public Player(String name, int symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	/**
	 * get the player's name
	 * @return the player's name
	 */
	public String getName( ) {
		return name;
	}
	
	/**
	 * get the string representation of the player
	 */
	public abstract String toString();
	
	/**
	 * play a block on the board.
	 * @param board the board on which to play block.
	 */
	public abstract void play(Board board);

}
