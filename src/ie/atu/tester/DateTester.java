/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Date Tester
 * Date: 18/9/2024
 * @author Conor Callaghan
**/
package ie.atu.tester;

import java.util.Scanner;

import ie.atu.hotel.Date;

public class DateTester {

	public static void main(String[] args) {
		int day=55;
		int month=13;
		int year=-2009;
		Date myDate1 = new Date();
		boolean validInput = false;
		do
		{	
			try 
			{
				//Handle the IllegalArgumentException
				myDate1.setDay(day);
				myDate1.setMonth(month);
				myDate1.setYear(year);
				System.out.println("Date is "+myDate1);
				validInput = true;
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Invalid Day/Month/Year! Re-Enter.\n");
				
				Scanner kb= new Scanner(System.in);
				System.out.println("Day [1-31]:");
				day=kb.nextInt();
				System.out.println("Month [1-12]:");
				month=kb.nextInt();
				System.out.println("Year [1900-2024]:");
				year=kb.nextInt();
			}
		}while(!validInput);
		
		validInput = false;
		do
		{
			try
			{
				Scanner kb= new Scanner(System.in);
				System.out.println("Day [1-31]:");
				day=kb.nextInt();
				System.out.println("Month [1-12]:");
				month=kb.nextInt();
				System.out.println("Year [1900-2024]:");
				year=kb.nextInt();
				
				Date myDate2 = new Date(day,month,year);
				System.out.println("Date is "+myDate2);
				validInput = true;
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Invalid Day/Month/Year! Re-Enter.\n");
			}
		}while(!validInput);
	}

}
