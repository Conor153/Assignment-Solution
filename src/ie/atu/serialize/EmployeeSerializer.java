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
	//Assignment 2
	//(iii)
	public void add() {
		// Create an Employee object
		Employee employee = new Employee();
		// The Employee read() gets called to insert
		// values into the employee instance variables
		//The read method returns a boolean value
		//This is to check if the user has pressed ok or cancel
		//in the read JOPtion pane
		//If the user has pressed ok then it will be added
		//To the employees ArrayList
		if (employee.read() == true) 
			employees.add(employee);
		//If the user has selected cancel a value of false has been returned
		//The employee has been created and the static variable
		//employeeNoNext has been incremented however no employee has been
		//added to the ArrayList.
		//setNextEmployeeNumber is called to reset the
		//employeeNoNext back to the number that was given to employee
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
	
	//Assignment 2
	//(v)
	//view() is used to view a particular employee that may be
	//inside the employees ArrayList.
	//Users will be displayed a JOPtion Pane where they
	//Enter an Employee Number and a scan through the employees ArrayList
	//Will be conducted to find the employee with that number
	public Employee view(){
		
		//Declare a String employeeToViewAsString which
		//will hold the employee number entered by the user
		String employeeToViewAsString;
		//Declare and initialise an int employeeToView
		//which will hold employeeToViewAsString when it is parsed to
		// an integer
		int employeeToView = 0;
		//Declare a boolean called goodInput
		//to check if the input is valid
		boolean goodInput = false;
		//Do while will allow the user to re-enter the employee number
		//should they enter an invalid value
		do
		{
			try
			{	//Display JOption pane to get user to enter an Employee Number
				employeeToViewAsString=JOptionPane.showInputDialog("Enter Employee Number to view");	
				//Parse the string into an integer
				//It can throw an exception if value is not
				//of type int
				employeeToView=Integer.parseInt(employeeToViewAsString); 
				//If exception has not been thrown
				//Assign true to the goodInput
				goodInput = true;
			}
			//Catch NumberFormatException which can
			//be thrown if the string cannot be converted to an int
			catch(NumberFormatException e)
			{
				//An Error Joption pane is displayed
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
 			   //Display the employee in a JOPtion pane
 			   JOptionPane.showMessageDialog(null, tmpEmployee);	
 			   //Return the Employee for edit() and delete() methods
 			   return tmpEmployee;
 		   }
       }
        //If no employee has the entered employee number
        //has not been found an information message will be displayed
        //this is to alert the user that no employee has this employee number
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
	//delete() is used to remove an employee from the ArrayList
	//It calls the view() method to return an employee to delete
	//It is then removed from the ArrayList by calling the remove method
	public void delete() {	
		// Call view() to find, display, & return the employee to delete
		Employee tempEmployee = view();

		// If the tempEmployee != null, i.e. the employee has been found
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
	
	//(vi)
	//The edit method allows the user to edit an employee in the Employees ArrayList
	//It calls the the view() method to find the employee.
	//An employee if found will be returned and stored in a
	//temporary employee object.
	//The read method will be called on this object allowing 
	//the user to edit its properties
	public void edit() {	
		// Call view() to find, display, & return the employee to edit
		Employee tempEmployee = view();

		// If the tempEmployee != null, i.e. the employee has been found
	    if(tempEmployee != null){
		   // get it's index
		   int index=employees.indexOf(tempEmployee);
		   // read in the new values to be assigned to the employee
		   tempEmployee.read();
		   // overwrite the object in the index where it was placed
		   employees.set(index, tempEmployee);
	    }
	}
	
	// Assignment
	//(iv)
	// When exit is pressed on the JOption Pane
	// The ArrayList must be serialised into a file called
	// employees.bin
	public void serializeEmployees() {
		//Declare FileOutput Stream which is used to 
		//write bytes of data to the employees.bin file
		FileOutputStream fs;
		
		//Declare ObjectOutputStream which is used to 
		//convert the ArrayList into bites so the 
		//FileOutputStream can stream it into the employees.bin file
		ObjectOutputStream os;
		try 
		{
			//Initialise a FileOutputStream using the employees.bin file
			fs = new FileOutputStream(employeesFile);
					
			os = new ObjectOutputStream(fs);
			
			//Write the employees ArrayList to the file
			os.writeObject(employees);
			//Close the file when writing to it has been completed
			os.close();
			
		}
		//Can throw a FileNotFoundException if the file cannot be found
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find or access "+employeesFile.getName()+" .");
		}
		//Can throw an IOException if the ArrayList cannot be written
		//To the file employees.bin
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
			//Assignment 2
			//(viii)
			//When we deserialize the file and recieve our previously
			//saved employees the next employee entered should have
			//An employee number which comes after the last employee
			// i.e last employee has EmployeeNo of 2 next one should be 3
			//Call the setNextEmployeeNumber which sets the static employeeNoNext variable
			//to 1 greater than the last employee number
			//We get the EmployeeNo of the last employee in the ArrayList and add 1 to it.
			//This is the EmployeeNo of the next employee to be added
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