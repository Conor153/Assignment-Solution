/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Guest Class
 * Date: 25/9/2024
 * @author Conor Callaghan
**/
package ie.atu.hotel;

import java.util.Scanner;

//Guest Is-A person
//Inherits from Person
public class Guest extends Person {
	//guest inherits name and phone no.
	//From person
	//It has an email and a credit card
	private CreditCard creditCard;
	private String email; 
	//Overloaded Constructor called as follows
	//Name aName = new Name();
	//CreditCard cCard = new CreditCard(111111,new Date(10,10,2025),111);
	//Guest aGuest = new Guest(name, "085", "email", cCard);

	// Overloaded initialization constructor
	// Called when a Guest object is created like this ==>
	// Name name=new Name("Mr", "Joe", "Bloggs");
	// CreditCard creditCard=new CreditCard(5555666677778888,new Date(31,12,2026),123);
	// Guest g2 = new Guest(name, "087 1234567", "joe@gmail.com" =, creditCard);
	public Guest(Name n, String pNo, String email, CreditCard cc)
	{
		super(n, pNo);
		this.creditCard = cc;
		this.email = email;
	}
	
	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding emailAddress
	@Override
	public String toString()
	{
		return super.toString()+ "\t"+ email+".";
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//The equals() from Person should be sufficient
	//Its comparing Guest name & name phone Number == unique
	
	// read() method
	// ==> Called when you when you read() a Guest details from the user, e.g.
	//      guest.read();
	public boolean read() {
		super.read();
		Scanner kb= new Scanner(System.in);
		System.out.print("Email Address:");
		this.email=kb.nextLine();
		creditCard.read();
		kb.close();
		return true;
	}
	
}
