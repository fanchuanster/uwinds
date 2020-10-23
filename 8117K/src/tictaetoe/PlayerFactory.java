/**
 * 
 */
package tictaetoe;

/**
 * @author donwen
 *
 */
public class PlayerFactory {
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
