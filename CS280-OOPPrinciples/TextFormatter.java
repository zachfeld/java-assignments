import java.io.*;
import java.util.*;

public class TextFormatter {

	public static void main(String[] args) {
		String pathMainFile = "./";
		String pathTempFile = "tempFile.txt";
		String currentLine = ""; 
		Scanner readIn = null;
		PrintWriter readOut = null;
		
		//get file name to be edited
		Scanner kb = new Scanner(System.in);
		System.out.println("Please give the name of the file to be read from desktop: (i.e. testFile.txt)");
		pathMainFile = pathMainFile + kb.nextLine();
		kb.close();
		
		//create file to be edited & check if it was properly created
		File mainFile = new File(pathMainFile);
		System.out.println("Does file to be edited exist? " + mainFile.exists());
		//create temporary file
		File tempFile = new File(pathTempFile);
		
		//create reader for main and writer to temp
		try {
			readIn = new Scanner(mainFile);
			readOut = new PrintWriter(tempFile);
		}catch(FileNotFoundException e) {System.out.println(e.getMessage()); System.exit(0);}
		
		while (readIn.hasNextLine()){
			currentLine = readIn.nextLine();
			currentLine = currentLine.trim().replaceAll(" +", " ");
			readOut.println(currentLine);
		}
		
		readIn.close();
		readOut.close();
		
		//delete original file and change name of temporary file to the name of the original file
		mainFile.delete();
		tempFile.renameTo(mainFile);
	}

}
