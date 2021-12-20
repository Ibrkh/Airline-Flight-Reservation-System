package FlightReservationSystem;
import java.util.ArrayList;

public class AirlineFlight
{
	// Attributes
	private String FlightDepartureLocation;
	private Date FlightDepartureDate;
	private Time FlightDepartureTime;

	private String FlightTransitLocation;

	private String FlightDestinationLocation;	
	private Date FlightDestinationDate;
	private Time FlightDestinationTime;

	private Time FlightDuration;
	
	private int EconomySeatCapacity;
	private int BusinessSeatCapacity;
	private int FirstSeatCapacity;
	
	private int EconomySeatAmount;
	private int BusinessSeatAmount;
	private int FirstSeatAmount;

	// AirlinePassenger of a specific Flight object ArrayList
	ArrayList<AirlinePassenger> AirlinePassenger = new ArrayList<AirlinePassenger>();

	// AirlinePassengerSeat object ArrayList
	ArrayList<AirlinePassengerSeat> PassengerSeat = new ArrayList<AirlinePassengerSeat>();
	
	// Default Constructor
	AirlineFlight()
	{
		FlightDepartureLocation = null;
		FlightDepartureDate = null;
		FlightDepartureTime = null;
		
		FlightTransitLocation = null;

		FlightDestinationLocation = null;
		FlightDestinationDate = null;
		FlightDestinationTime = null;

		FlightDuration = null;
		
		EconomySeatCapacity = -1;
		BusinessSeatCapacity = -1;
		FirstSeatCapacity = -1;
		
		EconomySeatAmount = -1;
		BusinessSeatAmount = -1;
		FirstSeatAmount = -1;
	}
	
	//Parameterized Constructor
	AirlineFlight(String DepartureLocation, Date DepartureDate, Time DepartureTime, String TransitLocation, String DestinationLocation, Date DestinationDate, Time DestinationTime, Time Duration, int EconomyAmount, int BusinessAmount, int FirstAmount, int EconomyCapacity, int BusinessCapacity, int FirstCapacity) throws AirlineFlightSeatException, AirlineFlightTravelAmountException
	{
		FlightDepartureLocation = DepartureLocation;
		FlightDepartureDate = DepartureDate;
		FlightDepartureTime = DepartureTime;
		
		FlightTransitLocation = TransitLocation;
	
		FlightDestinationLocation = DestinationLocation;
		FlightDestinationDate = DestinationDate;
		FlightDestinationTime = DestinationTime;
	
		FlightDuration = Duration;
		
		if (EconomyCapacity < 0)
			throw new AirlineFlightSeatException("Airline Travel Economy Class Seat Capacity cannot be a negative value...");
		else
			EconomySeatCapacity = EconomyCapacity;
		if (BusinessCapacity < 0)
			throw new AirlineFlightSeatException("Airline Travel Business Class Seat Capacity cannot be a negative value...");
		else			
			BusinessSeatCapacity = BusinessCapacity;
		if (FirstCapacity < 0)
			throw new AirlineFlightSeatException("Airline Travel First Class Seat Capacity cannot be a negative value...");
		else
			FirstSeatCapacity = FirstCapacity;
		
		if(EconomyAmount < 0)
			throw new AirlineFlightTravelAmountException("Airline Travel Economy Class Seat Amount cannot be a negative value...");
		else	
			EconomySeatAmount = EconomyAmount;
		if(BusinessAmount < 0)
			throw new AirlineFlightTravelAmountException("Airline Travel Business Class Seat Amount cannot be a negative value...");
		else			
			BusinessSeatAmount = BusinessAmount;
		if(FirstAmount < 0)
			throw new AirlineFlightTravelAmountException("Airline Travel First Class Seat Amount cannot be a negative value...");
		else	
			FirstSeatAmount = FirstAmount;
	}
	
	public String getFlightDepartureLocation() {
		return FlightDepartureLocation;
	}

	public void setFlightDepartureLocation(String flightDepartureLocation) {
		FlightDepartureLocation = flightDepartureLocation;
	}

