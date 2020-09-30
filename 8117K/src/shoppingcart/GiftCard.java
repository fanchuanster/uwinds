/**
 * 
 */
package shoppingcart;

/**
 * Gift card item of shopping cart, inherited from Item @see shoppingcart.Item
 * @author donwen
 * @since 30 Sep 2020
 */
public class GiftCard extends Item {

	private String style;
	
	/**
	 * The sole constructor.
	 * @param name
	 * @param modelNumber
	 * @param price
	 */
	public GiftCard(String name, String modelNumber, float price, String style) {
		super(name, modelNumber, price);
		this.style = style;
//		System.out.println("GiftCard constructed");
	}

	@Override
	public void displayItem() {
		System.out.println(String.format("GiftCard - %s, #%d, %s, $%f, %s, %s", name, itemId, modelNumber, price, style));
	}

}
