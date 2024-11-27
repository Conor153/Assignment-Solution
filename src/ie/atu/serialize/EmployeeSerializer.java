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
	// Assignment part (ii)
	//Declare ArrayList called employees to hold objects of type<Employee>
	private ArrayList<Employee> employees;
	//Declare and initialize FILENAME Constant
	private final String FILENAME = "employees.bin";
	//Declare employeesFile of type File
	private File employeesFile;
	// Default Constructor
	// Assignment part (ii)
	public EmployeeSerializer() {
		// Construct EmployeeList ArrayList
		employees = new ArrayList<Employee>();
		// (ii)Construct the employeesFile
		// instance variable, and create the file
		// by calling the File method createNewFile().
		
		// Construction of a File instance called employeesFile
		// With the path to employees.bin.
		employeesFile = new File(FILENAME);
		
		// When calling createNewFile()
		// an IOException can be thrown
		// A try catch is used to catch the IOException
		// in the event an exception is thrown
		try 
		{
			// Create a new File called employees.bin
			// using createNewFile() method
			employeesFile.createNewFile();
		}
		// Catch an IOException
		catch (IOException ioE) {
			// Print message to console that the file cannot be created
			System.out.println("Cannot create file " + FILENAME + ".");
		}
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
		// the employee to the ArrayList
		if (employee.read() == true) 
			employees.add(employee);
		//If the user has cancelled the add
		//We reduce the static variable employeeNoNext
		//This is to allow that number to be used for the next employee
		else 
			Employee.setNextEmployeeNumber(employee.getEmployeeNo());
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
	public Employee view(){
		//Declare a String called employeeToViewAsString
		//this is to read the netered number from the JOption plane
		String employeeToViewAsString;
		//Declare an int called employeeToView
		//This variable is parsed the string which takes in the number
		
		int employeeToView = 0;
		//Declare a boolean called goodInput
		//to check if the input is valid
		boolean goodInput = false;
		//Do while to allow user to re-enter
		//The value should they input an invalid value into
		// the string
		do
		{
			try
			{	//Display JOption plane to get user to enter an Employee Number
				employeeToViewAsString=JOptionPane.showInputDialog("Enter Employee Number to view");	
				//Parse the string into an integer
				//Can throw an exception if value is not
				//of type int
				employeeToView=Integer.parseInt(employeeToViewAsString); 
				//If exception has not been thrown
				//Assign true to the goodInput
				goodInput = true;
			}
			//Catch a number format exception which can
			//be thrown if string cannot be converted to an int
			catch(NumberFormatException e)
			{
				//An Error Joption plane is displayed
				//Inforing user that number entered was invalid
				JOptionPane.showMessageDialog(null, "Please enter a valid number", "Incorrect Value Entered",
						JOptionPane.ERROR_MESSAGE);
			}	
		//Continue looping until goodInput is true
		}while(!goodInput);
		//For each employee in employees
		//Loop around checking to see if 
		//The entered employee number is equal to an employees employee number
		//inside the ArrayList
        for(Employee tmpEmployee:employees) {
        	//If the employee number is the same as the searched employee number
 		   if(tmpEmployee.getEmployeeNo() == employeeToView){
 			   //Display the employee in a JOPtion plane
 			   JOptionPane.showMessageDialog(null, tmpEmployee);	
 			   //Return the Employee for for edit() and delete()
 			   return tmpEmployee;
 		   }
       }
        //If the employee with the entered employee number
        //has not been found display an information message
        //this is to alert the user that no employee has this eployee number
        JOptionPane.showMessageDialog(null, "Employee Not Found", "View Employee",
				JOptionPane.INFORMATION_MESSAGE);
        //return null to any method that calls view().
	    return null;		
	}

	///////////////////////////////////////////////////////////////////
	// Method Name : delete() //
	// Return Type : void //
	// Parameters : None //
	// Purpose : Deletes the required Employee record from employees //
	///////////////////////////////////////////////////////////////////
	public void delete() {	
		// Call view() to find, display, & return the employee to delete
		Employee tempEmployee = view();

		// If the tempBook != null, i.e. the employee has been found
	    if(tempEmployee != null)
		   // ...remove it from employees
	       employees.remove(tempEmployee);		
	}

	///////////////////////////////////////////////////////////////
	// Method Name : edit() //
	// Return Type : void //
	// Parameters : None //
	// Purpose : Edits the required Employee record in employees //
	///////////////////////////////////////////////////////////////
	public void edit() {	
		// Call view() to find, display, & return the employee to edit
		Employee tempBook = view();

		// If the tempBook != null, i.e. the employee has been found
	    if(tempBook != null){
		   // get it's index
		   int index=employees.indexOf(tempBook);
		   // read in a new employee and...
		   tempBook.read();
		   // reset the object in employees
		   employees.set(index, tempBook);
	    }
	}
	
	// This method will serialize the employees ArrayList when called,
	// i.e. it will write employees to a file called employees.bin
	public void serializeEmployees() {
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
			Employee.setNextEmployeeNumber(employees.get(employees.size()-1).getEmployeeNo()+1);

			is.close();
		} catch (FileNotFoundException fNFE) {
			System.out.println("Cannot open file " + employeesFile.getName() + ".");
		} catch (IOException ioE) {
			System.out.println("Cannot read from " + employeesFile.getName() + ".");
		} catch (Exception e) {
			System.out.println("Cannot read from " + employeesFile.getName() + ".");
		}
	}//End of deserializeEmployees
}//End of Public class EmployeeSerializable