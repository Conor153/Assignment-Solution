/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Date Class
 * Date: 18/9/2024
 * @author Conor Callaghan
**/
package ie.atu.hotel;

import java.util.Scanner;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {
		this.day =this.month=1;this.year=1999;
	}
	
	public Date(int day, int month, int year)throws IllegalArgumentException
	{
		
		if(day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2030)
		{
			throw new IllegalArgumentException("Invalid Date Entered");
		}
		
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Date " + day + "/" + month + "/" + year;
	}


	@Override
	public boolean equals(Object obj) {
		Date dObject;
		if(obj instanceof Date)
			dObject = (Date )obj;
		else
			return false;
		return this.day==dObject.day
				&& this.month==dObject.month
				&& this.year==dObject.year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day)throws IllegalArgumentException
	{
		if(day < 1 || day > 31)
		{
			throw new IllegalArgumentException("Invalid Day");
		}
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) throws IllegalArgumentException
	{
		if(month < 1 || month > 12)
		{
			throw new IllegalArgumentException("Invalid Month");
		}
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) throws IllegalArgumentException
	{
		if(year < 1900 || year > 2024)
		{
			throw new IllegalArgumentException("Invalid Year");
		}
		this.year = year;
	}
	// read() method
		// ==> Called to read() a Date from the user, e.g.
		//      dob.read();
		public void read() {
			Scanner kb=new Scanner(System.in);

			System.out.print("Day:");
			this.day=kb.nextInt(); 	
			System.out.print("Month:");
			this.month=kb.nextInt(); 	
			System.out.print("Year:");
			this.year=kb.nextInt(); 	
		}
	
	
	
}
