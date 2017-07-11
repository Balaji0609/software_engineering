package assign1;
import java.util.Arrays;



/**
 * Class to hold a List as array of integers. Values are appended to the
 * end of the array in ascending order. Also holds a method to print 
 * the integer array.No duplicate elements are inserted.
 * 
 * @author Balaji Chandrasekaran 211 for CSE 360 Spring 2016
 * @version Feb 07,2016
 */

public class OrderedIntList 
{
	private int[] array;  // array
	private int count; // counter
	
	/**
	* Creates an array of integer, Count is set to zero
	* The size of the array is fixed as 10.
	*
	*@param none
	*/
	
	OrderedIntList ()
	{
		array = new int[10];
		count = 0;
	}
	
	/**
 	* Creates an array of integer, Count is set to zero 
 	* 
 	* @param size length of the array
 	*/
	
	OrderedIntList (int size)
	{
		array = new int[size];
		count = 0;
	}
	
	/**
	 * insert - append the integer into the array in ascending order. No
	 * duplicate value is inserted into the array. If the list is full then 
	 * increase the size of the list by 50% and then insert into it.
	 * 
	 * @param v integer value to be inserted
	 */
	
	public void insert (int value) 
	{
		int position = 0;
		int index = 0;
		int fifty;
		int increased_size;
		
		if ((size() != 0) && (size() != 1))
		{
			fifty = (int)(size() / 2);
			increased_size = size() + fifty;
		}
		else
		{
			increased_size = 2;
		}
		
		while ((index < count) && !(value < array[index]))  
		{
			++index;
			++position;
		}
		
		if((index != 0) && (value == array[index - 1]))	
		{
			return;
		}
		
		if (count < size())	
			count++;
		else
		{
			array = Arrays.copyOf(array, increased_size);
			count++;
		}
			
		for (index = count - 1; index > position; index--) 
			array[index] = array[index - 1];

		array[position] = value;		
	}
		
	/** 
	* toString - this method prints the array of integer by converting the list
	* into a string with spaces in between the elements of the list except for the
	* last element and returns a empty string if there are no elements in list.
	* 
	* @param none
	* @return String The elements in the list in string format
	*/
	
	public String toString()
	{
		int i;
		String listString = "";
		if(length() != 0)
		{
			for(i = 0; i < count - 1; i++)
			{
				listString = listString + array[i] + " ";
			}
			listString = listString + array[i];
		}
		return listString;
	}
	
	/**
	* size - this method returns the size of the array, it is not 
	* determined by the number of elements in the array.
	*
	* @param none
	* @return int Value of size of the array
	*/
	
	public int size ()
	{
		return array.length;
	}
	
	/**
	* length - this method returns the length of the array, it is 
	* determined by the number of elements in the array.
	*
	* @param none
	* @return int Value of number of elements in the array
	*/
	
	public int length ()
	{

		return count;
	}
	
	/**
	* binary search - this method searches for a value in the  
	* array list and returns the position of the value in the 
	* array if it is found. This is recursive function
	*
	* @param key The value that is to be found out in the array
	* @param high The upper bound of the array 
	* @param low The lower bound of the array 
	* @return int Position of the key in the array if it is present in the array 
	*/
	
	private int binarysearch(int key, int high, int low)
	{
		int position = (low + high) / 2;

		if(high < low)
		{
			return -1;
		}
		
		if(array[position] == key)
		{
			return position;
		}
		
		if(array[position] < key)
		{
			return binarysearch(key, high, position + 1);
		}
		else
		{
			return binarysearch(key, position - 1, low);
		}
	}
	
	/**
	* delete - this method deletes a value from the array if the value
	* is present in the array and if the array is more than 50% empty 
	* then it decreases the size of the array by 40%
	* 
	* @param key the value which is to be deleted from the array
	*/
	
	public void delete (int key) 
	{
		int upperbound = length() - 1;
		int lowerbound = 0;
		int index;
		int modifiedsize;
		int return_value = binarysearch(key, upperbound, lowerbound);

		if(return_value != -1)
		{
			for (index = return_value; index < length() - 1; index++)
			{
				array[index] = array[index + 1];
			}
			array[index] = 0;
			count--;
		}
		
		if(size() % 2 == 0)
			modifiedsize = size();
		else
			modifiedsize = size() + 1;
		
		if(length() < (modifiedsize / 2))
		{
			int forty = (int)((size() * 4) / 10);
			int reduced_size = size() - forty;
			array = Arrays.copyOf(array, reduced_size);
		}
	}
}


