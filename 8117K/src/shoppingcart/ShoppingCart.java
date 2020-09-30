/**
 * 
 */
package shoppingcart;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
/**
 * Mocking a shopping cart
 * @author donwen
 * @since 30 Sep 2020
 */
public class ShoppingCart {
	
	private List<Item> shoppingItems = new ArrayList<Item>();
	
	public void addProduct(Item product)
	{
		shoppingItems.add(product);
	}
	
	public void displayProducts() {
		float totalPrice = (float) shoppingItems.stream().mapToDouble(item -> item.getPrice()).sum();
		for (Item item:shoppingItems) {
			item.displayItem();
		}
		System.out.println(String.format("in all: %d items, worth $%.2f", shoppingItems.size(), totalPrice));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		
		final int n = 6;
		Random aR = new Random();
		int[] itemTypes = aR.ints(n, 1, 2+1).toArray();
		
		System.out.println("Creating shopping items...");
		for (int i=0; i<n; i++) {
			 Item item = null;
			 int itemType = itemTypes[i];
			 switch (itemType) {
			 case 1:
				 item = new Book("Red and Black", "MN009990", 99.9f, "A Book worth your attention", "Stendhal");
				 break;
			 case 2:
				 item = new GiftCard("Amazon GiftCard", "MN00888G", 990.9f, "Family blue style");
				 break;
			 default:
				 assert false : "itemType can only be 1 or 2";
			 	break;
			 }
			 cart.addProduct(item);
		}
		System.out.println(String.format("%d shopping items created.", n));
		
		cart.displayProducts();
	}

}
