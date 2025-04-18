/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Employee Class
 * Date: 2/10/2024
 * @author Conor Callaghan
**/

package ie.atu.hotel;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Inheritance Employee IS-A Person
//Interface Employee CAN- DO Payable
//Interface Employee CAN- DO Serializable
//Assignment 2
//(i) Make Employee class Serializable
// This is achieved by implementing the Serializable interface
// Employee implements Serializable from Person through inheritance
public class Employee extends Person implements Payable {
//  Employee has name & phoneNumber from Person
//	private Date dateOfBirth;//Employee HAS-A DOB
//	private Date startDate;//Employee HAS-A Start Date
	private double salary;// Employee has a salary
	private int employeeNo;// And a employee No
	// Static int to allocate unique numbers to employeeNo
	private static int employeeNoNext = 10000;

	private final double MAX_SALARY = 150000;

	// Default Constructor
	// Called when a Employee object is created like this ==>
	// Employee e1 = new Employee();
	public Employee() {
		super(); // Called automatically with or without it being here
//		this.dateOfBirth = new Date();
//		this.startDate = new Date();
		this.salary = 0;
		this.employeeNo = employeeNoNext++;
	}

	// Overloaded initialization constructor
	// Called when a Employee object is created like this ==>
	// Name name=new Name("Mr", "Joe", "Bloggs");
	// Employee e2 = new Employee(name, "087 1234567",
	// new Date(25,12,1970),
	// new Date(25,10,2008),
	// 55000);
	public Employee(Name name, String phoneNumber, Date dateOfBirth, Date startDate, double salary) {
		super(name, phoneNumber);// Call Person constructor
//		this.dateOfBirth = dateOfBirth;
//		this.startDate = startDate;
		this.salary = salary;
		this.employeeNo = employeeNoNext++;
	}

	// To string method overrides super class method
	// Calls Person class toString and appends its own part
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return employeeNo + " " + name + "\t €" + df.format(salary) + ".";
	}

	// equals() method
	// ==> Called when comparing an object with another object,
	// e.g. - if(e1.equals(e2))
	// ==> Compares both employee numbers
	@Override // Overrides Person equals()
	public boolean equals(Object obj) {
		Employee eObject;
		if (obj instanceof Employee) {
			eObject = (Employee) obj;
		} else
			return false;
		return this.employeeNo == eObject.employeeNo;
	}

	// @return the dateOfBirth
//	public Date getDateOfBirth() {
//		return dateOfBirth;
//	}
//
//	// dateOfBirth the dateOfBirth to set
//	public void setDateOfBirth(Date dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
//
//	// the startDate
//	public Date getStartDate() {
//		return startDate;
//	}
//
//	// startDate the startDate to set
//	public void setStartDate(Date startDate) {
//		this.startDate = startDate;
//	}

	// return the salary
	public double getSalary() {
		return salary;
	}

	// Set salary the salary to set
	public void setSalary(double salary) {
		this.salary = salary;
	}

	// return the employeeNo
	public int getEmployeeNo() {
		return employeeNo;
	}

	// Former read() method without JOption plane
	// ==> Called by subclasses to read() a Persons details from the user, e.g.
	// super.read();
//	@Override
//	public void read()
//	{
//		Scanner kb= new Scanner(System.in);
//		//Read name and phone number using Super.read()
//		System.out.println("Employee Details:");
//		super.read();
//		System.out.println("Enter Date of Birth:");
//		dateOfBirth.read();
//		System.out.println("Start Date:");
//		startDate.read();
//		System.out.println("Salary:");
//		this.salary=kb.nextDouble();
//		kb.close();
//	}

	//Assignment (iii)
	// read() method that uses JOption Plane
	// Overrides the read() method of super class Person
	@Override
	public boolean read() {
		//Create TextFields for the following values
		//Employee Number, First Name, Last Name
		//Phone Number and Salary
		//Create a JComboBox to allow the user to select
		//A title option
		
		//If the user was to edit an employee the entry fields 
		//will contain the data of the employee they wish to edit
		//this is done by using setText() and setSelectedItem();
		JTextField txtEmployeeNo = new JTextField();
		txtEmployeeNo.setText("" + this.getEmployeeNo());
		JComboBox<String> titleBox = new JComboBox<String>();
		titleBox.addItem("Mr");
		titleBox.addItem("Ms");
		titleBox.addItem("Mrs");
		titleBox.addItem("Miss");
		titleBox.setSelectedItem(this.name.getTitle());
		JTextField txtFirstName = new JTextField();
		txtFirstName.setText(this.name.getFirstName());;
		JTextField txtLastName = new JTextField();
		txtLastName.setText(this.name.getLastName());
		JTextField txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText(this.phoneNumber);
		JTextField txtSalary = new JTextField();
		txtSalary.setText(""+this.getSalary());

		Object[] message = { "Employee Number", txtEmployeeNo, "Title", titleBox, "First Name:",
				txtFirstName, "Last Name", txtLastName, "Phone Number:", txtPhoneNumber, "Salary:", txtSalary };

		JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		int option = JOptionPane.showConfirmDialog(dialog, message, "ENTER EMPLOYEE DETAILS",
				JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			//If the user selects OK
			//the values are assigned to the Employees instance variables
			this.name.setTitle((String) titleBox.getSelectedItem());
			this.name.setFirstName(txtFirstName.getText());
			this.name.setLastName(txtLastName.getText());
			this.phoneNumber = txtPhoneNumber.getText();
			this.salary=Double.valueOf(txtSalary.getText());
			//A value of true is returned this is to manage
			//the static instance variable employeeNoNext
			return true;
		} else // CANCEL_OPTION
			//If we press cancel we return false
			//to correctly manage the static instance variable employeeNoNext
			return false;
	}
	
	//Assignment (iii) and (vi)
	//setNextEmployeeNumber()is used to change the static
	// variable employeeNoNext
	
	//When called in add we want to reduce the value by 1
	//This is to allow the user to cancel adding an employee
	//and re use the next employee number
	
	//When called in deserialise we want to change the employeeNoNext
	//to one greater than the last employee number of the last employee
	//in the ArrayList 
	public static void setNextEmployeeNumber(int changeStaticEmployeeNumber)
	{
		//Set employeeNoNext to 1 greater than the last Employee Number
		employeeNoNext = changeStaticEmployeeNumber;
	}
	
	
	
	

	// Calculate the pay for the employee
	// Divide salary by 12
	// Divide taxPercentage by 100
	// Multiply both figures to calculate pay
	@Override
	public double calculatePay(double taxPercentage) {
		// return the monthly pay as salary/12 less taxPercentage
		double pay = salary / 12;
		pay -= (pay * (taxPercentage / 100));
		return pay;
	}

	@Override
	public double incrementSalary(double incrementAmount) {
		// add incrementAmount to, and return the new salary
		// salary should not go over a maximum salary of â‚¬150,000
		salary += incrementAmount;

		if (salary > MAX_SALARY)
			salary = MAX_SALARY;

		return salary;
	}

}
