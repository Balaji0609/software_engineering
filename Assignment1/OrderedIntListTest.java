package assign1;

import static org.junit.Assert.*;

import org.junit.Test;


public class OrderedIntListTest {
		
	/** Test cases from assignment 1 for initial testing*/
	
	@Test
	public void emptyList() {							/** test case for empty list */
		OrderedIntList oList = new OrderedIntList();
		
		assertEquals("", oList.toString());
	}

	@Test
	public void singleInt() {							/** test case for inserting single int element*/
		OrderedIntList oList = new OrderedIntList();
		oList.insert(3);
		
		assertEquals("3", oList.toString());
	}
	
	@Test
	public void inOrder() { 							/** inserting elements in order with overflow*/
		OrderedIntList oList = new OrderedIntList();
		int startValue = 4;

		    oList.insert(startValue + 0);
			oList.insert(startValue + 1);
			oList.insert(startValue + 2);
			oList.insert(startValue + 3);
			oList.insert(startValue + 4);
			oList.insert(startValue + 5);
			oList.insert(startValue + 6);
			oList.insert(startValue + 7);
			oList.insert(startValue + 8);
			oList.insert(startValue + 9);
			oList.insert(startValue + 10);
			oList.insert(startValue + 11);
		
		assertEquals("4 5 6 7 8 9 10 11 12 13 14 15", oList.toString());
	}
	
	@Test
	public void reverseOrder() {						/** inserting elements in reverse order with overflow*/
		OrderedIntList oList = new OrderedIntList();
		int startValue = 4;
		
			oList.insert(startValue - 0);
			oList.insert(startValue - 1);
			oList.insert(startValue - 2);
			oList.insert(startValue - 3);
			oList.insert(startValue - 4);
			oList.insert(startValue - 5);
			oList.insert(startValue - 6);
			oList.insert(startValue - 7);
			oList.insert(startValue - 8);
			oList.insert(startValue - 9);
			oList.insert(startValue - 10);
		
		assertEquals("-6 -5 -4 -3 -2 -1 0 1 2 3 4", oList.toString());
	}
	
	@Test
	public void unique() {								/** inserting duplicate elements */
		OrderedIntList oList = new OrderedIntList();
		
			oList.insert(55);
			oList.insert(55);
			oList.insert(55);
		
		assertEquals("55", oList.toString());
	}
	
	@Test
	public void outOfOrder() {						/** inserting elements in random order */
		OrderedIntList list = new OrderedIntList();
		
		list.insert(5);
		list.insert(7);
		list.insert(4);
		list.insert(1);
		list.insert(8);				
		list.insert(9);
		list.insert(2);
		list.insert(10);
		list.insert(6);
		list.insert(3);
		
		assertEquals("1 2 3 4 5 6 7 8 9 10", list.toString());
	}
	
	@Test
	public void threeInserts() { 					/** insert only three elements in list */
		OrderedIntList list = new OrderedIntList();
		
		list.insert(4);
		list.insert(9);
		list.insert(1);
		
		assertEquals("1 4 9", list.toString());
	}
	
	@Test
	public void sevenInserts() {					/** inserting seven elements in list in random order*/
		OrderedIntList list = new OrderedIntList();
		
		list.insert(10);
		list.insert(80);				
		list.insert(90);
		list.insert(20);
		list.insert(100);
		list.insert(60);
		list.insert(30);
		
		assertEquals("10 20 30 60 80 90 100", list.toString());
	}
	
	/** Test Cases - further testing operations and their boundary conditions*/
	
	@Test
	public void Insetin_0or1()			/** inserting into list with size 0 or 1 and checking even the size and length*/
	{
		OrderedIntList list = new OrderedIntList(1);
		OrderedIntList list1 = new OrderedIntList(0);
		list.insert(10);
		list.insert(20);
		list1.insert(30);
		assertEquals(2, list.size());
		assertEquals(2, list.length());
		assertEquals(2, list1.size());
		assertEquals(1, list1.length());
		assertEquals("10 20", list.toString());
		assertEquals("30", list1.toString());
	}
	
	@Test
	public void deletein_0or1() 				/** inserting and then deleting from 0 or 1 */
	{
		OrderedIntList list = new OrderedIntList(1);
		OrderedIntList list1 = new OrderedIntList(0);
		list.insert(10);
		list.insert(20);
		list1.insert(30);
		list.delete(10);
		list1.delete(30);
		assertEquals(2, list.size());            /** checking for size and length as well */
		assertEquals(1, list.length());
		assertEquals(2, list1.size());
		assertEquals(0, list1.length());
		assertEquals("20", list.toString());
		assertEquals("", list1.toString());
	}
	
