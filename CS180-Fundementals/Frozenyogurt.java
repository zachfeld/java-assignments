/* 
 Zach Feldman
 10/12/18
 This program takes user input to create a price for a frozen yogurt order
 */
import java.util.Scanner;

public class Frozenyogurt {

	public static void main(String[] args) {
		final String PREMIUM = "P";
		final String REGULAR = "R";
		final String SMALL = "S";
		final String MEDIUM = "M";
		final String LARGE = "L";
		final String XLARGE = "X";
		final String CUP = "U";
		final String CONE = "O";
		final String SUGAR = "S";
		final String WAFFLE = "W";
		final String SUNDAY = "Su";
		final String SATURDAY = "Sa";
		final double SMALL_SIZE = 3;
		final double MEDIUM_SIZE = 4.5;
		final double LARGE_SIZE = 6.25;
		final double XLARGE_SIZE = 8.25;
		final double ADD_FLAVOR = .75;
		final double FIRST_TOPPING = .5;
		final double ADD_TOPPING = .25;
		
		//set variables to zero because we will use them in our if statements and switch cases
		//we dont want to see scoping errors
		String orderType, orderSize, weekDay, orderCupCone, orderConeType = "";
		int flavors, toppings;
		double orderTypePrice = 0, orderSizePrice = 0, orderCupConePrice = 0, orderFlavorsPrice = 0,
				orderDiscountPrice = 0, orderToppingsPrice = 0;

		Scanner kb = new Scanner(System.in);
		
		//a series of inputs and checks to see if they are out of bounds or not out of bounds
		System.out.print(
				"Would you like to order a premium or regular frozen yogurt flavor? (P for premium, R for regular) ");
		orderType = kb.nextLine().substring(0, 1).toUpperCase();
		if (!(orderType.equals("P") || orderType.equals("R"))) {
			System.out.println("You entered an improper order type.");
			System.exit(0);
		}
		System.out
				.print("What size would you like? (enter S for small, M for medium, L for large, X for extra large) ");
		orderSize = kb.nextLine().toUpperCase();
		if (!(orderSize.equals("S") || orderSize.equals("M") || orderSize.equals("L") || orderSize.equals("X"))) {
			System.out.println("You entered an improper order Size.");
			System.exit(0);
		}

		System.out.print("How many flavors would you like? (enter a number between 1 and 3) ");
		flavors = kb.nextInt();
		if (flavors < 1 || flavors > 3) {
			System.out.println("You entered an improper number of flavors.");
			System.exit(0);
		}
		System.out.print("How many toppings would you like? (enter a number between 0 and 6) ");
		toppings = kb.nextInt();
		if (toppings < 0 || toppings > 6) {
			System.out.println("You entered an improper number of toppings.");
			System.exit(0);
		}

		System.out.print("Should this be in a cup or a cone? (U for cup, O for cone) ");
		kb.nextLine();
		orderCupCone = kb.nextLine().toUpperCase();
		if (!(orderCupCone.equals("U") || orderCupCone.equals("O"))) {
			System.out.println("You entered an improper type.");
			System.exit(0);
		}

		if (orderCupCone.equals(CONE)) {
			System.out.print("What type of cone? (S for sugar cone, W for waffle cone) ");
			orderConeType = kb.nextLine().toUpperCase();

			if (!(orderConeType.equals("S") || orderConeType.equals("W"))) {
				System.out.println("You entered an improper cone type.");
				System.exit(0);
			}
		}

		System.out.print("What day of the week is this? (enter Su for Sunday, M for Monday, Tu for Tuesday, "
				+ "W for Wednesday, Th for Thursday, \nF for Friday, Sa for Saturday) ");
		weekDay = kb.nextLine().toLowerCase();

		weekDay = weekDay.substring(0, 1).toUpperCase() + weekDay.substring(1).toLowerCase();

		if (weekDay.length() > 2) {
			System.out.println("You entered an improper day of the week.");
			System.exit(0);
		}

		// premium adds one dollar to entire order. otherwise just add zero to entire
		// order
		switch (orderType) {
		case PREMIUM:
			orderTypePrice = 1;
			break;
		case REGULAR:
			orderTypePrice = 0;
			break;
		}
		// sets sizeprice to the base - one flavor - price for each potential order
		switch (orderSize) {
		case SMALL:
			orderSizePrice = SMALL_SIZE;
			break;
		case MEDIUM:
			orderSizePrice = MEDIUM_SIZE;
			break;
		case LARGE:
			orderSizePrice = LARGE_SIZE;
			break;
		case XLARGE:
			orderSizePrice = XLARGE_SIZE;
			break;
		}
		// sets one flavor to zero extra dollars, then it is 75 cents for every
		// additional flavor
		switch (flavors) {
		case 1:
			orderFlavorsPrice = 0;
			break;
		case 2:
			orderFlavorsPrice = ADD_FLAVOR;
			break;
		case 3:
			orderFlavorsPrice = ADD_FLAVOR * 2;
			break;
		}
		// sets price for toppings. first topping is free, then it's 50 cents plus 25
		// cents for any additional topping
		switch (toppings) {
		case 0:
			orderToppingsPrice = 0;
			break;
		case 1:
			orderToppingsPrice = 0;
			break;
		case 2:
			orderToppingsPrice = FIRST_TOPPING + (0 * ADD_TOPPING);
			break;
		case 3:
			orderToppingsPrice = FIRST_TOPPING + (1 * ADD_TOPPING);
			break;
		case 4:
			orderToppingsPrice = FIRST_TOPPING + (2 * ADD_TOPPING);
			break;
		case 5:
			orderToppingsPrice = FIRST_TOPPING + (3 * ADD_TOPPING);
			break;
		case 6:
			orderToppingsPrice = FIRST_TOPPING + (4 * ADD_TOPPING);
			break;
		}

		// sets prices for cup or cone, then whatever cone the user chose
		switch (orderCupCone) {
		case CUP:
			orderCupConePrice = .3;
			break;
		case CONE:
			if (orderConeType.equals(SUGAR))
				orderCupConePrice = .7;
			else if (orderConeType.equals(WAFFLE))
				orderCupConePrice = 1.2;
			break;
		}

		// sets discount to 25% off for weekday or full price for weekend
		if (weekDay.equals(SATURDAY) || weekDay.equals(SUNDAY))
			orderDiscountPrice = 1;
		else
			orderDiscountPrice = .75;

		// adds all dummed down prices together and multiplies by a potential discount
		double orderTotal = (orderTypePrice + orderSizePrice + orderCupConePrice + orderFlavorsPrice
				+ orderToppingsPrice) * orderDiscountPrice;
		
		System.out.printf("\nThank you for your order. Your frozen yogurt will cost $%.2f", orderTotal);
		kb.close();

	}

}
