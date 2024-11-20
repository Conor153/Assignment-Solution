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
		try {
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
		// TODO - Update add() so it checks if Cancel was clicked when reading Employee

		// Read its details
		// And add it to the employees ArrayList
		// Only if
		// (iii) If the user selects cancel when adding an employee
		// A boolean value of false is returned
		// However when OK is selected a value of true is returned
		// Only if the user select Ok do we want to add to the arraylist
		if (employee.read() == true) {
			employees.add(employee);
		}
		else 
		{}
			//Must reduce the static value
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
		JOptionPane.showMessageDialog(null, "view() method must be coded!", "NOT IMPLEMENTED",
				JOptionPane.INFORMATION_MESSAGE);
			//Converting number into string requires try catch block
		return null;
	}

	///////////////////////////////////////////////////////////////////
	// Method Name : delete() //
	// Return Type : void //
	// Parameters : None //
	// Purpose : Deletes the required Employee record from employees //
	///////////////////////////////////////////////////////////////////
	public void delete() {
		// TODO - Write the code for delete()
		JOptionPane.showMessageDialog(null, "delete() method must be coded!", "NOT IMPLEMENTED",
				JOptionPane.INFORMATION_MESSAGE);
		
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
		// TODO - Write the code for edit()
		JOptionPane.showMessageDialog(null, "edit() method must be coded!", "NOT IMPLEMENTED",
				JOptionPane.INFORMATION_MESSAGE);
	}

	// This method will serialize the employees ArrayList when called,
	// i.e. it will write employees to a file called employees.bin
	public void serializeEmployees() {
		// TODO - Write the code for serializeEmployees()
		JOptionPane.showMessageDialog(null, "You must write the code for the serializeEmployees() method.",
				"NOT IMPLEMENTED", JOptionPane.INFORMATION_MESSAGE);
		//Finally blocks!!!!!!
//		finally {
//			.close for the file
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
		//Get the last employee in arraylist.
		//Get their empNo
		//Assign it to the static variable +1
		//Employee.setnextNumber(); create this static method
	}
}