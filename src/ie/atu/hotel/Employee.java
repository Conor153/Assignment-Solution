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
//Assigment 2
//(i) Make Employee class Serializable
//This is achieved by implementing the Serializable interface as seen in
public class Employee extends Person implements Payable, Serializable {
	// Employee has name & phoneNumber from Person
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

	// read() method that uses JOption Plane
	// Overrides the read() method of super class Person
	@Override
	public boolean read() {
		JTextField txtEmployeeNo = new JTextField();
		txtEmployeeNo.setText("" + this.getEmployeeNo());
		JComboBox<String> titleBox = new JComboBox<String>();
		titleBox.addItem("Mr");
		titleBox.addItem("Ms");
		titleBox.addItem("Mrs");
		titleBox.addItem("Miss");
		JTextField txtFirstName = new JTextField();
		JTextField txtLastName = new JTextField();
		JTextField txtPhoneNumber = new JTextField();
		JTextField txtSalary = new JTextField();

		Object[] message = { "Employee Number", txtEmployeeNo, "Title", titleBox, "First Name:",
				txtFirstName, "Last Name", txtLastName, "Phone Number:", txtPhoneNumber, "Salary:", txtSalary };

		JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		int option = JOptionPane.showConfirmDialog(dialog, message, "ENTER EMPLOYEE DETAILS",
				JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			this.name.setTitle((String) titleBox.getSelectedItem());
			this.name.setFirstName(txtFirstName.getText());
			this.name.setLastName(txtLastName.getText());
			this.phoneNumber = txtPhoneNumber.getText();
			this.salary=Double.valueOf(txtSalary.getText());
			return true;
		} else // CANCEL_OPTION
			return false;
	}
	
	//(iii) 
	//reduceNextEmployeeNumber decreases the value of employeeNoNext by 1
	//In the event of the user pressing cancel the employeeNoNext 
	//will have increased and skip over an employeeNumber
	//e.g Emp1 given 10000 
	//Cancel was pressed after trying to add an employee
	//10001 gets unused and skipped
	//Emp2 would get 10002
	
	public static void setNextEmployeeNumber()
	{
		--employeeNoNext;//Reduce employeeNoNext by 1
		
	}
	
	public static void setNextEmployeeNumber(int lastEmployeeNumber)
	{
		employeeNoNext = lastEmployeeNumber;//Reduce employeeNoNext by 1
		
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
