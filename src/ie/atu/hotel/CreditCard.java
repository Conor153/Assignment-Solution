/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: CreditCard Class
 * Date: 25/9/2024
 * @author Conor Callaghan
**/

package ie.atu.hotel;
import java.util.Scanner;

public class CreditCard {
	//Instance Variables
	private long number;
	private Date expiryDate;
	private int securityCode;
	
	//Initialization constructor
	// Called when a CreditCard object is created like
	// CreditCard benCard = new CreditCard(12345678, Date(10,10,2025), 567)
	public CreditCard(long n, Date expiry, int sC)
	{
		this.number=n;
		this.expiryDate=expiry;
		this.securityCode=sC;
	}

	// toString() method
	// ==> Called when a String of the class is used, e.g. - 
	//       System.out.print(joesCard);
	//		 or System.out.print(bensCard.toString());
	@Override
	public String toString() {
		return "CreditCard Number=" + number;
	}

	// equals() method
	// ==> Called when comparing an object with another object, e.g. -
	//       if(bensCard.equals(new CreditCard(1111222233334444,new Date(31,12,2025),999))
	@Override
	public boolean equals(Object obj) {
		CreditCard ccObject;
		if (obj instanceof CreditCard) {
			ccObject = (CreditCard) obj;
		}
		else
			return false;
		return this.number == ccObject.number;
	}
	
	// read() method
	// ==> Called when you when you read() a CreditCards details from the user, e.g.
	//      bensCard.read();
	public void read()
	{
		Scanner kb= new Scanner(System.in);
		System.out.println("Credit Card Details");
		System.out.println("Card Number");
		this.number=kb.nextLong();
		System.out.println("Expirary Date");
		expiryDate.read();
		System.out.println("Security Code");
		this.securityCode=kb.nextInt();
		kb.close();
	}
	public long getNumber() {
		return number;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}

	public int getSecurityCode() {
		return securityCode;
	}
	
}
