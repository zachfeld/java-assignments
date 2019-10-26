
import java.util.Scanner;

public class NumberLoop {
	public static void main (String[] args) {
		Scanner kb = new Scanner(System.in);
		int sum = 0, temp = 0, product = 1, i = 1,  count;
		
		System.out.print("How many numbers would you like to enter? ");
		count = kb.nextInt();
		
		while(i <= count) {
			System.out.print("Enter number " + i + ": ");
			temp = kb.nextInt();
			sum += temp;
			product *= temp;
			i++;
			
		}
		System.out.println("The sum of theses numbers is " + sum);
		System.out.println("The product of these numbers is " + product);
		System.out.println("The average of these numbers is " + product/count);
		
		kb.close();
	}
}
