/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Name Tester
 * Date: 18/9/2024
 * @author Conor Callaghan
**/
package ie.atu.tester;

import ie.atu.hotel.Name;

public class NameTester {

	public static void main(String[] args) {
		//Construct 6 names
		Name n1 = new Name();//Deafult Constructor
		Name n2 = new Name("Mr", "Homer", "Simpson");//Overloaded Constructor
		Name n3 = new Name("Mrs","Marge", "Simpson");
		Name n4 = new Name("mIsS", "Lisa", "Simpson");
		Name n5 = new Name("Mr", "Homer", "Simpson");
		//Test toString methods
		//Print out the names
		String name = n4.toString();
		System.out.println(n3);
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(name);
		//Test Set methods on n1
		n1.setFirstName("Darwin");
		n1.setLastName("Nunez");
		n1.setTitle("Mr");
		System.out.println(n1);
		//Get methods on n1
		System.out.println("Title "+n1.getTitle());
		System.out.println("F Name "+n1.getFirstName());
		System.out.println("L Name "+n1.getLastName());
		
		if(n1.equals(n1)){
			System.out.println("Same Person");
		}
		else {
			System.out.println("NOT Same Person");
		}
		
		if(n5.isFemale()) {
			System.out.println(n4+"IS Female");
		}
		
	}

}
