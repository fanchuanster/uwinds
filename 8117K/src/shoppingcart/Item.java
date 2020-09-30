
package shoppingcart;

/**
 * The abstract base class for shopping cart commodity items.
 * 
 * @author donwen
 * @since 30 Sep 2020
 *
 */

public abstract class Item {
	protected String name;
	protected int itemId;
	protected String modelNumber;
	protected float price;
	
	private static int idPivot = 0;
	
	public Item(String name, String modelNumber, float price) {
		this.name = name;
		this.itemId = GetUniqueSequentialId();
		this.modelNumber = modelNumber;
		this.price = price;
//		System.out.println("Item constructed");
	}
	
	
	/*
	 * Print out the details information of the item.
	 */
	public abstract void displayItem();
	
	/*
	 * A helper static method for generating incremental integer.
	 * @return next sequential Id.
	 */
	private static int GetUniqueSequentialId() {	
		idPivot++;
		return idPivot;
	}

}
