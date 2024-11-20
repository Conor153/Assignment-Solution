/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Name Class
 * Date: 18/9/2024
 * @author Conor Callaghan
**/
package ie.atu.hotel;

import java.io.Serializable;

public class Name implements Serializable{
	// Instance Variables
	private String title; // title of String class
	private String firstName;// title of String class for first name
	private String lastName;// title of String class for last name
	// Constructor to initialise the Instance Variables
	// Default Constructor
	// Called when a Name object is created without any
	// Input variables
	// Assigns empty values for the
	// Name n1 = new Name();
	public Name() {
		this.title = this.firstName = this.lastName = "";
	}
	// Initilaization Constructor
	// Called when a Name object is created with
	// Input variables for the instance variables
	// The instance variables will recieve the values from the input variables
	// Name n2 = new Name("Mr", "Joe", "Bloggs");
	public Name(String t, String fN, String sN) {
		this.title = t;
		this.firstName = fN;
		this.lastName = sN;
	}
	// getTitle method takes no parameters
	// Returns a String
	// n2.getTitle();
	public String getTitle() {
		return title;
	}
	// setTitle method takes in a String
	// Return is void
	// n1.setTitle("Mr");
	public void setTitle(String title) {
		this.title = title;
	}
	// getFirstName method takes no parameters
	// Returns a String
	// n2.getFirstName();
	public String getFirstName() {
		return firstName;
	}
	// setFirstName method takes in a String
	// Return is void
	// n1.setFirstName("Homer");
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	// getLastName method takes in a String
	// Return is void
	// lastName = n1.getLastName();
	public String getLastName() {
		return lastName;
	}
	// setLastName method takes in a String
	// Return is void
	// n1.setLastName("Simpson");
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	// ToString method takes no parameters
	// Called when a string of the class is used
	// System.out.Print(n2.toString())
	@Override
	public String toString() {
		return title + " " + firstName + " " + lastName;
	}
	// equals method is used to compare 2 name objects
	// if(n1.equals(n2))
	@Override
	public boolean equals(Object obj) {
		Name nObject; // cast the inputed obj
		if (obj instanceof Name)
			nObject = (Name) obj;
		else
			return false;

		return this.title.equals(nObject.title) && this.firstName.equals(nObject.firstName)
				&& this.lastName.equals(nObject.lastName);
	}
	// isFemale method is used to
	// determine if Name belongs to a male or female
	//returns true or false
	public boolean isFemale() {
		return title.equalsIgnoreCase("Miss")|| title.equalsIgnoreCase("Mrs") || title.equalsIgnoreCase("Ms");
	}

}
