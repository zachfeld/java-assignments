/*
 Zachary Feldman
 Letter Swap game
 CS180  - 10/26/2018
 */

import java.util.Scanner;

public class LetterSwap {
	
	public static void main(String[] args) {
		boolean gameWin = true;
		int oldLocation = 0;
		int newLocation = 0;
		int[] map = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		char[] winBoard = { 'X', 'X', 'X', 'X', ' ', 'O', 'O', 'O', 'O' };
		char[] startBoard = { 'O', 'O', 'O', 'O', ' ', 'X', 'X', 'X', 'X' };
		char[] letters = { 'O', 'O', 'O', 'O', ' ', 'X', 'X', 'X', 'X' };
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Welcome to the Letter Swap game!");
		
		do {
			//prints out game board
			for (char i : letters)
				System.out.print(i);
			
			System.out.println();
			
			for (int i : map)
				System.out.print(i);
			
			System.out.println();
			
			//user enters locations they would like to move game pieces to
			//if the location is zero, the game will restart immediately
			System.out.println("Enter position of letter you would like to move:");
			oldLocation = kb.nextInt();
			if (oldLocation == 0) {
				resetGame(letters, startBoard);
				continue;
			}
			System.out.println("Enter position of where you would like to move it to:");
			newLocation = kb.nextInt();
			if (newLocation == 0) {
				resetGame(letters, startBoard);
				continue;
			}
			
			if (validMove(letters, oldLocation, newLocation) == false)
				continue;
				
				moveLetter(letters, oldLocation, newLocation);
				
			gameWin = checkWin(letters, winBoard);
		} while (gameWin);
		
		System.out.println("You win!");
		kb.close();

	}

	// Checks to see if the array is a winning board or not
	// have to fix to see x's and o's in order vs space in the middle
	public static boolean checkWin(char[] a, char[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return true;
			}
		}
		return false;
	}
	
	//sets current board to original board
	public static void resetGame(char[] letters, char[] startBoard) {
		for (int i = 0; i < letters.length; i++)
		letters[i] = startBoard[i];
		System.out.println("Restarting game\n");
	}

	// this will move the strings to the new index based off of what the user inputs
	public static void moveLetter(char[] letters, int a, int b) {
		char temp;
		temp = letters[a-1];
		letters[a-1] = letters[b-1];
		letters[b-1] = temp;
		System.out.println();
	}
	
	//all validity checks in order of precendence
	public static boolean validMove(char[] letters, int a, int b) {
		if (a < 1 || a > 9) {
			System.out.println("You entered an invalid position, please try again.");
			return false;
		}
		if (b < 1 || b > 9) {
			System.out.println("You entered an invalid position, please try again.");
			return false;
		}
		if (letters[a-1] == ' ') {
			System.out.println("There is no letter at that position.");
			return false;
		}
		if (letters[b-1] != ' ') {
			System.out.println("There is already a letter at that destination position.");
			return false;
		}
		if (Math.abs(a-b) > 2) {
			System.out.println("You cannot move that far in one move.");
			return false;
		}
		if (letters[a-1] == 'O') {
			if (a > b) {
				System.out.println("You cannot move an O to the left.");
				return false;
			}
		}
		if (letters[a-1] == 'X') {
			if (a < b) {
				System.out.println("You cannot move an X to the right.");
				return false;
			}
		}
		return true;
	}

}
