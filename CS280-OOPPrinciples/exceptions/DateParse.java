import java.util.Scanner;

public class DateParse {

	public static void main(String[] args) {
		final String[] MONTHS = {null, "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October",
				"November", "December"};
		String date = "", monthString = "";
		String[] dmy = new String[3];
		int day = 1, month = 1, year = 1000;
		boolean reprompt = true, leap = false;
		Scanner kb = new Scanner(System.in);

		while (reprompt) {
			System.out.println("Enter a date in the format: mm/dd/yyyy");
			date = kb.nextLine();
			if (date.equals("end"))
				break;
			
			dmy = date.split("/");

			// parse string versions into integers
			try {
				// month
				month = Integer.parseInt(dmy[0]);
				if (month < 1 || month > 12)
					throw new MonthException("Month is out of range");

				monthString = MONTHS[month];

				// year
				year = Integer.parseInt(dmy[2]);
				//a little math to figure out if leap year
				//must be divisible by 4 but not by 100, or divisible by 400
				if ( (year % 4 == 0) && (year % 100 != 0)|| 
						(year % 400 == 0) && (year % 4 == 0) && (year % 100 == 0))
					leap = true;
				if (year < 1000 || year > 3000)
					throw new YearException("Year is out of range");

				// day
				day = Integer.parseInt(dmy[1]);
				if (day < 1 || day > 31)
					throw new DayException("Day is out of range");
				if (month == 4 || month == 6 || month == 9
						|| month == 11 && day > 30) {
					throw new DayException("Day is too large for month");
				}
				if (month == 2) {
					if (day > 28 && leap == false) {
						throw new DayException("February can not have more than 28 days on a non-leap year.");
					} 
					
				}
				reprompt = !reprompt;
				System.out.println(monthString + " " + day + ", " + year);
			} catch (MonthException | YearException | DayException e) {
				System.out.println(e.getMessage());
			}
			
		}

	}
}
