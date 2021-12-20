package FlightReservationSystem;

@SuppressWarnings("serial")
public class AirlinePassengerEmptyException extends Exception 
{
		// Parameterized Constructor
	AirlinePassengerEmptyException(String ExceptionMessage)
	{
		super(ExceptionMessage);
	}
}
