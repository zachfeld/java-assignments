/* this project was created by Zach Feldman and Nick Roth*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class Dinnerbill {

	public static void main(String[] args) {
		
		int partySize;
		double dinnerPrice, tipAmt, totalTip, amountOwed;
		String serverName;
		
		Scanner kb = new Scanner(System.in);
		DecimalFormat money = new DecimalFormat("'$'#0.00");
		
		System.out.print("How many people are in your party? ");
		partySize = kb.nextInt();
		System.out.print("What was the name of your server? ");
		//move the scanner cursor over one to have multiple words per name
		kb.nextLine();
		serverName = kb.nextLine();
		System.out.print("what was the total cost of dinner? ");
		dinnerPrice = kb.nextDouble();
		System.out.print("What percent tip do you want to give? (User should type a whole number such as 20 for 20%) ");
		tipAmt = kb.nextDouble();
		System.out.print("\n");
		kb.close();
		
		//this calculates what server will get for tip and also how much each person should pay
		totalTip = (tipAmt/100) * dinnerPrice;
		amountOwed = ((totalTip + dinnerPrice)/partySize);
		
		System.out.println(serverName + " recieves " + money.format(totalTip));
		System.out.println("Each person owes " + money.format(amountOwed));
		
	}

}
