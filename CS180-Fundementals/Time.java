import java.text.DecimalFormat;

public class Time {
	private int hour;
	private int minute;
	//zero argument constructor
	Time() {
		this.hour = 0;
		this.minute = 0;
	}
	//two argument constructor that calls setTime
	Time(int h, int m){
		this.setTime(h, m);
	}
	/*
	 * Method boolean setTime(int hour, int minute ) ‐ sets the hour and minute
	 * value of the calling object to the parameters, in case params hour and
	 * minute* have appropriate values. Returns true, if values were
	 * appropriate, false, otherwise.
	 */
	public boolean setTime(int h, int m) {
		boolean ok = true;
		// check if hour is appropriate
		if (h < 0 || h > 23) {
			System.out.println("Invalid value of hour " + h);
			ok = false;
		} else
			this.hour = h;
		// check if minute is appropriate
		if (m < 0 || m > 59) {
			System.out.println("Invalid value of minute " + m);
			ok = false;
		} else
			this.minute = m;

		return ok;
	}

	/* Accessor methods */
	public int getHour() {
		return this.hour;
	}
	public int getMinute() {
		return this.minute;
	}

	/*
	 * public int toMinutes() returns the time of the calling object,
	 * represented in minutes only
	 */
	public int toMinutes() {
		// compute the calling object in minutes only
		int thisInMinutes = this.hour * 60 + this.minute;
		return thisInMinutes;
	}

	/*
	 * public String getAMPMTime() Returns a string like "2:35 PM" or "7:15 AM"
	 * based on the calling object
	 */
	public String getAMPMTime() {
		String ampm;
		DecimalFormat minFrm = new DecimalFormat("00");
		if (this.hour < 12)
			ampm = this.hour + ":" + minFrm.format(this.minute) + " AM";
		else if (this.hour == 12)
			ampm = this.hour + ":" + minFrm.format(this.minute) + " PM";
		else // here this.hour > 12
			ampm = (this.hour - 12) + ":" + minFrm.format(this.minute) + " PM";
		return ampm;
	}

	/*
	 * public Time timeAfter(int min) creates and returns a Time object,
	 * representing the calling object's time plus min minutes.
	 */
	public Time timeAfter(int min) {
		int newMinutes = min + this.toMinutes();
		Time newTime = new Time();
		newTime.setTime(newMinutes / 60 % 24, // %24 for wrapping hours in 0..23
												// range
				newMinutes % 60);
		return newTime;
	}
	public String toString() {
		String s = this.getHour() + ":" + this.getMinute();
		return s;
	}
	public boolean isBefore(Time secondTime) {
		
		if (this.getHour() < secondTime.getHour()) {
			return true;
		}
		if (this.getHour() == secondTime.getHour()) {
			if (this.getMinute() < secondTime.getMinute())
				return true;
		}
		return false;
	}
	
}