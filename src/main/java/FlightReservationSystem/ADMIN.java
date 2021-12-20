package FlightReservationSystem;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ADMIN
{
	// Attributes
	String FirstName;
	String LastName;
	String AdminID;
	String IDPassword;
	
	//AirlinePlane object ArrayList
	ArrayList<AirlinePlane> AirlinePlane = new ArrayList<AirlinePlane>();
	
	// AirlinePassenger object ArrayList
	ArrayList<AirlinePassenger> AirlinePassenger = new ArrayList<AirlinePassenger>();	
	
	// Default Constructor
	public ADMIN()
	{
		FirstName = null;
		LastName = null;
		AdminID = null;
		IDPassword = null;
	}

	//Parameterized Constructor
	public ADMIN(String fname, String lname, String ID, String Password)
	{
		FirstName = fname;
		LastName = lname;
		AdminID = ID;
		IDPassword = Password;
	}
	
	public void LoginInterface(String username, String password)
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		if (AdminID.equals(username) == true)
		{
			if(IDPassword.equals(password) == true)
			{
				while(true)
				{	
					System.out.println("\nAdmin Interface\n");
					
					System.out.println("1. Airline Plane Information Interface");
					System.out.println("2. Airline Flight Information Interface");
					System.out.println("3. Airline Passenger Information Interface");
					System.out.println("0. Logout Admin Interface");
					int AdminInterface = input.nextInt();
					
					if (AdminInterface == 1)
					{
						System.out.println("Airline Plane Information Interface\n");
						
						while(true)
						{	
							System.out.println("1. Entire Airline Plane Information - Displays details of currently registered Airline Plane(s)");
							System.out.println("2. Search Airline Plane Information - Displays details of a specific registered Airline Plane");
							System.out.println("0. Back");
							int PlaneInformation = input.nextInt();
							
							if (PlaneInformation == 1)
							{
								for(int i=0; i<AirlinePlane.size();i++)
									AirlinePlane.get(i).DisplayAirlinePlaneDetails();
							}
							else if (PlaneInformation == 2)
							{
								System.out.println("Enter an Airline Plane ID: ");
								String PlaneID = input.next();
								
								for(int i=0; i<AirlinePlane.size();i++)
									if (AirlinePlane.get(i).getPlaneFLTID().equals(PlaneID))
										AirlinePlane.get(i).DisplayAirlinePlaneDetails();
							}
							else if (PlaneInformation == 0)
								break;
						}
					}
					else if (AdminInterface == 2)
					{
						System.out.println("Airline Flight Information Interface\n");

						while(true)
						{	
							System.out.println("1. Entire Airline Flight Information - Displays details of currently availiable Airline Flight(s)");
							System.out.println("2. Search Airline Flight Information - Displays details of a specific Airline Flight");
							System.out.println("0. Back");
							int FlightInformation = input.nextInt();
							
							if (FlightInformation == 1)
							{
								for(int i=0; i<AirlinePlane.size();i++)
								{
									for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)
									{
										AirlinePlane.get(i).AirlineFlight.get(j).DisplayAirlineFlightDetails();									
									}
								}
							}
							else if (FlightInformation == 2)
							{
								System.out.println("Enter an Airline Plane ID: ");
								String PlaneID = input.next();

								for(int i=0; i<AirlinePlane.size();i++)
								{
									for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)
									{
										if(AirlinePlane.get(i).getPlaneFLTID().equals(PlaneID) == true)
										AirlinePlane.get(i).AirlineFlight.get(j).DisplayAirlineFlightDetails();									
									}
								}

								for(int i=0; i<AirlinePlane.size();i++)
									if (AirlinePlane.get(i).getPlaneFLTID().equals(PlaneID))
										AirlinePlane.get(i).DisplayAirlinePlaneDetails();
							}
							else if (FlightInformation == 0)
								break;
						}
					}
					else if (AdminInterface == 3)
					{
						System.out.println("Airline Passenger Information Interface\n");

						while(true)
						{	
						
						System.out.println("1. Entire Passenger Information - Displays details of all the Airline Passenger(s) Registered");
						System.out.println("2. Search Passenger Information - Displays details of a specific Airline Passenger Registered");
						System.out.println("0. Back");
						int PassengerInfo = input.nextInt();
						
							if (PassengerInfo == 1)
								for(int i=0;i<AirlinePassenger.size();i++)
									AirlinePassenger.get(i).DisplayAirlinePassengerDetails();
							else if (PassengerInfo == 2)
							{
								System.out.println("Search Passenger Information Interface\n");
								
								System.out.println("Enter the PassengerID: ");
								String passengerID = input.next();
								
								for(int i=0;i<AirlinePassenger.size();i++)
								{	
									if(AirlinePassenger.get(i).getAccountUsername().equals(passengerID))
										AirlinePassenger.get(i).DisplayAirlinePassengerDetails();
								}
							}
							else if (PassengerInfo == 0)
								break;
						}
					}
					else if (AdminInterface == 0)
					{
						System.out.println("\nLogging out Admin Interface...\n");
						break;
					}
				}
			}
			else if (IDPassword.equals(password) != true)
				System.out.println("\nIncorrect Password !\n");
		}
		else if (AdminID.equals(username) != true)
			System.out.println("\nIncorrect Admin ID !\n");
		
	}

	public void PassengerSignUp() throws IOException, AirlinePassengerAgeException
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
				
		System.out.println("Enter your First Name: ");
		String FirstName = input.next();
		System.out.println("Enter your Last Name: ");
		String LastName = input.next();
		
		System.out.println("Enter Account Username: ");
		String AccountUsername = input.next();
		
		System.out.println("Enter new Password: ");
		String pass1 = input.next();

		System.out.println("re-Enter new Password: ");
		String pass2 = input.next();
		
		String AccountPassword = "";
		
		if(pass1.equals(pass2))
			AccountPassword = pass1;
				
		System.out.println("Enter your Passport Number: ");
		String PassportNumber = input.next();
		
		System.out.println("Enter your Home Address: ");
		String HomeAddress = input.nextLine();
		
		System.out.println("Enter Email Address: ");
		String EmailAddress = input.next();
		
		System.out.println("Enter your Phone Number: ");		
		String PhoneNumber = input.next();
		
		System.out.println("Enter your Credit CardID: ");
		String CreditCardNumber = input.next();
		
		System.out.println("Enter your Gender: ");
		String Gender = input.next();
		
		System.out.println("Enter your Age: ");
		int Age = input.nextInt();
		
		AirlinePassenger Passenger = new AirlinePassenger(AccountUsername, AccountPassword, FirstName, LastName, PassportNumber, PhoneNumber, HomeAddress, EmailAddress, CreditCardNumber, Gender, Age);
		
		AirlinePassenger.add(Passenger);
		
		String fileContent = "";
		fileContent += "Account Username: " + AccountUsername + "\n";
		fileContent += "Passenger Name: " + FirstName + " " + LastName + "\n";
		fileContent += "Passport Number: " + PassportNumber + "\n";
		fileContent += "Email Address: " + EmailAddress + "\n";
		fileContent += "Home Address: " + HomeAddress + "\n";
		fileContent += "Phone Number: " + PhoneNumber + "\n";
		fileContent += "Credit Card Number: " + CreditCardNumber + "\n";		
		fileContent += "Genger|Age: " + Gender + "|" + Age + "\n";

		
		String filepath = "D:\\Eclipse Workspace\\AP-FlightReservationSystem\\src\\main\\java\\FlightReservationSystem\\AccountInformation";
		filepath += Passenger.getAccountUsername();
		
		FileWriter stream = new FileWriter(filepath);
		stream.write(fileContent);
		stream.close();

		
		System.out.println("Passenger Account succesfully created !");
	}

	public void SearchFlight(AirlinePassenger Passenger) throws IOException
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("\nAirline Flight Search & Book Interface\n");
		
		System.out.println("\n1. View Flight Calendar");
		System.out.println("2. Search Flights of a particular Departure Date: ");
		System.out.println("3. Search Flights of a particular Destination Date: ");
		System.out.println("4. Search Flights of a particular Departure Location");
		System.out.println("5. Search Flights of a particular Destination Location"); 
		System.out.println("6. Search Flights with the lowest fares");
		System.out.println("7. Display Transit/Connecting Flights");
		System.out.println("8. Display Direct Travelling Flights");
		System.out.println("0. Back");
		int FlightBooking = input.nextInt();
		
		if (FlightBooking == 1)
			FlightCalendar();
		else if (FlightBooking == 2)
		{
			System.out.println("Search Flight Departure Date Interface\n");
			
			System.out.println("Enter the Departure Date");
			System.out.println("Day: ");
			int Day = input.nextInt();
			System.out.println("Month: ");
			int Month = input.nextInt();
			System.out.println("Year: ");
			int Year = input.nextInt();
			
			Date date = new Date(Day, Month, Year);
			
			for(int i=0;i<AirlinePlane.size();i++)
			{				
				for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)	
				{
					if (AirlinePlane.get(i).AirlineFlight.get(j).getFlightDepartureDate().getDate().equals(date.getDate()) == true)
					{
						AirlinePlane.get(i).DisplayAirlinePlaneDetails();
						AirlinePlane.get(i).AirlineFlight.get(j).DisplayAirlineFlightDetails();
					}
				}
			}

			BookFlight(Passenger);
		}
		else if (FlightBooking == 3)
		{
			System.out.println("Search Flight Destination Date Interface");
			
			System.out.println("Enter the Destination Date");
			System.out.println("Day: ");
			int Day = input.nextInt();
			System.out.println("Month: ");
			int Month = input.nextInt();
			System.out.println("Year: ");
			int Year = input.nextInt();
			
			Date date = new Date(Day, Month, Year);
			
			for(int i=0;i<AirlinePlane.size();i++)
			{				
				for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)	
				{
					if (AirlinePlane.get(i).AirlineFlight.get(j).getFlightDepartureDate().getDate().equals(date.getDate()) == true)
					{
						AirlinePlane.get(i).DisplayAirlinePlaneDetails();
						AirlinePlane.get(i).AirlineFlight.get(j).DisplayAirlineFlightDetails();
					}
				}
			}		

			BookFlight(Passenger);
		}
		else if (FlightBooking == 4)
		{
			System.out.println("Search Flight Departure Location Interface\n");
			
			System.out.println("Enter the Departure Location ");
			String Location = input.next();
			
			for(int i=0;i<AirlinePlane.size();i++)
			{				
				for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)	
				{
					if (AirlinePlane.get(i).AirlineFlight.get(j).getFlightDepartureLocation().equals(Location) == true)
					{
						AirlinePlane.get(i).DisplayAirlinePlaneDetails();
						AirlinePlane.get(i).AirlineFlight.get(j).DisplayAirlineFlightDetails();
					}					
				}
			}
			
			BookFlight(Passenger);
		}
		else if (FlightBooking == 5)
		{
			System.out.println("Search Flight Destination Location Interface\n");
			
			System.out.println("Enter the Destination Location ");
			String Location = input.next();
			
			for(int i=0;i<AirlinePlane.size();i++)
			{				
				for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)	
				{
					if (AirlinePlane.get(i).AirlineFlight.get(j).getFlightDestinationLocation().equals(Location) == true)
					{
						AirlinePlane.get(i).DisplayAirlinePlaneDetails();
						AirlinePlane.get(i).AirlineFlight.get(j).DisplayAirlineFlightDetails();
					}					
				}
			}
			
			BookFlight(Passenger);
		}
		else if (FlightBooking == 6)
		{
			System.out.println("Search Lowest Fare Flight Interface");
			
			for(int i=0;i<AirlinePlane.size();i++)
			{				
				for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)
				{
					AirlinePlane.get(i).DisplayAirlinePlaneDetails();
					AirlinePlane.get(i).AirlineFlight.get(j).DisplayAirlineFlightDetails();
					System.out.println("Lowest Flight Fare: " + AirlinePlane.get(i).AirlineFlight.get(j).getEconomySeatAmount());
				}
			}	
			
			BookFlight(Passenger);
		}
		else if (FlightBooking == 7)
		{
			System.out.println("Search Transit/Connecting Flight Interface\n");
			
			for(int i=0;i<AirlinePlane.size();i++)
			{				
				for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)
				{
					if (AirlinePlane.get(i).AirlineFlight.get(j).getFlightTransitLocation().equals("none") == true)
						continue;
					else
					{
						AirlinePlane.get(i).DisplayAirlinePlaneDetails();
						AirlinePlane.get(i).AirlineFlight.get(j).DisplayAirlineFlightDetails();
					}	
				}
			}
			
			BookFlight(Passenger);
		}
		else if (FlightBooking == 8)
		{
			System.out.println("Search Direct Travelling Flight Interface\n");

			for(int i=0;i<AirlinePlane.size();i++)
			{				
				for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)
				{
					if (AirlinePlane.get(i).AirlineFlight.get(j).getFlightTransitLocation().equals("none") == true)
					{
						AirlinePlane.get(i).DisplayAirlinePlaneDetails();
						AirlinePlane.get(i).AirlineFlight.get(j).DisplayAirlineFlightDetails();
					}	
				}
			}													
			
			BookFlight(Passenger);
		}
		else if (FlightBooking == 0)
			return;	
	}
	
	public void BookFlight(AirlinePassenger Passenger) throws IOException
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("Do you want book a Flight ? (Yes/No)");
		String Booking = input.next();

		System.out.println("Airline Flight Booking Inteface\n");
		
		if(Booking.equals("Yes") || Booking.equals("yes"))
		{
			System.out.println("Enter Plane FLTID: ");
			String FLTDID = input.next();
						
			System.out.println("Enter Departure Date");
			System.out.println("Day: ");
			int Day = input.nextInt();
			System.out.println("Month: ");
			int Month = input.nextInt();
			System.out.println("Year: ");
			int Year = input.nextInt();
			
			Date DepartureDate = new Date(Day, Month, Year); 
			
			System.out.println("Enter Destination Date");
			System.out.println("Day: ");
			Day = input.nextInt();
			System.out.println("Month: ");
			Month = input.nextInt();
			System.out.println("Year: ");
			Year = input.nextInt();
			
			Date DestinationDate = new Date(Day, Month, Year);
			
			System.out.println("Enter Flight Travel Class: ");
			String TravelClass = input.next();
						
			AirlineTicket(Passenger, FLTDID, DepartureDate, DestinationDate, TravelClass);
		}
		else
			return;			
	}
	
	public void FlightCalendar()
	{
		System.out.println("\nFlight Calendar Interface\n");
		
		for(int i=0;i<AirlinePlane.size();i++)
		{
			AirlinePlane.get(i).DisplayAirlinePlaneDetails();
			
			for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)				
				AirlinePlane.get(i).AirlineFlight.get(j).DisplayAirlineFlightDetails();
		}
	}
		
	public void PrintTicket(AirlineFlight Flight, AirlinePassenger Passenger) throws IOException
	{
		System.out.println("Ticket Printing Interface\n");
	
		System.out.println("My Boarding Pass");
		System.out.println("PassengerID: " + Passenger.getAccountUsername());
		System.out.println("Passenger Name: Mr. " + Passenger.getFirstName() + " " + Passenger.getLastName());
		System.out.println("Airline Flight Departure Location: " + Flight.getFlightDepartureLocation());
		System.out.println("Airline Flight Departure Time: " + Flight.getFlightDepartureDate().getDate() + " " + Flight.getFlightDepartureTime().getTime());
		System.out.println("Airline Flight Connecting/Transit Location: " + Flight.getFlightTransitLocation());		
		System.out.println("Airline Flight Destination Location: " + Flight.getFlightDestinationLocation());
		System.out.println("Airline Flight Destination Time: " + Flight.getFlightDestinationDate().getDate() + " " + Flight.getFlightDestinationTime().getTime());
		
		String SeatID = "";
		
		for(int i=0;i<AirlinePlane.size();i++)
		{
			for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)
			{
				for(int k=0;k<AirlinePlane.get(i).AirlineFlight.get(j).PassengerSeat.size();k++)
				{
					if(AirlinePlane.get(i).AirlineFlight.get(j).PassengerSeat.get(k).getPassengerID().equals(Passenger.getAccountUsername()) == true)
					{
						SeatID = AirlinePlane.get(i).AirlineFlight.get(j).PassengerSeat.get(k).getSeatID();
						System.out.println("Airline Passenger SeatID: " + AirlinePlane.get(i).AirlineFlight.get(j).PassengerSeat.get(k).getSeatID());						
					}
				}
			}
		}

		System.out.println("Airline Flight Duration: " + Flight.getFlightDuration().getTime());
		System.out.println("");
		
		String fileContent = "";
		fileContent += "PassengerID: " + Passenger.getAccountUsername() + "\n";
		fileContent += "Passenger Name: Mr. " + Passenger.getFirstName() + " " + Passenger.getLastName() + "\n";
		fileContent += "Flight Departure Location: " + Flight.getFlightDepartureLocation() + "\n";
		fileContent += "Flight Departure Time: " + Flight.getFlightDepartureDate().getDate() + " " + Flight.getFlightDepartureTime().getTime() + "\n";
		fileContent += "Airline Flight Connecting/Transit Location: " + Flight.getFlightTransitLocation() + "\n";		
		fileContent += "Airline Flight Destination Location: " + Flight.getFlightDestinationLocation() + "\n";
		fileContent += "Airline Flight Destination Time: " + Flight.getFlightDestinationDate().getDate() + " " + Flight.getFlightDestinationTime().getTime() + "\n";
		fileContent += "Airline Passenger SeatID: " + SeatID + "\n";						
		fileContent += "Airline Flight Duration: " + Flight.getFlightDuration().getTime() + "\n";
		String filepath = "D:\\Eclipse Workspace\\AP-FlightReservationSystem\\src\\main\\java\\FlightReservationSystem\\TicketInventory" + Passenger.getAccountUsername();
		
		FileWriter stream = new FileWriter(filepath);
		stream.write(fileContent);
		stream.close();
	}
	
	public void AirlineTicket(AirlinePassenger Passenger, String PlaneID, Date DepartureDate, Date DestinationDate, String TravelClass) throws IOException
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		for(int i=0;i<AirlinePlane.size();i++)
		{				
			if(AirlinePlane.get(i).getPlaneFLTID().equals(PlaneID) == true)
			{		
				for(int j=0;j<AirlinePlane.get(i).AirlineFlight.size();j++)	
				{
					if (AirlinePlane.get(i).AirlineFlight.get(j).getFlightDepartureDate().getDate().equals(DepartureDate.getDate()) == true)
					{
						if(AirlinePlane.get(i).AirlineFlight.get(j).getFlightDestinationDate().getDate().equals(DestinationDate.getDate()) == true)
						{
							System.out.println("Airline Pasenger Seat Selection Interface\n");

							for(int c=0;c<AirlinePlane.get(i).AirlineFlight.get(j).PassengerSeat.size();c++)
								AirlinePlane.get(i).AirlineFlight.get(j).PassengerSeat.get(c).DisplaySeatDetails();

							System.out.println("Enter your SeatID: ");
							String SeatID = input.next();
									
							System.out.println("Enter your Credit Card Number: ");
							String CreditCard = input.next();
							
							if (AirlinePassenger.get(i).getAccountUsername().equals(Passenger.getAccountUsername()))
							{
								if (Passenger.getCreditCardNumber().equals(CreditCard))
								{										
									for(int temp=0;temp<AirlinePlane.get(i).AirlineFlight.get(j).PassengerSeat.size();temp++)
									{
										if(AirlinePlane.get(i).AirlineFlight.get(j).PassengerSeat.get(temp).getSeatID().equals(SeatID) == true)
										{	
											AirlinePlane.get(i).AirlineFlight.get(j).PassengerSeat.get(temp).SeatReservation(Passenger.getAccountUsername());

											if(TravelClass.equals("Economy") == true)
											{	
												int capacity = AirlinePlane.get(i).AirlineFlight.get(j).getEconomySeatCapacity();
												capacity--; AirlinePlane.get(i).AirlineFlight.get(j).setEconomySeatCapacity(capacity);
												PrintTicket(AirlinePlane.get(i).AirlineFlight.get(j), Passenger);
											}
											else if(TravelClass.equals("Business") == true)
											{
												int capacity = AirlinePlane.get(i).AirlineFlight.get(j).getBusinessSeatCapacity();
												capacity--; AirlinePlane.get(i).AirlineFlight.get(j).setBusinessSeatCapacity(capacity);													
												PrintTicket(AirlinePlane.get(i).AirlineFlight.get(j), Passenger);
											}
											else if(TravelClass.equals("First") == true)
											{
												int capacity = AirlinePlane.get(i).AirlineFlight.get(j).getFirstSeatCapacity();
												capacity--; AirlinePlane.get(i).AirlineFlight.get(j).setFirstSeatCapacity(capacity);													
												PrintTicket(AirlinePlane.get(i).AirlineFlight.get(j), Passenger);
											}
										}
									}
									
									System.out.println("Transaction Completed ! Your Airline Flight Seat has been booked..");
								}
							}
						}									
					}
				}
			}
		}					
	}
	
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAdminID() {
		return AdminID;
	}

	public void setAdminID(String adminID) {
		AdminID = adminID;
	}

	public String getIDPassword() {
		return IDPassword;
	}

	public void setIDPassword(String iDPassword) {
		IDPassword = iDPassword;
	}

	public void DisplayAdminDetails()
	{
		System.out.println("ADMIN Details.\n");
		System.out.println("Admin Name: " + FirstName + " " + LastName);
		System.out.println("AdminID: " + AdminID);
		System.out.println("Admin Password: " + IDPassword);
	}
}

