/* Zachary Feldman : file created 9/9/18 
	this program takes user inputs to create a pricing system for a hot dog stand*/

import java.util.*;
import java.text.DecimalFormat;

public class Foodtruck {

	public static void main(String[] args) {
		// variable declaration
		final double BUN = 0.2;
		final double BEEF_HOTDOG = 1.15;
		final double GARDEIN = .7;
		final double TOPPING = .3;
		double dogPrice, toppingPrice, toppingsCharged, dogCost, materialCost, revenue;
		int dogChoice, toppingsOrdered, hotdogsOrdered;
		
		//creating scanner and decimal format objects to help with input/output.
		Scanner kb = new Scanner(System.in);
		DecimalFormat money = new DecimalFormat("'$'#0.00");

		
		System.out.println("Please enter the parameters for your pricing model:");
		System.out.print("How much will you charge for each hot dog? ");
		dogPrice = kb.nextDouble();
		System.out.print("How much will you charge for each topping? ");
		toppingPrice = kb.nextDouble();
		System.out.print("\n");

		
		System.out.println("Please enter the scenario you would like to test:");
		System.out.print("How many hot dogs are being ordered? ");
		hotdogsOrdered = kb.nextInt();
		System.out.print("Kind of hot dogs (user enters 0 (zero) for beef, and 1 for Gardein)? ");
		dogChoice = kb.nextInt();
		/* I used a ternary operator to decide if the cost of the hotdog (dogCost) is 1.15 or 1.85. 
		The other option is to multiply the added cost of gardein (.7) to the users choice, then add that to 1.15.
		I chose to use the ternary operator instead because it felt a little more elegant. */
		dogCost = (dogChoice == 0 ? BEEF_HOTDOG : BEEF_HOTDOG + GARDEIN);
		System.out.print("How many toppings are being ordered? ");
		toppingsOrdered = kb.nextInt();
		//toppingsCharged is equal to the BOGO plus the added cost of a potential odd order of toppings
		toppingsCharged = (toppingsOrdered / 2) + (toppingsOrdered % 2);
		System.out.print("\n");
		
		kb.close();
		
		
		//intermediate calculations to make the last block of code more readable
		materialCost = dogCost + BUN + (toppingsOrdered * TOPPING);
		revenue = (dogPrice + (toppingPrice*toppingsCharged));
		
		
		System.out.println("You will spend per hot dog: " + money.format(materialCost));
		System.out.println("You will spend for the whole order: " + money.format(materialCost * hotdogsOrdered));
		System.out.println("The customer will pay per hot dog (including toppings): " + money.format(revenue));
		System.out.println("The customer will pay for the whole order: " + money.format(revenue * hotdogsOrdered));
		System.out.println("You will earn for the whole order: " + money.format((revenue - materialCost) * hotdogsOrdered));
	}

}