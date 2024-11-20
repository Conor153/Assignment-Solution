/**
 * Class: Software Implementation B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Interface Reservable - Developed for the Hotel System
 * Date: 16/10/2024
 * @author Conor Callaghan
 * @version 1.0
 */
package ie.atu.hotel;

//Reservable interface
//Used to describe what will be provided in Room Class
//Allows it to implement Reservable methods in its own implementation
public interface Reservable 
{
	//B(i)
	//Abstract method reserve()
	//Must be @overrided in the class which implements the Reservable interface
	public abstract void reserve();
	//Abstract method cancel
	//Must be @overrided in the class which implements the Reservable interface
	public abstract void cancel();
}//End of Interface
