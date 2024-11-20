/**

 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Employee Tester
 * Date: 2/10/2024
 * @author Conor Callaghan
**/

package ie.atu.tester;

import java.text.DecimalFormat;
import java.util.ArrayList;

import ie.atu.hotel.Date;
import ie.atu.hotel.Employee;
import ie.atu.hotel.Name;

public class EmployeeTester {

	public static void main(String[] args) {
		ArrayList <Employee> employees = new ArrayList<Employee>();
		
		Name name = new Name("Ms", "Faye", "McGuire");
		Date dob = new Date (7,12,2000);
		Date startDate = new Date (12,10,2020);
		Employee e1 = new Employee(name,"087 1234567", dob, startDate, 24000.00);
		
		name = new Name("Mr", "Ben", "Carson");
		dob = new Date(20,10,1980);
		startDate = new Date (10,10,2012);
		Employee e2 = new Employee(name,"086 1234567", dob, startDate, 42000.00);
		
//		name = new Name("Mr", "Mark", "Logan");
//		dob = new Date (7,12,2000);
//		startDate = new Date (12,10,2020);
		Employee e3 = new Employee();
		
		e3.read();
		
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);		for(Employee e : employees)
			System.out.println(e);
		for(Employee e : employees)
		{
			if(e.getSalary()<30000)
				e.incrementSalary(1000);
			System.out.println(e);
		}
		System.out.println("");
		System.out.println("EMPLOYEES TAKE HOME PAY");
		DecimalFormat df=new DecimalFormat("#.00");
		for(Employee e : employees)
		{
			if(e.getSalary()<35000)
				System.out.println(e.getEmployeeNo()+ "\t"+e.getName()+ "\t€"+ df.format(e.calculatePay(20)));
			else
				System.out.println(e.getEmployeeNo()+ "\t"+e.getName()+ "\t€"+ df.format(e.calculatePay(40)));
			
		}
	}

}
