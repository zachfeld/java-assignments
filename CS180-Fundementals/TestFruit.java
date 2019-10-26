package shell;
import java.util.Scanner;

/*
 * X.Page Fall 2018, Solution to assignment 6
 * Assumes that user will input valid data types (integer when expected, etc)
 */
public class TestFruit {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		System.out.println("How many kinds of fruit would you like to order?"); 
		int numKinds = kb.nextInt(); // assumes this is positive number
		kb.nextLine();
		
		Fruit [] fruits = new Fruit[numKinds];
		for (int i = 0; i < numKinds; i++) {
			fruits[i] = new Fruit();
			System.out.println("What is the name of fruit " + (i+1) + "?");
			fruits[i].setName(kb.nextLine());
			System.out.println("What type of fruit is it? (1-fresh, 2-frozen, 3-canned, 4-dried)?");
			fruits[i].setType(kb.nextInt());
			System.out.println("How many ounces does each item weight?");
			fruits[i].setWeight(kb.nextInt());
			System.out.println("How many would you like to order?");
			fruits[i].setNumItems(kb.nextInt());
			kb.nextLine();
		}
		System.out.println("************************************************");
		for (int i = 0; i < numKinds; i++) {
			
			String typeText = "";
			switch (fruits[i].getType()) {
			case 1: 
				typeText = "fresh"; 
				break;
			case 2: 
				typeText = "frozen"; 
				break;
			case 3: 
				typeText = "canned"; 
				break;
			case 4: 
				typeText = "dried"; 
				break;
			}
			
			System.out.println(fruits[i].getName() + " (" + typeText + ") " + fruits[i].getItemWeight() +
					" ounces each: Ordering " + fruits[i].getNumItems());
		}
		System.out.println(".................................................");

		// Prints out perishable and price info for first and then last array item
		String perish = " is not ";
		if(fruits[0].isPerishable())
			perish = " is ";
		System.out.printf("%s%sperishable and your order will cost $%.2f\n", fruits[0].getName(), perish, fruits[0].calculatePrice());
		
		perish = " is not ";
		if(fruits[numKinds-1].isPerishable())
			perish = " is ";
		System.out.printf("%s%sperishable and your order will cost $%.2f\n\n", fruits[numKinds-1].getName(), perish, fruits[numKinds-1].calculatePrice());
		
		// Compares first and last array items for compatibility
		String compat = " cannot ";
		if(fruits[0].isCompatibleWith(fruits[numKinds - 1])) 
			compat = " can ";
		System.out.println(fruits[0].getName() + " and " + fruits[numKinds-1].getName() + compat + "be placed in the same truck.");
		
		kb.close();
	}

}
