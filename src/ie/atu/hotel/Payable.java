/**
 * Class: B.Sc. in Applied Computing
 * Instructor: Maria Boyle
 * Description: Payable Interface
 * Date: 2/10/2024
 * @author Conor Callaghan
**/

package ie.atu.hotel;

//An interface contains abstract methods only
//It cannot contain instance variables, constructors or
//concrete methods
public interface Payable {

	//public abstract can be contained
	//It will default to this way anyway
	//Classes the implements this interface will
	//Have to override these methods
	double calculatePay(double taxPercentage);
	double incrementSalary(double incrementAmount);
	
}
