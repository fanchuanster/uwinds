/**
 * 
 */
package shoppingcart;

/**
 * Gift card item of shopping cart, inherited from Item 
 * @author donwen
 * @since 30 Sep 2020
 */
public class GiftCard extends Item {

	private String style;
	
	/**
	 * The sole constructor.
	 * @param name giftcard name
	 * @param modelNumber gc model number
	 * @param price item price
	 * @param style gift style
	 */
	public GiftCard(String name, String modelNumber, float price, String style) {
		super(name, modelNumber, price);
		this.style = style;
//		System.out.println("GiftCard constructed");
	}

	@Override
	public void displayItem() {
		System.out.println(String.format("GiftCard - %s, #%d, %s, $%.2f, %s", name, itemId, modelNumber, price, style));
	}

}
