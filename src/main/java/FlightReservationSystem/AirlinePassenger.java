package FlightReservationSystem;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AirlinePassenger 
{
	//Attributes
	private String AccountUsername;
	private String AccountPassword;
	
	private String FirstName;
	private String LastName;
	private String PassportNumber;
	private String PhoneNumber;	
	private String HomeAddress;
	private String EmailAddress;
	private String CreditCardNumber;
	private String Gender;
	private int Age;
	
	// Default Constructor
	AirlinePassenger()
	{
		AccountUsername = null;
		AccountPassword = null;
		
		FirstName = null;
		LastName = null;
		PassportNumber = null;
		Gender = null;
		Age = -1;
		HomeAddress = null;
		EmailAddress = null;
		CreditCardNumber = null;
		PhoneNumber = null;		
	}

	//Parameterized Constructor
	AirlinePassenger(String Username, String Password, String fname, String lname, String PNumber, String Phone, String Address, String Email, String CreditCard, String gender, int age) throws AirlinePassengerAgeException
	{
		AccountUsername = Username;
		AccountPassword = Password;

		FirstName = fname;
		LastName = lname;
		PassportNumber = PNumber;
		Gender = gender;
		
		if(age < 0)
			throw new AirlinePassengerAgeException("Airline Passenger Age cannot be zero(0) or a negative(-ve) value");
		else
			Age = age;
		
		HomeAddress = Address;
		EmailAddress = Email;
		CreditCardNumber = CreditCard;
		PhoneNumber = Phone;		
	}	
	
	public String SignIn(String username, String password)
	{
		if(AccountUsername.equals(username) == true)
		{
			if(AccountPassword.equals(password) == true)
			{
				System.out.println("\nAirline Passenger Interface\n");
				System.out.println("Passenger AccountID: " + AccountUsername);
				
				String flag = "true";
				return flag;
			}
			else if(AccountPassword.equals(password) != true)
				System.out.println("\nIncorrect Password !\n");
		}
		else if(AccountUsername.equals(username) != true)
			System.out.println("\nIncorrect Account Username !\n");
		
		String flag = "false";
		return flag;
	}
		
	public void TicketInventory() throws IOException
	{
		System.out.println("Ticket Inventory Interface\n");
		
		String filepath = "D:\\Eclipse Workspace\\AP-FlightReservationSystem\\src\\main\\java\\FlightReservationSystem\\TicketInventory";
		filepath += AccountUsername;
		
		File file = new File(filepath);
		@SuppressWarnings("resource")
		Scanner input = new Scanner(file);
		String fileContent = "";
		
		while(input.hasNextLine())
			fileContent = fileContent.concat(input.nextLine() + "\n");
		
		System.out.println(fileContent);
	}

	public void AccountSettings()
	{
		System.out.println("Passenger Account Settings Interface\n");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
			System.out.println("1. Change Profile Information");		
			System.out.println("2. Change Credit Card Information");
			System.out.println("3. Change Password");
			System.out.println("0. Back");
			int AccountOption = input.nextInt();
			
			if(AccountOption == 1)
			{
				System.out.println("Passenger Profile Interface\n");

				while(true)
				{	
					System.out.println("1. Change Name");		
					System.out.println("2. Change PassportNumber");
					System.out.println("3. Change Home-Address");
					System.out.println("4. Change Email-Address");
					System.out.println("5. Change Phone Number");
					System.out.println("0. Back");
					int ProfileOption = input.nextInt();
					
					
					if(ProfileOption == 1)
					{
						System.out.println("Passenger Name Change Interface\n");
						
						System.out.println("Enter new First Name: ");
						String fname = input.next();
						System.out.println("Enter new Last Name: ");
						String lname = input.next();
						
						setFirstName(fname);
						setLastName(lname);
						
						System.out.println("Name changed successfully !\n");
					}
					else if (ProfileOption == 2)
					{
						System.out.println("Passport Number Change Interface\n");
						
						System.out.println("Enter new Passport Number: ");
						String passnum = input.next();
						
						setPassportNumber(passnum);
						
						System.out.println("Passport Number changed successfully !\n");						
					}
					else if (ProfileOption == 3)
					{
						System.out.println("Home Address Change Interface\n");
						
						System.out.println("Enter new Home Address: ");
						String home = input.next();
						
						this.setHomeAddress(home);	
						
						System.out.println("Home Address changed successfully !\n");						
					}					
					else if (ProfileOption == 4)
					{
						System.out.println("Email Address Change Interface\n");
						
						System.out.println("Enter new Email Address: ");
						String email = input.next();
						
						this.setEmailAddress(email);
						
						System.out.println("Email Address changed successfully !\n");						
					}					
					else if (ProfileOption == 5)
					{
						System.out.println("Phone Change Interface\n");
						
						System.out.println("Enter new Phone Number: ");
						String num = input.next();
						
						this.setPhoneNumber(num);
						
						System.out.println("Email Address changed successfully !\n");						
					}	
					else if(ProfileOption == 0)
						break;
				}	
			}
			else if (AccountOption == 2)
			{
				System.out.println("Credit Card Information Change Interface\n");
				
				System.out.println("Enter new Credit Card Number: ");
				String ccd = input.next();
				
				this.setCreditCardNumber(ccd);
				
				System.out.println("Credit Card Information changed successfully !\n");										
			}
			else if (AccountOption == 3)
			{
				System.out.println("Account Password Change Interface\n");
				
				System.out.println("Enter new Password: ");
				String pass1 = input.next();

				System.out.println("re-Enter new Password: ");
				String pass2 = input.next();

				if(pass1.equals(pass2))
					this.setAccountPassword(pass1);
				else
					System.out.println("Password not match ! ERROR");
				
				System.out.println("Password changed successfully !\n");										
			}
			else if (AccountOption == 0)
				return;		
	}
	
	public String getAccountUsername() {
		return AccountUsername;
	}

	public void setAccountUsername(String accountUsername) {
		AccountUsername = accountUsername;
	}

	public String getAccountPassword() {
		return AccountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		AccountPassword = accountPassword;
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

	public String getPassportNumber() {
		return PassportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		PassportNumber = passportNumber;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getHomeAddress() {
		return HomeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		HomeAddress = homeAddress;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getCreditCardNumber() {
		return CreditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public void DisplayAirlinePassengerDetails()
	{		
		System.out.println("Airline Passenger Details Interface\n");
		System.out.println("Passenger Emirates Account Username: " + AccountUsername);
		System.out.println("Passenger Name: " + FirstName + " " + LastName);
		System.out.println("Passport Number: " + PassportNumber);
		System.out.println("Email Address: " + EmailAddress);
		System.out.println("Home Address: " + HomeAddress);
		System.out.println("Phone Number: " + PhoneNumber);
		System.out.println("Credit Card Number: " + CreditCardNumber);		
		System.out.println("Genger|Age: " + Gender + "|" + Age);
		System.out.println("\n");
	}	
}
