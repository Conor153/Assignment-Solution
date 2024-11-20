/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Guest Tester
 * Date: 25/9/2024
 * @author Conor Callaghan
**/

package ie.atu.tester;

import java.util.ArrayList;

import ie.atu.hotel.CreditCard;
import ie.atu.hotel.Date;
import ie.atu.hotel.Guest;
import ie.atu.hotel.Name;

public class GuestTester {

	public static void main(String[] args) {
		//1. Create an ArrayList pf Guests called guests
		ArrayList <Guest> guests = new ArrayList<Guest>();
		Name name = new Name("Mr", "Homer", "Simpson");
		CreditCard cc = new CreditCard (1111222233334444L, new Date(31,12,2027), 111);
		Guest g1 = new Guest(name,"087 1234567","homer.simpson@atu.ie",cc);
		
		name = new Name("Mrs", "Marge", "Simpson");
		cc = new CreditCard (5555666677778888L, new Date(31,12,2024), 222);
		Guest g2 = new Guest(name,"086 1234567","marge.simpson@atu.ie",cc);
		
		name = new Name("Miss", "Lisa", "Simpson");
		cc = new CreditCard (5555666677778889L, new Date(31,3,2024), 333);
		Guest g3 = new Guest(name,"087 9876543","lisa.simpson@atu.ie",cc);
		
		guests.add(g1);
		guests.add(g2);
		guests.add(g3);
		//3.
		//Count male and female Guests
		int female=0;
		int male=0;
		for(Guest g : guests)
		{
			System.out.println(g);
			if(g.getName().isFemale())
				female++;
			else
				male++;
			System.out.println(g.getName()+" "+ g.getCreditCard());
		}
		System.out.println("Male or Female guest count");
		System.out.println("MALES: "+male+"\tFEMALES: "+female);
		for(Guest g : guests)
		{
			System.out.println(g.getName()+" "+ g.getCreditCard());
		}
	}

}
