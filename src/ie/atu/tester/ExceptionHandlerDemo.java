/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: ExceptionHandlerDemo
 * Date: 18/9/2024
 * @author Conor Callaghan
**/
package ie.atu.tester;

import java.util.ArrayList;

import javax.swing.*;

import ie.atu.hotel.CreditCard;
import ie.atu.hotel.Date;
import ie.atu.hotel.Guest;
import ie.atu.hotel.Name;

public class ExceptionHandlerDemo 
{
	public static void main(String[] args) 
	{
		//ArrayList used to hold Guest Objects
		ArrayList <Guest> hotelGuests = new ArrayList<Guest>();
		
		//Creating guest 1 Guest Has a name and CreditCard 
		Name name = new Name("Mr", "Homer", "Simpson");
		CreditCard cc = new CreditCard (1111222233334444L, new Date(31,12,2027), 111);
		Guest g1 = new Guest(name,"087 1234567","homer.simpson@atu.ie",cc);
		
		//Creating guest 2 Guest Has a name and CreditCard 
		name = new Name("Mrs", "Marge", "Simpson");
		cc = new CreditCard (5555666677778888L, new Date(31,12,2024), 222);
		Guest g2 = new Guest(name,"086 1234567","marge.simpson@atu.ie",cc);
		
		//Creating guest 3 Guest Has a name and CreditCard 
		name = new Name("Miss", "Lisa", "Simpson");
		cc = new CreditCard (5555666677778889L, new Date(31,3,2024), 333);
		Guest g3 = new Guest(name,"087 9876543","lisa.simpson@atu.ie",cc);
		
		//Add all the guests to the ArrayList
		hotelGuests.add(g1);
		hotelGuests.add(g2);
		hotelGuests.add(g3);
		boolean validInput = false;
		String guestNumberToViewAsString = "";
		do 
		{
			//Enclose risky code into the try block
			try 
			{
				//JOptionPane to read Guest to view from user
				guestNumberToViewAsString = JOptionPane.showInputDialog(null,"Enter Guest to View ("+1+" to "+hotelGuests.size()+")");
				//Convert guestNumberToViewAsaString into an int using parseInt
				int number = Integer.parseInt(guestNumberToViewAsString);
				//Retrieve the guest from the hotelGuests list and display it
				System.out.println(hotelGuests.get(number-1));
				validInput = true;
			}
			//Catch a NumberFormatException which catches if a non valid number is entered e.g xyz
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,guestNumberToViewAsString+" is not a valid number, please re-enter it");
			}
			//Catch a IndexOutOfBoundsException which catches if the number entered is outside the ArrayList
			catch(IndexOutOfBoundsException e)
			{
				JOptionPane.showMessageDialog(null,"You must choose a guest from ( "+1+" to "+hotelGuests.size()+" ). " );
			}
		}while(!validInput);//Keep repeating this until the user enters a valid number
	}
}
