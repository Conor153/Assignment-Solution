/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Person Class
 * Date: 25/9/2024
 * @author Conor Callaghan
**/
package ie.atu.hotel;

import java.io.Serializable;
import java.util.Scanner;

//Person is abstract
//This means it can only be used to inherit from
// It cannot be used to create objects from class Person
public abstract class Person implements Serializable {
	protected Name name;
	protected String phoneNumber;

	// Default Constructor
	// Called by subclasses
	public Person() {
		this.name = new Name();
		this.phoneNumber = "";
	}

	// Initialization Constructor
	// Called when object should be created like this
	// Due to abstract it will not be created
	// Can be used in subclasses
	// Name name = new Name("Mr", "Joe", "Bloggs");
	// Person pObj = new Person(name, "087")
	public Person(Name n, String phone) {
		this.name = n;
		this.phoneNumber = phone;
	}

	// toString() method
	// ==> Calls Name's toString() to display name and
	// then displays address and phoneNumber
	@Override // Overrides Object toString()
	public String toString() {
		return name + "\t" + phoneNumber;
	}

	// equals() method
	// ==> Called when comparing an object with another object,
	// e.g. - if(p1.equals(p2))
	// ==> Calls Name's equals() to compare name to personIn's name, and
	// compares phoneNumber to personIn's phoneNumber
	@Override // Overrides Object equals()
	public boolean equals(Object obj) {
		Person pObject;
		if (obj instanceof Person) {
			pObject = (Person) obj;
		} else
			return false;
		return this.name.equals(pObject.name) && this.phoneNumber.equals(pObject.phoneNumber);
	}

	// read() method
	// ==> Called by subclasses to read() a Persons details from the user, e.g.
	// super.read();
	public boolean read() {
		Scanner kb = new Scanner(System.in);

		System.out.print("Title:");
		this.name.setTitle(kb.nextLine());
		System.out.print("First Name:");
		this.name.setFirstName(kb.nextLine());
		System.out.print("Surname:");
		this.name.setLastName(kb.nextLine());

		System.out.print("Phone Number:");
		this.phoneNumber = kb.nextLine();
		return true;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
