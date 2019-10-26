import java.util.Scanner;

public class Lowestnumber {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter three numbers");
		int num1 = kb.nextInt();
		int num2 = kb.nextInt();
		int num3 = kb.nextInt();

		
		if (num1 <= num2 && num1 <= num3)
			System.out.println(num1 + " is the lowest number.");
		else if (num2 <= num1 && num2 <= num3)
			System.out.println(num2 + " is the lowest number.");
		else if (num3 <= num1 && num3 <= num2)
			System.out.println(num3 + " is the lowest number");

		kb.close();

	}

}
