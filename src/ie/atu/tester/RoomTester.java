/**
 * Class: Software Implementation B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Interface Reservable - Developed for the Hotel System
 * Date: 16/10/2024
 * @author Conor Callaghan
 * @version 1.0
 */
package ie.atu.tester;

import java.util.ArrayList;

import ie.atu.hotel.CreditCard;
import ie.atu.hotel.Date;
import ie.atu.hotel.Employee;
import ie.atu.hotel.Guest;
import ie.atu.hotel.Name;
import ie.atu.hotel.Person;
import ie.atu.hotel.Room;

//import ie.atu.hotel.*; //Can be used to import all classes

//Tester class to Test Room Class and Reservable Interface
public class RoomTester 
{
	public static void main(String[] args) 
	{
		//A(i)
		//Room room=new Room(1,"double",70.00,false);
		
		//A(ii)
		//Room room1=new Room(1,"single",120.00,false);
		//Room room2=new Room(2,"any type",120.00,false);
		
		
		//ArrayList used to store an ArryList of Room objects 
		//C(i) Create an ArrayList of Rooms called rooms
		ArrayList <Room> rooms = new ArrayList<Room>();
		
		//Try catch used to catch an exception in the event of an exception
		//Used when constructing Room Objects
		try 
		{
			//C(ii) 
			//Create room Objects of type double
			Room doubleRoom1=new Room(1,"DOUBLE",160.00,false);
			Room doubleRoom2=new Room(2,"DOUBLE",160.00,false);
			Room doubleRoom3=new Room(3,"DOUBLE",160.00,false);
			Room doubleRoom4=new Room(4,"DOUBLE",160.00,false);
			Room doubleRoom5=new Room(5,"DOUBLE",160.00,false);
			
			//Create room Objects of type King
			Room kingRoom1=new Room(6,"KING",185.00,false);
			Room kingRoom2=new Room(7,"KING",185.00,false);
			Room kingRoom3=new Room(8,"KING",185.00,false);
			Room kingRoom4=new Room(9,"KING",185.00,false);
			Room kingRoom5=new Room(10,"KING",185.00,false);
			
			//Create room Objects of type Family
			Room familyRoom1=new Room(11,"FAMILY",210.00,false);
			Room familyRoom2=new Room(12,"FAMILY",210.00,false);
			Room familyRoom3=new Room(13,"FAMILY",210.00,false);
			
			//Add all double rooms to ArrayList rooms
			rooms.add(doubleRoom1);
			rooms.add(doubleRoom2);
			rooms.add(doubleRoom3);
			rooms.add(doubleRoom4);
			rooms.add(doubleRoom5);
			
			//Add all king rooms to ArrayList rooms
			rooms.add(kingRoom1);
			rooms.add(kingRoom2);
			rooms.add(kingRoom3);
			rooms.add(kingRoom4);
			rooms.add(kingRoom5);
			
			//Add all family rooms to ArrayList rooms
			rooms.add(familyRoom1);
			rooms.add(familyRoom2);
			rooms.add(familyRoom3);
			
		}//End Try
		//catch any exceptions that may have occurred
		catch(IllegalArgumentException e)
		{
			//Print the exception message
			e.getMessage();
		}//End catch
		
		//C(iii) 
		//Print all rooms in the ArrayList
		System.out.println("ROOMS IN HOTEL");
		//for each r in rooms
		for(Room r : rooms)
		{
			//Print out the rooms in the ArrayList
			System.out.println(r);
		}//End for loop
		System.out.println();//Create an empty line to separate the printing
		
		//C(iv) 
		// Print all Family rooms in the ArrayList
		System.out.println("FAMILY ROOM LIST");
		//create a counter to count number of rooms with type FAMILY
		int counter = 0;
		//for each r in rooms
		for(Room r : rooms)
		{
			//If the roomType is FAMILY print it out
			if(r.getRoomType() == "FAMILY")
			{
				//Print the room details
				System.out.println(r);
				// Add to counter
				counter++;
			}//End if statement
		}//End for loop
		//Print out the number of FAMILY rooms
		System.out.println(counter+" FAMILY ROOM(S)");
		System.out.println();//Create an empty line to separate the printing
		
		// C(v)
		//Reserve the first FAMILY room
		//for each r in rooms
		for(Room r : rooms)
		{
			//If the roomType is FAMILY reserve it
			if(r.getRoomType() == "FAMILY")
			{
				//Room r will be reserved
				r.reserve();
				break;//We break out of for loop so that 
					  //only the first room will be reserved
			}//End if statement
		}//End for loop
		System.out.println();//Create an empty line to separate the printing
		
		//C(vi) 
		//Print out the FAMILY rooms in the ArrayList again
		System.out.println("FAMILY ROOM LIST");
		//for each r in rooms
		for(Room r : rooms)
		{
			if(r.getRoomType() == "FAMILY")
			{
				//Print the room details
				System.out.println(r);
			}//End if statement
		}//End for loop
		System.out.println();//Create an empty line to separate the printing
		
		//C(vii) 
		//Create a Polymorphic ArrayList called peopleInHotel which can
		// store both Employee and Guest objects
		ArrayList <Person> peopleInHotel = new ArrayList<Person>();
		
		//Create both Guest and Employee objects to add into peopleInHotel
		Name name = new Name("Mr", "Homer", "Simpson");
		CreditCard cc = new CreditCard (1111222233334444L, new Date(31,12,2027), 111);
		Guest g1 = new Guest(name,"087 1234567","homer.simpson@atu.ie",cc);
		
		name = new Name("Mrs", "Marge", "Simpson");
		cc = new CreditCard (5555666677778888L, new Date(31,12,2024), 222);
		Guest g2 = new Guest(name,"086 1234567","marge.simpson@atu.ie",cc);
		
		name = new Name("Ms", "Faye", "McGuire");
		Date dob = new Date (7,12,2000);
		Date startDate = new Date (12,10,2020);
		Employee e1 = new Employee(name,"087 1234567", dob, startDate, 24000.00);
		
		name = new Name("Mr", "Ben", "Carson");
		dob = new Date(20,10,1980);
		startDate = new Date (10,10,2012);
		Employee e2 = new Employee(name,"086 1234567", dob, startDate, 42000.00);
		
		//Add the Guest and Employee objects into the polymorphic ArrayList
		peopleInHotel.add(g1);
		peopleInHotel.add(e1);
		peopleInHotel.add(g2);
		peopleInHotel.add(e2);
		
		//Print out the objects in the ArrayList
		for(Person p : peopleInHotel)
		{
			System.out.println(p);
		}//End For loop
		//Will print out both Guests and Employees using 
		//their respective toString methods
		
		
	}//End of main method

}//End of Room Tester class
