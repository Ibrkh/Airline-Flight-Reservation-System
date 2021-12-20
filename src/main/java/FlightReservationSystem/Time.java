package FlightReservationSystem;

public class Time
{
	// Attributes
	int seconds;
	int minutes;
	int hours;
	
	// Default Constructor
	Time()
	{
		seconds = 0;
		minutes = 0;
		hours = 0;
	}
	
	//Parameterized Constructor
	Time(int secs,int mins, int hrs)
	{
		seconds = secs;
		minutes = mins;
		hours = hrs;
	}
	
	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getTime()
	{
		String time = null;
		
		time = seconds + ":" + minutes + ":" + hours;
	
		return time;
	}

	void DisplayDate()
	{
		System.out.println("Booking Time: " + seconds + ":" + minutes + ":" + hours);
	}
}
