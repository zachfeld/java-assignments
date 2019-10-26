package shell;

import java.util.Scanner;
public class Nametranslator {

	public static void main(String[] args) {
		String name;
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Please input a full name (First Middle Last)");
		name = kb.nextLine();
		kb.close();
		
		name = name.trim();
		
		String firstName = name.substring(0, name.indexOf(" "));
		String lastName = name.substring(name.lastIndexOf(" ") + 1);
		String middleName = name.substring(name.indexOf(" "), name.lastIndexOf(" ")).trim();
		
		firstName = firstName.toLowerCase();
		firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
		
		lastName = lastName.toLowerCase();
		lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
		
		middleName = middleName.substring(0,1).toUpperCase();
		
		System.out.println(lastName + ", " + firstName + " " + middleName + ".");
		
		
	}

}
