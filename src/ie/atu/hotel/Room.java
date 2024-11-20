/**
 * Class: Software Implementation B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Class Room - Developed for the Hotel System
 * Date: 16/10/2024
 * @author Conor Callaghan
 * @version 1.0
 */
package ie.atu.hotel;
//Imports that are used
import java.text.DecimalFormat;

//Room implements Reservable interface
public class Room implements Reservable
{
	//A room has a number
	//It is of type int
	private int roomNumber;
	//A type of room it can be one of the following 3
	//KING FAMILY or DOUBLE 
	//It is of type String
	private String roomType;
	//Every room has a price which will have a minimum of €100
	//It is of type int
	private double pricePerNight;
	//A room will either be allocated for the night or unallocated
	//It is of type boolean
	private boolean allocated;
	
	//Constructor for Room
	//Called to create a Room object
	//Contains roomNumber, roomType, pricePerNight, allocated
	//Can throw an IllegalArgumentException if pricePerNight is less than €100
	//Can also throw an IllegalArgumentException if roomType is not one of the following
	//KING FAMILY or DOUBLE
	//Room room1=new Room(2,"Family",120.00,false);
	public Room(int roomNumber, String roomType, double pricePerNight, boolean allocated)throws IllegalArgumentException
	{
		//A(i)
		//If pricePerNight is less than €100 throw new IllegalArgumentException
		if(pricePerNight<100)
		{
			throw new IllegalArgumentException("Invalid Price Entered");
		}//End of if statement
		//A(ii)
		//If !roomType.equals("DOUBLE") && !roomType.equals("KING") && !roomType.equals("FAMILY") throw new IllegalArgumentException
		if(!roomType.equals("DOUBLE") && !roomType.equals("KING") && !roomType.equals("FAMILY"))
		{
			throw new IllegalArgumentException("Invalid Room Type Entered");
		}//End of if statement
		//Only allocate variables if no exception has been thrown
		this.pricePerNight=pricePerNight;
		this.roomType=roomType;
		this.roomNumber=roomNumber;
		this.allocated=false;
	}//End of constructor
	
	//Overwrite the toString method of Object class
	@Override
	public String toString() 
	{
		//Decimal Format is created to format out string
		//When we print out the price we only want it to 2 decimal places
		DecimalFormat df=new DecimalFormat("#.00");
		//return the string
		return roomNumber + " " + roomType + " ROOM @ €" + df.format(pricePerNight) + " per night " + (allocated ? "BOOKED" : "FREE");
	}//End of string method
	
	//Overwrite the equals method of Object class
	@Override
	public boolean equals(Object obj)
	{
	   //Create a room object called rObject
	   Room rObject;
	   //Check if the object that has been passed in
	   //Is of type Room
	   if (obj instanceof Room)
		   //If it is of type room cast it as a Room Object
		   //And assign it to rObject
		   rObject = (Room)obj;
	   else
		   //If obj is not an instance of room return false
	       return false;
	   //Check if the roomNumbers of the current object and the rObject are the same
	   //If they are the same return true
	   //If not the same return false
	   return this.roomNumber == (rObject.roomNumber);
	}//End of equals method
	
	//Set Methods
	//Used to set values of variables in the objects
	//SetRoomNumber() sets the roomNumber of the object
	public void setRoomNumber(int roomNumber){
		this.roomNumber=roomNumber;
	}//End of SetRoomNumber method
	
	//setRoomType() sets the setRoomType of the object
	public void setRoomType(String roomType){
		this.roomType=roomType;
	}//End of setRoomType method
	
	//setPricePerNight() sets the pricePerNight of the object
	public void setPricePerNight(double pricePerNight){
		this.pricePerNight=pricePerNight;
	}//End of setPricePerNight method
	
	//setAllocated() sets the allocation variable of the object
	public void setAllocated(boolean allocated) {
		this.allocated=allocated;
	}//End of setAllocated method
	
	//Get methods
	//Used to retrieve the values from the variables in the objects
	//getNumber()gets the roomNumber of the object
	public int getNumber() {
		return roomNumber;
	}//End of getNumber method
	
	//getRoomType() gets the getRoomType of the object
	public String getRoomType() {
		return roomType;
	}//End of getRoomType method
	
	//getPricePerNight()gets the pricePerNight of the object
	public double getPricePerNight() {
		return pricePerNight;
	}//End of getPricePerNight method
	
	//getAllocated()gets the allocated variable of the object
	public boolean getAllocated() {
		return allocated;
	}//End of getAllocated method
	
	//B(ii)
	//Method from Reservable interface
	//Must be overriden and implemented
	//Used to reserve a room if it has not already been reserved
	@Override
	public void reserve()
	{
		//If this room has not been booked
		if(!this.getAllocated())
		{	
			//set the allocation of this room to true
			setAllocated(true);
			//Print out that this room has now been reserved
			System.out.println("Room "+this.roomNumber+" is reserved");
		}//End if statement
	}//End of reserve method
	
	//Method from Reservable interface
	//Must be overriden and implemented
	//Used to cancel a reservation of a room if it has already been reserved
	@Override
	public void cancel()
	{
		//If this room is allocated
		if(this.getAllocated())
		{	
			//Set the allocation of the room to false
			setAllocated(false);
			//Print out that the room is now available to be booked
			System.out.println("Room "+this.roomNumber+" is available");
		}//End if statement
	}//End of cancel method
	
	
	
}//End of class