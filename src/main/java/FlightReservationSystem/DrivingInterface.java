package FlightReservationSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DrivingInterface 
{
	//Creating ADMIN object
	static ADMIN Admin = new ADMIN("Ibrahim", "Khan", "k190312", "ahmdibrkhn");
	//static AirlinePassenger Passenger = new AirlinePassenger("k190312", "ahmdibrkhn", "Ibrahim", "Khan", "Na4210110311002", "03162533800", "Bahria Town Phase 8, Abu Bakr Block", "k190312@nu.edu.pk", "000441155123", "Male", 21);
	
	public static void AirlineDataProcessing() throws NumberFormatException, IOException, AirlineFlightSeatException, AirlineFlightTravelAmountException
	{
		// Reading AirlinePlane File Data 
		try
		{
			FileReader file = new FileReader("D:\\Eclipse Workspace\\AP-FlightReservationSystem\\src\\main\\java\\FlightReservationSystem\\Airline Plane Details");
			@SuppressWarnings("resource") BufferedReader buffer = new BufferedReader(file);
				
			String tempLine = "";
			int AirlinePlaneCounter = 0;
			
			while((tempLine = buffer.readLine()) != null)
			{				
				String[] AirlinePlaneDetails = tempLine.split("_");
				
				//dummy variables used to input
				//in parameterized constructor of the class
				String AirlineCompanyName = AirlinePlaneDetails[0];
				String PlaneFLTID = AirlinePlaneDetails[1];
				String PlaneType = AirlinePlaneDetails[2];	
				String SeatCapacity = AirlinePlaneDetails[3];
				String BaggageCapacity = AirlinePlaneDetails[4];
				
				int PlaneSeatCapacity = Integer.parseInt(SeatCapacity);
				int PlaneBaggageCapacity = Integer.parseInt(BaggageCapacity);
								
				// Adding AirlinePlanes in system	
					AirlinePlane Plane = new AirlinePlane(AirlineCompanyName, PlaneFLTID, PlaneType, PlaneSeatCapacity, PlaneBaggageCapacity);					
					Admin.AirlinePlane.add(Plane);
					
					FileReader fileReader = new FileReader("D:\\Eclipse Workspace\\AP-FlightReservationSystem\\src\\main\\java\\FlightReservationSystem\\Airline Flight Details");
					@SuppressWarnings("resource") BufferedReader bufferReader = new BufferedReader(fileReader);
						
					tempLine = "";
					int AirlineFlightCounter = 0;
					
					while((tempLine = bufferReader.readLine()) != null)
					{				
						String[] AirlineFlightDetails = tempLine.split("_");
						
						//dummy variables used to input
						//in parameterized constructor of the class
						String FlightDepartureLocation = AirlineFlightDetails[0];
		
						String DepDay = AirlineFlightDetails[1]; int DepartureDay = Integer.parseInt(DepDay);
						String DepMonth = AirlineFlightDetails[2]; int DepartureMonth = Integer.parseInt(DepMonth);
						String DepYear = AirlineFlightDetails[3]; int DepartureYear = Integer.parseInt(DepYear);
						Date FlightDepartureDate = new Date(DepartureDay, DepartureMonth, DepartureYear);
		
						String DepHour = AirlineFlightDetails[4]; int DepartureHour = Integer.parseInt(DepHour);
						String DepMinute = AirlineFlightDetails[5]; int DepartureMinute = Integer.parseInt(DepMinute);
						String DepSecond = AirlineFlightDetails[6]; int DepartureSecond = Integer.parseInt(DepSecond);
						Time FlightDepartureTime = new Time(DepartureHour,DepartureMinute, DepartureSecond);
						
		
						String FlightTransitLocation = AirlineFlightDetails[7];
		
						String FlightDestinationLocation = AirlineFlightDetails[8];	
						
						String DesDay = AirlineFlightDetails[9]; int DestinationDay = Integer.parseInt(DesDay);
						String DesMonth = AirlineFlightDetails[10]; int DestinationMonth = Integer.parseInt(DesMonth);
						String DesYear = AirlineFlightDetails[11]; int DestinationYear = Integer.parseInt(DesYear);
						Date FlightDestinationDate = new Date(DestinationDay, DestinationMonth, DestinationYear);
										
						String DesHour = AirlineFlightDetails[12]; int DestinationHour = Integer.parseInt(DesHour);
						String DesMinute = AirlineFlightDetails[13]; int DestinationMinute = Integer.parseInt(DesMinute);
						String DesSecond = AirlineFlightDetails[14]; int DestinationSecond = Integer.parseInt(DesSecond);
						Time FlightDestinationTime = new Time(DestinationHour, DestinationMinute, DestinationSecond);
		
						String DurHour = AirlineFlightDetails[15]; int DurationHour = Integer.parseInt(DurHour);
						String DurMinute = AirlineFlightDetails[16]; int DurationMinute = Integer.parseInt(DurMinute);
						String DurSecond = AirlineFlightDetails[17]; int DurationSecond = Integer.parseInt(DurSecond);
						Time FlightDuration = new Time(DurationHour, DurationMinute, DurationSecond);

						String EconomyAmount = AirlineFlightDetails[18]; int EconomySeatAmount = Integer.parseInt(EconomyAmount);
						String BusinessAmount = AirlineFlightDetails[19]; int BusinessSeatAmount = Integer.parseInt(BusinessAmount);
						String FirstAmount = AirlineFlightDetails[20]; int FirstSeatAmount = Integer.parseInt(FirstAmount);
						
						String EconomyCapacity = AirlineFlightDetails[21]; int EconomySeatCapacity = Integer.parseInt(EconomyCapacity);
						String BusinessCapacity = AirlineFlightDetails[22]; int BusinessSeatCapacity = Integer.parseInt(BusinessCapacity);
						String FirstCapacity = AirlineFlightDetails[23]; int FirstSeatCapacity = Integer.parseInt(FirstCapacity);
						
						
						
						// Adding AirlineFlights in system				
						AirlineFlight Flight = new AirlineFlight(FlightDepartureLocation, FlightDepartureDate, FlightDepartureTime, FlightTransitLocation, FlightDestinationLocation, FlightDestinationDate, FlightDestinationTime, FlightDuration, EconomySeatAmount, BusinessSeatAmount, FirstSeatAmount, EconomySeatCapacity, BusinessSeatCapacity, FirstSeatCapacity);					
						Admin.AirlinePlane.get(AirlinePlaneCounter).AirlineFlight.add(Flight);
						
						// Adding Passenger Seats in Airline Flight	
						FileReader file2 = new FileReader("D:\\Eclipse Workspace\\AP-FlightReservationSystem\\src\\main\\java\\FlightReservationSystem\\Airline Passenger Seat Details");
						@SuppressWarnings("resource") BufferedReader buffer1 = new BufferedReader(file2);

						String templine = "";
						
						while((templine = buffer1.readLine()) != null)
						{
							String[] PassengerSeats = templine.split("_");
							
							String SeatID = PassengerSeats[0];
							String TravelClass = PassengerSeats[1];
							
							AirlinePassengerSeat Seat = new AirlinePassengerSeat(SeatID, TravelClass);
							Admin.AirlinePlane.get(AirlinePlaneCounter).AirlineFlight.get(AirlineFlightCounter).PassengerSeat.add(Seat);
						}

						AirlineFlightCounter++;
						
					}

					AirlinePlaneCounter++;
			}
	
		} catch(FileNotFoundException exception) {
		exception.printStackTrace();			
		}
	}

	@SuppressWarnings("unused") public static void main(String[] args) throws IOException, AirlinePassengerAgeException, NumberFormatException, AirlineFlightSeatException, AirlineFlightTravelAmountException, AirlinePassengerEmptyException 
	{
		//Airline Data Processing
		AirlineDataProcessing();		

		//Admin.AirlinePassenger.add(Passenger);
		
		// Creating Scanner object for user input
		@SuppressWarnings("resource") Scanner input = new Scanner(System.in);

		System.out.println("Emirates Flight Reservation Service\n");

		while(true)
		{	
			System.out.println("\tLogin Interface");
			System.out.println("1. Airline ADMIN Login");
			System.out.println("2. Airline Passenger Login");
			System.out.println("0. Shutdown System");
			int login = input.nextInt();
	
			if (login == 1)	// ADMIN Interface
			{
				System.out.println("\nAdmin Login\n");
				
				System.out.println("\nEnter Admin Username: " );
				String username = input.next();

				System.out.println("Enter Password: ");
				String password = input.next();	

				Admin.LoginInterface(username, password);
				
			}
			else if (login == 2) // Passenger Interface
			{
				System.out.println("Airline Passenger Interface\n");
				System.out.println("1. Already have an account ? Sign-In");
				System.out.println("2. Register new account. Sign-Up\n");
				System.out.println("0. Back");
				int Interface = input.nextInt();
				
				if(Interface == 1)	//Account Sign-In
				{
					System.out.println("Passenger Sign-In Interface\n");

					if (Admin.AirlinePassenger.isEmpty() == true)	
						throw new AirlinePassengerEmptyException("Airline Passengers not Registered yet...");
					
					int PassengerCounter = 0;
					
					PassengerInterface: while(true)
					{
						System.out.println("Enter your AccountID/Username: ");
						String username = input.next();
											
						System.out.println("Enter your Password: ");
						String password = input.next();
						
						System.out.println(username);
						System.out.println(password);
						
						String LoginFlag = Admin.AirlinePassenger.get(PassengerCounter).SignIn(username, password);
						PassengerCounter++;
												
						if(LoginFlag.equals("false"))
							continue;
						else if(LoginFlag.equals("true"))
						{
							System.out.println("Passenger Sign-In Successfull !\n");
							
							while(true)
							{	
								System.out.println("\n1. Search & Book your Airline Flight");
								System.out.println("2. View Ticket Register");
								System.out.println("3. User Profile Display");
								System.out.println("4. Account Settings");
								System.out.println("0. Logout Passenger Interface");
								int PassengerInterface = input.nextInt();
								
								if (PassengerInterface == 1) // Search & Book Funciton
									Admin.SearchFlight(Admin.AirlinePassenger.get(PassengerCounter-1));
								else if (PassengerInterface == 2) //Tickets Inventory Function
									Admin.AirlinePassenger.get(PassengerCounter-1).TicketInventory();
								else if (PassengerInterface == 3) // User Profile Display Function
									Admin.AirlinePassenger.get(PassengerCounter-1).DisplayAirlinePassengerDetails();
								else if (PassengerInterface == 4) // Account Settings Function
									Admin.AirlinePassenger.get(PassengerCounter-1).AccountSettings();
								else if (PassengerInterface == 0) //Terminating Condition
									break PassengerInterface;
							}
						}
					}
				}
				else if(Interface == 2)	//Account Sign-Up
				{
					System.out.println("Passenger Sign-Up Interface\n");
					
					Admin.PassengerSignUp();
				}
				else if(Interface == 0)	//Terminating condition - while loop
					break;
				
				
			}
			else if (login == 0)
			{
				System.out.println("\nShutting down Emirates Airline Reservation System..");
				break;
			}	
		}
	}
}
