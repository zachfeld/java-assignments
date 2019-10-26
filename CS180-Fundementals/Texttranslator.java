/*
 Zach Feldman
 
This program takes two three word phrases, extracts the first letter of each of the three words,
then puts those letters into the matching phrase in a sentence.
*/
import java.util.Scanner;

public class Texttranslator {

	public static void main(String[] args) {
		
		String firstPhrase, secondPhrase, textMessage, firstAcronym, secondAcronym, textMessageSearch;
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Welcome to the text message tranlator.");
		System.out.println("What is the first phrase to translate into an acronym");
		firstPhrase = kb.nextLine();
		firstPhrase = firstPhrase.trim();
		
		
		System.out.println("What is the second phrase to translate?");
		secondPhrase = kb.nextLine();
		secondPhrase = secondPhrase.trim();
		
		
		System.out.println("Please enter the text message you'd like to translate");
		textMessage = kb.nextLine();
		
		kb.close();
		
		//changes the first and second phrase into upper-case
		//then places each of the three words into an array of size 3
		String firstPhraseChange = firstPhrase.toUpperCase();
		String[] firstPhraseArr = firstPhraseChange.split(" ", 3);
		String secondPhraseChange = secondPhrase.toUpperCase();
		String[] secondPhraseArr = secondPhraseChange.split(" ", 3);
		
		
		//takes each element in the array and extracts the first character. 
		//This works because we know the phrases are only 3 words long. if they were longer we'd put the array into a loop.
		firstAcronym = firstPhraseArr[0].charAt(0) + "" + firstPhraseArr[1].charAt(0) + "" + firstPhraseArr[2].charAt(0);
		secondAcronym = secondPhraseArr[0].charAt(0) + "" + secondPhraseArr[1].charAt(0) + "" + secondPhraseArr[2].charAt(0);
		
		//set up search variables (that we are going to be manipulating); hence, why we need copies of the strings
		String firstPhraseSearch = firstPhrase.toLowerCase();
		String secondPhraseSearch = secondPhrase.toLowerCase();
		textMessageSearch = textMessage.toLowerCase();
		textMessageSearch = textMessageSearch.replaceAll("[.,?!*@&]", " ");
		textMessageSearch = " " + textMessageSearch + " ";
		
		int firstParameter = textMessageSearch.indexOf(" " + firstPhraseSearch + " ");
		int secondParameter = firstParameter + firstPhraseSearch.length();
		
		int thirdParameter = textMessageSearch.indexOf(" " + secondPhraseSearch + " ");
		int fourthParameter = thirdParameter + secondPhraseSearch.length();
		
		
	//here I am taking the parameters of each of the phrases and putting them into the original sentence
	String translatedSentence = 
		textMessage.substring(0, firstParameter) +
		textMessage.substring(firstParameter, secondParameter).toLowerCase().replace(firstPhrase.toLowerCase(), firstAcronym) +
		textMessage.substring(secondParameter, thirdParameter) +
		textMessage.substring(thirdParameter, fourthParameter).toLowerCase().replace(secondPhrase.toLowerCase(), secondAcronym) +
		textMessage.substring(fourthParameter);
	
	System.out.println();
	System.out.println("Here is the translation of your text message:");
	System.out.println(translatedSentence);
		
		
		
	}
	

}
