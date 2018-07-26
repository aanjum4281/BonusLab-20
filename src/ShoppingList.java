
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ShoppingList {

	public static void main(String[] args) {
		System.out.println("Welcome to the Grand Circus grocery store! ");
		System.out.println();

		// Key is item as a string, value is price as a double
		HashMap<String, Double> inventory = new HashMap<String, Double>();
		ArrayList<String> shoppingCart = new ArrayList<>();
		Scanner scnr = new Scanner(System.in);
		String cont;

		// fills the inventory
		inventory = fillinventory(inventory);

		// displays inventory
		displayInventory(inventory);

		do {
			// create a shoppingCart array list
			// add that item to the cart
			// "Enter Item name:"
			String prompt = "What would you like to order?";
			String newItem = enterItem(scnr, inventory, prompt);
			shoppingCart.add(newItem);

			// "Add another Item?
			// if yes then repeat to the top

			System.out.println("Add another item? (y/n) ");
			cont = scnr.nextLine().toLowerCase();
		} while (cont.startsWith("y"));

		System.out.println("Thanks for your order! These are your items: ");
		System.out.println(shoppingCart);
		System.out.println();
		// if no, display

		// average(); average price in cart
		average(shoppingCart, inventory);

		// highest(); priced item
		highest(shoppingCart, inventory);

		// lowest(); lowest price item in cart
		lowest(shoppingCart, inventory);
		scnr.nextLine();
	}

	private static void lowest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		
		double lowest = 0.0;

		for (String fruit : shoppingCart) {

			if (lowest < inventory.get(fruit)) {
				lowest = inventory.get(fruit);
			}
			// line 68 keeps printing twice and I don't know why.
			// I went through the debugger and that did not show
			// me why this line is printed twice
			
			System.out.println("The lowest priced item is $" + lowest);
		}

	}

	private static void highest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double highest = 0.0;
		for (String fruits : shoppingCart) {
			if (highest < inventory.get(fruits)) {
				highest = inventory.get(fruits);
			}
		}
		System.out.println("The highest priced item is $" + highest);
		System.out.println();
	}

	private static void average(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double sum = 0; // number of the total price added together
		int count = 0; // each item in the cart

		for (String fruits : shoppingCart) {

			// sum get the value of the key from the fruit
			sum += inventory.get(fruits);
			count++;
		}

		System.out.println("Average price is $" + sum / count);
		System.out.println();
	}

	private static String enterItem(Scanner scnr, HashMap<String, Double> inventory, String prompt) {
		String userInput;

		System.out.println(prompt);

		userInput = scnr.nextLine().toLowerCase();

		if (inventory.containsKey(userInput) == true) {
			System.out.println("Confirmation! " + userInput + " added to cart.");

			// else, repeat the method
		} else {
			System.out.println("Sorry, we are out of " + userInput + "!");
			enterItem(scnr, inventory, prompt);
		}

		return userInput;
	}

	private static HashMap<String, Double> fillinventory(HashMap<String, Double> inventory) {

		// Key is item as a string, value is price as a double
		inventory.put("apple", 0.99);
		inventory.put("banana", 0.59);
		inventory.put("cauliflower", 1.59);
		inventory.put("dragonfruit", 2.19);
		inventory.put("elderberry", 1.79);
		inventory.put("figs", 2.09);
		inventory.put("grapefruit", 1.99);
		inventory.put("honeydew", 3.49);

		return inventory;
	}

	private static void displayInventory(HashMap<String, Double> inventory) {
		// use a for loop
		String format = "%s\t\t%s";
		String format2 = "%-12s : %s";
		System.out.printf(format2, "Item", "Price");
		System.out.println("");
		System.out.println("====================");

		// loops through inventory by key which is the list of fruit
		for (String fruits : inventory.keySet()) {

			// this line prints out for each fruit
			System.out.printf(format2, fruits, inventory.get(fruits));
			System.out.println();
		}
	}

}
