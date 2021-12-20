package FlightReservationSystem;

@SuppressWarnings("serial") 
public class AirlinePassengerAgeException extends Exception
{
	// Parameterized Constructor
	AirlinePassengerAgeException(String ExceptionMessage)
	{
		super(ExceptionMessage);
	}
}
