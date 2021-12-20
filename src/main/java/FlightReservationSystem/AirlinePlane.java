package FlightReservationSystem;
import java.util.ArrayList;

public class AirlinePlane 
{
	// Attributes
	private String AirlineCompanyName;
	private String PlaneFLTID;
	private String PlaneType;	
	private int PlaneSeatCapacity;
	private int PlaneBaggageCapacity;	
	
	// AirlineFlight object ArrayList
	ArrayList<AirlineFlight> AirlineFlight = new ArrayList<AirlineFlight>();
	
	// Default Constructor
	AirlinePlane()
	{
		AirlineCompanyName = null;
		PlaneFLTID = null;
		PlaneType = null;
		PlaneSeatCapacity = -1;
		PlaneBaggageCapacity = -1;
	}
	
	//Parameterized Constructor
	AirlinePlane(String CompanyName, String FLTID, String Type, int SeatCapacity, int BaggageCapacity) throws AirlineFlightSeatException
	{
		AirlineCompanyName = CompanyName;
		PlaneFLTID = FLTID;
		PlaneType = Type;
		
		if(SeatCapacity < 0)
			throw new AirlineFlightSeatException("Airline Plane Seat Capacity cannot be a negative value...");
		else
			PlaneSeatCapacity = SeatCapacity;
		
		PlaneBaggageCapacity = BaggageCapacity;
	}
		
	public String getAirlineCompanyName() {
		return AirlineCompanyName;
	}

	public void setAirlineCompanyName(String airlineCompanyName) {
		AirlineCompanyName = airlineCompanyName;
	}

	public String getPlaneFLTID() {
		return PlaneFLTID;
	}

	public void setPlaneFLTID(String planeFLTID) {
		PlaneFLTID = planeFLTID;
	}

	public String getPlaneType() {
		return PlaneType;
	}

	public void setPlaneType(String planeType) {
		PlaneType = planeType;
	}

	public int getPlaneSeatCapacity() {
		return PlaneSeatCapacity;
	}

	public void setPlaneSeatCapacity(int planeSeatCapacity) {
		PlaneSeatCapacity = planeSeatCapacity;
	}

	public int getPlaneBaggageCapacity() {
		return PlaneBaggageCapacity;
	}

	public void setPlaneBaggageCapacity(int planeBaggageCapacity) {
		PlaneBaggageCapacity = planeBaggageCapacity;
	}

	public void DisplayAirlinePlaneDetails()
	{		
		System.out.println("Airline Plane Details Interface\n");
		System.out.println("Airline Company Name: " + AirlineCompanyName);
		System.out.println("Plane FLT ID: " + PlaneType + "|" + PlaneFLTID);
		System.out.println("Seating Capacity: " + PlaneSeatCapacity);
		System.out.println("Baggage Capacity: " + PlaneBaggageCapacity + " Kilogram (kg)");
		System.out.println("\n");
	}	
}
