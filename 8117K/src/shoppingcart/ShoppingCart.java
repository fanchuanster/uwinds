/**
 * 
 */
package shoppingcart;

import java.util.Random;

/**
 * Mocking a shopping cart
 * @author donwen
 * @since 30 Sep 2020
 */
public class ShoppingCart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int n = 100;
		Random aR = new Random();
		int[] itemTypes = aR.ints(n, 1, 2+1).toArray();
		Item[] shoppingItems = new Item[n];
		
		System.out.println("Creating shopping items...");
		for (int i=0; i<n; i++) {
			 int itemType = itemTypes[i];
			 switch (itemType) {
			 case 1:
				 shoppingItems[i] = new Book("Red and Black", "MN009990", 99.9f, "A Book worth your attention", "Stendhal");
				 break;
			 case 2:
				 shoppingItems[i] = new GiftCard("Amazon GiftCard", "MN00888G", 990.9f, "Family blue style");
				 break;
			 default:
				 assert false : "itemType can only be 1 or 2";
			 	break;
			 }
		}
		System.out.println(String.format("%d shopping items created:", n));

	}

}
