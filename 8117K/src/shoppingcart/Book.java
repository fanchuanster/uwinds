
package shoppingcart;

/**
 * Book item of shopping cart, inherited from Item
 * @author donwen
 * @since 30 Sep 2020.
 */
public class Book extends Item {

	private String title;
	private String author;
	
	/**
	 * The sole constructor.
	 * @param name book name
	 * @param modelNumber model number
	 * @param price book price
	 * @param title book title
	 * @param author author of the book
	 */
	public Book(String name, String modelNumber, float price, String title, String author) {
		super(name, modelNumber, price);
		this.title = title;
		this.author = author;
	}

	@Override
	public void displayItem() {
		System.out.println(String.format("Book - <<%s>>, #%d, %s, $%.2f, %s, %s", name, itemId, modelNumber, price, title, author));
	}

}
