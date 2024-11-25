/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Employee Serializer
 * Date: 20/11/2024
 * @author Conor Callaghan
**/
package ie.atu.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import ie.atu.hotel.Employee;

public class EmployeeSerializer {
	private ArrayList<Employee> employees;

	private final String FILENAME = "employees.bin";
	private File employeesFile;
	
	//(iv) and (v) Scanner to allow users to
	//enter an employee number to search for
	//and either view or delete the record
	Scanner kb= new Scanner(System.in);
	
	//(iv) and (v) requires to enter an employee number to search for
	// SearchEmpNumber is a global variable so it can be used in both
	// methods
	private int searchEmpNumber;

	// Default Constructor
	public EmployeeSerializer() {
		// Construct EmployeeList ArrayList
		employees = new ArrayList<Employee>();
		// (ii)Construct the employeesFile
		// instance variable, and create the file
		// by calling the File method createNewFile()

		// Construction of a File instance called employeesFile
		// With the path to employees.bin
		employeesFile = new File(FILENAME);
		// When calling createNewFile()
		// an IOException can be thrown
		// A try catch is used to catch the IOException
		// in the event an exception is thrown
		try 
		{
			// Create a new File called employees.bin
			employeesFile.createNewFile();
		}
		// Catch an IOException
		catch (IOException ioE) {
			// Print message to console that the file cannot be created
			System.out.println("Cannot create file " + FILENAME + ".");
		}
		// TODO Construct employeesFile and physically create the File

	}

	/////////////////////////////////////////////////////////////
	// Method Name : add() //
	// Return Type : void //
	// Parameters : None //
	// Purpose : Reads one Employee record from the user //
	// and adds it to the ArrayList called employees //
	/////////////////////////////////////////////////////////////
	public void add() {
		// Create an Employee object
		Employee employee = new Employee();
		// Read its details
		// And add it to the employees ArrayList
		// Only if
		// (iii) If the user selects cancel when adding an employee
		// A boolean value of false is returned
		// However when OK is selected a value of true is returned
		// Only if the user select Ok do we want to add 
		// the employee to the arraylist
		if (employee.read() == true) 
			employees.add(employee);
		//If the user has cancelled the add
		//We reduce the static variable employeeNoNext
		//This is to allow that number to be used for the next employee
		else 
			Employee.setNextEmployeeNumber();
	}

	///////////////////////////////////////////////////////
	// Method Name : list() //
	// Return Type : void //
	// Parameters : None //
	// Purpose : Lists all Employee records in employees //
	///////////////////////////////////////////////////////
	public void list() {
		String employeesToList = "";

		if (!employees.isEmpty()) {
			// for every Employee object in employees
			for (Employee tmpEmployee : employees) {
				// add it to employeesToList and
				employeesToList += tmpEmployee;
				// add a newline
				employeesToList += "\n";
			}

			// Display employeesToList in a messageDialog
			JOptionPane.showMessageDialog(null, employeesToList, "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);
		} else
			// Display "No Employees stored..." in messageDialog
			JOptionPane.showMessageDialog(null, "No Employees to list.", "EMPLOYEE LIST",
					JOptionPane.INFORMATION_MESSAGE);
	}

	////////////////////////////////////////////////////////////////
	// Method Name : view() //
	// Return Type : Employee //
	// Parameters : None //
	// Purpose : Displays the required Employee record on screen //
	// : And returns it, or null if not found //
	////////////////////////////////////////////////////////////////
	public Employee view() {
		// TODO - Write the code for view()
		System.out.println("EnternEmployee number to search:");
		searchEmpNumber = kb.nextInt();
		kb.close();
		for(Employee e: employees)
		{
			if(e.getEmployeeNo() == searchEmpNumber)
				return e;
		}
		return null;

	}

	///////////////////////////////////////////////////////////////////
	// Method Name : delete() //
	// Return Type : void //
	// Parameters : None //
	// Purpose : Deletes the required Employee record from employees //
	///////////////////////////////////////////////////////////////////
	public void delete() {
		System.out.println("EnternEmployee number to search:");
		searchEmpNumber = kb.nextInt();
		kb.close();
		for(Employee e: employees)
		{
			if(e.getEmployeeNo() == searchEmpNumber)
			{
				 employees.remove(e);
				 break;
			}
			JOptionPane.showMessageDialog(null, "Employee Removed", "They are gone",
					JOptionPane.INFORMATION_MESSAGE);
		}
//		If you delete an Employee you need not re-allocate
//		the number. 
		
		
	}

	///////////////////////////////////////////////////////////////
	// Method Name : edit() //
	// Return Type : void //
	// Parameters : None //
	// Purpose : Edits the required Employee record in employees //
	///////////////////////////////////////////////////////////////
	public void edit() {
		// Create an Employee object
				Employee employee = new Employee();
				// Find position of employee to edit 
				if (employee.read() == true) 
					employees.set(employee, position );
		JOptionPane.showMessageDialog(null, "edit() method must be coded!", "NOT IMPLEMENTED",
				JOptionPane.INFORMATION_MESSAGE);
	}

	// This method will serialize the employees ArrayList when called,
	// i.e. it will write employees to a file called employees.bin
	public void serializeEmployees() {
		// TODO - Write the code for serializeEmployees()
//		JOptionPane.showMessageDialog(null, "You must write the code for the serializeEmployees() method.",
//				"NOT IMPLEMENTED", JOptionPane.INFORMATION_MESSAGE);

		FileOutputStream fs;
		ObjectOutputStream os;
		try 
		{
			fs = new FileOutputStream(employeesFile);
					
			os = new ObjectOutputStream(fs);
			
			os.writeObject(employees);
			os.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot create file.");
		}
		catch(IOException e)
		{
			System.out.println("Cannot write to "+ employeesFile.getName()+".");
		}
//		finally 
//		{
//			os.close();
//		}
	}
	
	

	// This method will deserialize the Employees ArrayList when called,
	// i.e. it will restore the employees ArrayList from the file employees.bin
	public void deserializeEmployees() {
		ObjectInputStream is = null;

		try {
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(employeesFile);

			is = new ObjectInputStream(fileStream);

			employees = (ArrayList<Employee>) is.readObject();

			is.close();
		} catch (FileNotFoundException fNFE) {
			System.out.println("Cannot open file " + employeesFile.getName() + ".");
		} catch (IOException ioE) {
			System.out.println("Cannot read from " + employeesFile.getName() + ".");
		} catch (Exception e) {
			System.out.println("Cannot read from " + employeesFile.getName() + ".");
		}
		Employee.setNextEmployeeNumber(employees.get(employees.size()-1).getEmployeeNo()+1);
	}
}