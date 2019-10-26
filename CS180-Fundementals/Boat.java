package shell;

import java.util.Scanner;

public class Boat {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter mast height: ");

		
		int mastHeight = keyboard.nextInt();
		int boatWidth = (2 * mastHeight) + 1;
		int dots = boatWidth / 2;
		int hullHeight = mastHeight/3;
		int x = 0;
		int f = 0;
		do {
			System.out.print("•");
			x++;
		}while (x < dots);
		System.out.print("|");
		do {
			System.out.print("•");
			f++;
		}while (f < dots);
		System.out.println();
		
			
		
		for (int i = 1; i < mastHeight; i++) {

			for (int j = 0; j < dots - i; j++) {
				System.out.print("•");
			}
			
			System.out.print("/");

			for (int a = 0; a < i - 1; a++) {
				System.out.print(" ");
			}
			
			System.out.print("|");

			for (int a = 0; a < i - 1; a++) {
				System.out.print(" ");
			}

			System.out.print("\\");

			for (int j = 0; j < dots - i; j++) {
				System.out.print("•");
			}

			System.out.println();

		}
		for(int i = 0; i < boatWidth; i++) {
			System.out.print("-");
		}
		System.out.println();
		
		for (int i = 0; i < hullHeight; i++) {
			
			for (int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < dots - i; j++) {
				System.out.print("\\");
			}
			
			System.out.print("V");
			
			for (int j = 0; j < dots - i; j++) {
				System.out.print("/");
			}
			System.out.println();
		}
		keyboard.close();
	}
	
}
