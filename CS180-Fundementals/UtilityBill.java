
/*
Zach Feldman
Calculates utility bill for various price structures.

 */
import java.util.Scanner;

public class UtilityBill {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// commercial customer
		final int COM_LIMIT = 1000;
		final double COM_RATE = 0.045;
		final double COM_FEE = 60;

		// residential customer
		final double RES_RATE = 0.052;
		final double RES_FEE = 6;

		// industrial customer
		final int IND_LIMIT = 5000;
		final int IND_LIMIT_2 = 1000;
		final int IND_LIMIT_3 = 3000;
		final double IND_RATE_BELOW = 0.028;
		final double IND_FEE_BELOW = 76;
		final double IND_RATE_ABOVE = 0.03;
		final double IND_FEE_ABOVE = 270;

		double totalCost = 0;

		System.out.print("Enter the type of use ('R', 'C', or 'I'): ");
		char useType = keyboard.next().toUpperCase().charAt(0); // should be R, C, or I
		
		if (!(useType == 'R' || useType == 'C' || useType == 'I')) {
			System.out.println("You entered an invalid type of use.");
			System.exit(0);
		}
		
		System.out.print("Enter the usage in kwh: ");
		double usage = keyboard.nextDouble(); // usage amount in kwh
		
		if (usage < 0) {
			System.out.println("You can't use negative energy!");
			System.exit(0);
		}
		

		switch (useType) {
		case 'R':
			totalCost = RES_FEE + (usage * RES_RATE);
			break;
		case 'C':
			if (usage <= COM_LIMIT)
				totalCost = COM_FEE;
			else
				totalCost = COM_FEE + (usage - COM_LIMIT) * COM_RATE;

			break;
		case 'I':
			if (usage <= IND_LIMIT_2)
				totalCost = IND_FEE_BELOW;

			else if (usage < IND_LIMIT && usage > IND_LIMIT_2)
				totalCost = IND_FEE_BELOW + (usage - IND_LIMIT_2) * IND_RATE_BELOW;

			else
				totalCost = IND_FEE_ABOVE + (usage - IND_LIMIT_3) * IND_RATE_ABOVE;

			break;
		}

		System.out.printf("Your total cost will be $%.2f ", totalCost);
		
		keyboard.close();

	}
}