	public Date getFlightDepartureDate() {
		return FlightDepartureDate;
	}

	public void setFlightDepartureDate(Date flightDepartureDate) {
		FlightDepartureDate = flightDepartureDate;
	}

	public Time getFlightDepartureTime() {
		return FlightDepartureTime;
	}

	public void setFlightDepartureTime(Time flightDepartureTime) {
		FlightDepartureTime = flightDepartureTime;
	}
	
	public String getFlightTransitLocation() {
		return FlightTransitLocation;
	}

	public void setFlightTransitLocation(String flightTransitLocation) {
		FlightTransitLocation = flightTransitLocation;
	}

	public String getFlightDestinationLocation() {
		return FlightDestinationLocation;
	}

	public void setFlightDestinationLocation(String flightDestinationLocation) {
		FlightDestinationLocation = flightDestinationLocation;
	}

	public Date getFlightDestinationDate() {
		return FlightDestinationDate;
	}

	public void setFlightDestinationDate(Date flightDestinationDate) {
		FlightDestinationDate = flightDestinationDate;
	}

	public Time getFlightDestinationTime() {
		return FlightDestinationTime;
	}

	public void setFlightDestinationTime(Time flightDestinationTime) {
		FlightDestinationTime = flightDestinationTime;
	}

	public Time getFlightDuration() {
		return FlightDuration;
	}

	public void setFlightDuration(Time flightDuration) {
		FlightDuration = flightDuration;
	}
	
	public int getEconomySeatCapacity() {
		return EconomySeatCapacity;
	}

	public void setEconomySeatCapacity(int economySeatCapacity) {
		EconomySeatCapacity = economySeatCapacity;
	}

	public int getBusinessSeatCapacity() {
		return BusinessSeatCapacity;
	}

	public void setBusinessSeatCapacity(int businessSeatCapacity) {
		BusinessSeatCapacity = businessSeatCapacity;
	}

	public int getFirstSeatCapacity() {
		return FirstSeatCapacity;
	}

	public void setFirstSeatCapacity(int firstSeatCapacity) {
		FirstSeatCapacity = firstSeatCapacity;
	}
	
	public int getEconomySeatAmount() {
		return EconomySeatAmount;
	}

	public void setEconomySeatAmount(int economySeatAmount) {
		EconomySeatAmount = economySeatAmount;
	}

	public int getBusinessSeatAmount() {
		return BusinessSeatAmount;
	}

	public void setBusinessSeatAmount(int businessSeatAmount) {
		BusinessSeatAmount = businessSeatAmount;
	}

	public int getFirstSeatAmount() {
		return FirstSeatAmount;
	}

	public void setFirstSeatAmount(int firstSeatAmount) {
		FirstSeatAmount = firstSeatAmount;
	}

	public void DisplayAirlineFlightDetails()
	{
		System.out.println("Airline Flight Details Interface\n");
		System.out.println("Departure Location: " + FlightDepartureLocation);
		System.out.println("Departure Date|Time: " + FlightDepartureDate.getDate() + " " + FlightDepartureTime.getTime());
		System.out.println("Transit/Connecting Location: " + FlightTransitLocation);
		System.out.println("Destination Location: " + FlightDestinationLocation);
		System.out.println("Destination Date|Time: " + FlightDestinationDate.getDate() + " " + FlightDestinationTime.getTime());
		System.out.println("Flight Duration: " + FlightDuration.getTime());
		System.out.println("Airline Passenger Seat Details Interface\n");
		System.out.println("Economy Class Seats Availiable: " + EconomySeatCapacity);
		System.out.println("Economy Class per. Seat Amount: " + EconomySeatAmount + "PKR");		
		System.out.println("Business Class Seats Availiable: " + BusinessSeatCapacity);
		System.out.println("Business Class per. Seat Amount: " + BusinessSeatAmount + "PKR");		
		System.out.println("First Class Seats Availiable: " + FirstSeatCapacity);
		System.out.println("First Class per. Seat Amount: " + FirstSeatAmount + "PKR");		
		System.out.println("\n");
	}
}
