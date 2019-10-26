
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class WordReader {

	public static void main(String[] args) {
		
		String word;
		int count = 0;
		Scanner inStream = null;
		int vPrev, vCount;
		
		try { // create stream to read
			inStream = new Scanner(new FileInputStream("words.txt"));
		} catch (IOException e) {
			System.out.println("IO Error on read");
		}
		
		while(inStream.hasNextLine()) {
			word = inStream.nextLine();
			
			try {
				if (word.length() > 9) {
					count++;
					throw new StringTooLongException(word);		
				}
			}catch(StringTooLongException e) {System.out.println(count + " " + e.getMessage());}
		}
		System.out.println("Total words with length greater than 9: " + count);
	}

}
