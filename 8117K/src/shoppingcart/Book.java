/**
 * 
 */
package shoppingcart;

/**
 * Book item of shopping cart, inherited from Item @see shoppingcart.Item
 * @author donwen
 * @since 30 Sep 2020
 */
public class Book extends Item {

	private String title;
	private String author;
	
	/**
	 * The sole constructor.
	 * @param name
	 * @param modelNumber
	 * @param price
	 */
	public Book(String name, String modelNumber, float price, String title, String author) {
		super(name, modelNumber, price);
		this.title = title;
		this.author = author;
//		System.out.println("Book constructed");
	}

	@Override
	public void displayItem() {
		System.out.println(String.format("Book - <<%s>>, #%d, %s, $%f, %s, %s", name, itemId, modelNumber, price, title, author));
	}

}
