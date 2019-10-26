import java.util.Scanner;
public class StringTooLongException extends Exception {

	public StringTooLongException(String message) {
		super(message);
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		String reading = "";

		while (!reading.equalsIgnoreCase("Done")) {
			try {
				System.out.println("Enter a word");
				reading = kb.nextLine();
				if (reading.length() > 20) 
					throw new StringTooLongException("String is too long!");
			} catch (StringTooLongException e) {
				System.out.println(e.getMessage());
				
			}
		}
	}

}
