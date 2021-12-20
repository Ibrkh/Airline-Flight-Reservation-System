package FlightReservationSystem;

public class AirlinePassengerSeat
{
	// Attributes
	String PassengerID;
	
	String SeatID;
	String SeatTravelClass;
	boolean SeatAvailiability;

	// Default Constructor
	AirlinePassengerSeat()
	{
		PassengerID = null;

		SeatID = null;
		SeatTravelClass = null;
		SeatAvailiability = false;
	}
	
	// Parameterized Constructor
	AirlinePassengerSeat(String ID, String TravelClass)
	{
		SeatID = ID;
		SeatTravelClass = TravelClass;
		SeatAvailiability = true;
	}

	public void SeatReservation(String passengerid)
	{
		PassengerID = passengerid;
		SeatAvailiability = false;		
	}
	
	public String getPassengerID() {
		return PassengerID;
	}

	public void setPassengerID(String passengerID) {
		PassengerID = passengerID;
	}

	public String getSeatID() {
		return SeatID;
	}

	public void setSeatID(String seatID) {
		SeatID = seatID;
	}

	public String getSeatTravelClass() {
		return SeatTravelClass;
	}

	public void setSeatTravelClass(String seatTravelClass) {
		SeatTravelClass = seatTravelClass;
	}

	public boolean isSeatAvailiability() {
		return SeatAvailiability;
	}

	public void setSeatAvailiability(boolean seatAvailiability) {
		SeatAvailiability = seatAvailiability;
	}
	
	public void DisplaySeatDetails()
	{
		//System.out.println("Airline Passenger Seat Details\n");
		
		String status = "";
		
		if(SeatAvailiability == true)
			status = "Availiable";
		else
			status = "Reserved";
		
		System.out.println("Travelling Class: " + SeatTravelClass);
		System.out.println("SeatID|Status: " + SeatID + "|" + status);
		System.out.println("\n");
	}
}