	@Test
	public void insertoverflow()					/** insert overflow in order */
	{
		OrderedIntList list = new OrderedIntList(6);
		list.insert(10);
		list.insert(11);
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
		list.insert(16);
		list.insert(17);
		assertEquals(9, list.size());				/** checking for size and length as well */
		assertEquals(8, list.length());
		assertEquals("10 11 12 13 14 15 16 17", list.toString());
	}
	
	@Test
	public void deleteunderflow_even()				/** delete underflow 40% reduction */
	{
		OrderedIntList list = new OrderedIntList(6);
		list.insert(10);
		list.insert(11);
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
		list.insert(16);
		list.insert(17);
		assertEquals(9, list.size());			/** checking for size and length before delete */
		assertEquals(8, list.length());
		assertEquals("10 11 12 13 14 15 16 17", list.toString());
		list.delete(17);
		list.delete(16);
		list.delete(15);
		list.delete(14);
		assertEquals(6, list.size());			/** checking for size and length after delete */
		assertEquals(4, list.length());
		assertEquals("10 11 12 13", list.toString());
	}
	
	@Test
	public void insert_completely() /** insert max boundary check */
	{
		OrderedIntList list = new OrderedIntList(3);
		list.insert(10);
		list.insert(29);
		list.insert(30);
		assertEquals(3, list.size());
		assertEquals(3, list.length());
		assertEquals("10 29 30", list.toString());
	}
	
	@Test
	public void insertoverflow_odd_size() /** insert overflow when size of array is odd */
	{
		OrderedIntList list = new OrderedIntList(3);
		list.insert(10);
		list.insert(29);
		list.insert(30);
		list.insert(33);
		assertEquals(4, list.size());
		assertEquals(4, list.length());
		assertEquals("10 29 30 33", list.toString());
	}
	
	@Test
	public void insertoverflow_even_size() /** insert overflow in case of even size of array*/
	{
		OrderedIntList list = new OrderedIntList(4);
		list.insert(10);
		list.insert(29);
		list.insert(30);
		list.insert(33);
		list.insert(44);
		assertEquals(6, list.size());
		assertEquals(5, list.length());
		assertEquals("10 29 30 33 44", list.toString());
	}
	
	@Test
	public void deleteunderflow_odd()		/** checking for delete underflow for odd size length of list */
	{
		OrderedIntList list = new OrderedIntList(7);
		list.insert(10);
		list.insert(11);
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
		list.insert(16);
		list.insert(17);
		assertEquals(10, list.size());    /** checking for size and length as well */
		assertEquals(8, list.length());
		assertEquals("10 11 12 13 14 15 16 17", list.toString());
		list.delete(17);
		list.delete(16);
		list.delete(15);
		list.delete(14);
		assertEquals(6, list.size());
		assertEquals(4, list.length());
		assertEquals("10 11 12 13", list.toString());
	}
	
	@Test
	public void delete_notin_array() 					/** checking the binary search deleting a value not in list */
	{
		OrderedIntList list = new OrderedIntList(3);
		list.insert(10);
		list.insert(29);
		list.delete(11);
		list.insert(30);
		assertEquals(3, list.size());
		assertEquals(3, list.length());
		assertEquals("10 29 30", list.toString());
	}
	
	@Test
	public void zerovalue()  /** test case for inserting value 0 */
	{
		OrderedIntList list = new OrderedIntList(0);
		list.insert(0);
		assertEquals(2, list.size());
		assertEquals(1, list.length());
		assertEquals("0", list.toString());
	}
	
	@Test
	public void random()        /** checking for random operation */
	{
		OrderedIntList list = new OrderedIntList(0);
		list.insert(1);
		list.delete(1);
		assertEquals(2, list.size());
		assertEquals(0, list.length());
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.insert(10);
		list.insert(11);
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
		list.insert(16);
		list.insert(17);
		list.insert(18);
		list.insert(13);  	/** duplicate insertion */
		list.insert(19);
		list.insert(20);
		list.insert(21);
		list.insert(22);
		list.insert(24);
		list.delete(24);
		list.delete(22);
		list.delete(21);
		list.delete(20);
		list.delete(19);
		list.delete(13);
		list.delete(18);
		list.delete(17);
		list.delete(16);
		list.delete(15);
		list.delete(14);
		list.delete(13);			/** search fail */
		list.delete(12);
		list.delete(11);
		assertEquals(11, list.size());
		assertEquals(8, list.length());
		assertEquals("3 4 5 6 7 8 9 10", list.toString());
	}	
}
