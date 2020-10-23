/**
 * 
 */
package tictaetoe;

/**
 * the factory of various players.
 * @author donwen
 *
 */
public class PlayerFactory {
	/**
	 * the main method of the player factory.
	 * @param playerType indicates what type of player to create - only accepts "human" or "ai"
	 * @param name the name of the player.
	 * @param symbol the symbol of the player.
	 * @return the created player if successfully created, otherwise null.
	 */
	static public Player getPlayer(String playerType, String name,  int symbol) {
		switch (playerType) {
		case "human":
			return new HumanPlayer(name, symbol);
		case "ai":
			return new AIPlayer(name, symbol);
		default:
			return null;
		}
	}

}
