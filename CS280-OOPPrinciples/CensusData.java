import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CensusData {

	public static void main(String[] args) {
		File girlnames = new File("girlnames.txt");
		File boynames = new File("boynames.txt");
		HashSet<String> individualNameSet = new HashSet<String>();
		HashSet<String> commonNameSet = new HashSet<String>();
		HashMap<String, Integer> girlHashMap = new HashMap<>();
		HashMap<String, Integer> boyHashMap = new HashMap<>();
		int commonNames = 0, totalGirlNames = 0, totalBoyNames = 0;
		String tempLine;

		// Read all girl names into HashMap
		try (Scanner inStream = new Scanner(new FileInputStream(girlnames))) {
			while (inStream.hasNextLine()) {
				tempLine = inStream.nextLine();
				// add info to HashMap as K, V pair
				girlHashMap.put(tempLine.substring(0, tempLine.indexOf(" ")),
						Integer.parseInt(
								tempLine.substring(tempLine.indexOf(" ") + 1)));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Read all boy names into HashMap
		try (Scanner inStream = new Scanner(new FileInputStream(boynames))) {
			while (inStream.hasNextLine()) {
				tempLine = inStream.nextLine();
				// add info to HashMap as K, V pair
				boyHashMap.put(tempLine.substring(0, tempLine.indexOf(" ")),
						Integer.parseInt(
								tempLine.substring(tempLine.indexOf(" ") + 1)));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// add girl names to a cumulative set of individual names
		for (String girlNameString : girlHashMap.keySet()) {
			individualNameSet.add(girlNameString);
		}

		// attempt to add boy names to individual name set,
		// if unable, add to set of common names
		for (HashMap.Entry<String, Integer> entry : boyHashMap.entrySet()) {
			if (!individualNameSet.add(entry.getKey())) {
				commonNameSet.add(entry.getKey());
				commonNames += entry.getValue();
			}
		}
		
		//count total number of girl names recorded in census
		for (int num : girlHashMap.values()) {
			totalGirlNames += num;
		}
		
		//count total number of boy names recorded in census
		for (int num : boyHashMap.values()) {
			totalBoyNames += num;
		}
		
		System.out.println("Total of people on census who share a common name: " + commonNames);
		System.out.println("List of common names: ");
		for (String name : commonNameSet) {
			System.out.println(name);
		}
		System.out.println("Total number of girls recorded in census: " + totalGirlNames);
		System.out.println("Total number of boys recorded in census: " + totalBoyNames);
	}

}
