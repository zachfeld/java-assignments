package shell;

import java.util.Scanner;

public class TestGoKart {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int numGoKarts;
		
		
		System.out.println("How many go-karts would you like to create?");
		numGoKarts = kb.nextInt();
		GoKart [] array = new GoKart[numGoKarts];
		kb.nextLine();
		
		for(int i = 0; i < numGoKarts; i++) {
			array[i] = new GoKart();
			System.out.println("What is the name of the driver?");
			array[i].setName(kb.nextLine());
			System.out.println("What is the power source (1-gas, 2-electric, 3-hybrid)?");
			array[i].setPowerSource(kb.nextInt());
			kb.nextLine();
		}
		System.out.println("************************************************\n");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i].getName() + ": Condition: " + array[i].getCondition() + " Experience: " + 
					array[i].getExperience() + " Power Source: " + array[i].getPowerSource() + "\n");
			
		}
		System.out.println("\n................................................");
		
		for(int i = 0; i < numGoKarts; i++) {
			System.out.println("How many laps should I race " + array[i].getName() + "'s go-kart?");
			int numLaps = kb.nextInt();
			
			for (int j = 0; j<numLaps; j++) {
				array[i].driveOneLap();
			}
			System.out.println(array[i].getName() + " raced " + numLaps + " laps");
			int kartImproved = 0;
			for (int j = 0; j<4; j++) {
				kartImproved += 
						array[i].fixKart();
			}
			System.out.println("fixed the kart 4 times and condition improved by " + kartImproved);
			System.out.println(array[i].getName() + ": condition =" + array[i].getCondition() + ", experience=" + array[i].getExperience() + ", power source=" + array[i].getPowerSource());	
		}
		if(array[array.length-1].isCompatibleWith(array[array.length-2])) {
			if(array[array.length-1].isCompatibleWith(array[array.length-3]));
			System.out.println(array[array.length-1].getName() + " " + array[array.length-2].getName() + " " + array[array.length-3].getName() );
		}
		
		kb.close();
}
}

