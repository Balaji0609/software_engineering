
package assign2;

/**
 * class to hold the methods and required variables for
 * the purpose of implementing a calculator which adds,
 * subtracts, multiplies and divides a number and even
 * give you the history of calculation.
 * 
 *  @author Balaji Chandrasekaran
 *	@version 1.0 Feb 22,2016
 */

public class Calculator {
	private String history;
	private int sum;
	/**
	 * creates a calculator object with all the class
	 * variable initialized
	 * 
	 */	
	public Calculator () {
		sum = 0;
		history = "0";
	}
	
	/**
	 * This method returns the total of the calculation
	 * done so far when called
	 * @return int Result of the calculation done
	 */
	public int getTotal () {
		return sum;
	}
	
	/**
	 * This method is used for addition . It adds the given
	 * value to the previously calculated value.
	 * @param value the value that is to be added
	 */
	public void add (int value) {
		sum += value;
		history = history + " + " + String.valueOf(value);
	}
	
	/**
	 * This method is used for subtraction. It subtracts
	 * the given value to the previously calculated value.
	 * @param value the value value to be subtracted
	 */
	public void subtract (int value) {
		sum -= value;
		history = history + " - " + String.valueOf(value);
	}
	
	/**
	 * This method is used for multiplication function
	 * the given value is multiplied with the previous
	 * result
	 * @param value the value that is to be multiplied
	 */
	public void multiply (int value) {
		sum = sum * value;
		history = history + " * " + String.valueOf(value);
	}
	
	/**
	 * This method is used for division function
	 * the given value is used as a divisor.
	 * @param value the value used as a divisor
	 */
	public void divide (int value) {
		if(value != 0)
			sum = sum / (int)value;
		else
			sum = 0;
		history = history + " / " + String.valueOf(value);
	}
	
	/**
	 * This method returns the history of the calculation
	 * in a string format.
	 * @return String this string contains history of operations
	 */
	public String getHistory () {
		return history;
	}
}
