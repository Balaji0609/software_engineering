package assign1;
import static org.junit.Assert.*;

import org.junit.Test;

import assign1.OrderedIntList;


public class OrderedIntListTest2 {
	
	@Test
	public void singleInt() {
		OrderedIntList list = new OrderedIntList();
		list.insert(3);
		
		assertEquals("3", list.toString());
	}
	
	@Test
	public void inOrder() {
		OrderedIntList list = new OrderedIntList();
		int startValue = 4;
		
		for (int value = 0; value < 12; value++)
		{
			list.insert(startValue + value);
		}
		
		assertEquals("4 5 6 7 8 9 10 11 12 13 14 15", list.toString());
	}
	
	@Test
	public void reverseOrder() {
		OrderedIntList list = new OrderedIntList();
		int startValue = 4;
		
		for (int value = 0; value < 11; value++)
		{
			list.insert(startValue - value);
		}		
		
		assertEquals("-6 -5 -4 -3 -2 -1 0 1 2 3 4", list.toString());
	}
	
	@Test
	public void unique() {
		OrderedIntList list = new OrderedIntList();
		
		for (int value = 0; value < 3; value++)
		{
			list.insert(55);
		}
				
		assertEquals("55", list.toString());
	}
	
	@Test
	public void outOfOrder() {
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
	public void defaultConstructor()
	{
		OrderedIntList list = new OrderedIntList();
		assertEquals(0,list.length());
		assertEquals(10,list.size());
	}
	
	@Test
	public void overloadConstructor()
	{
		OrderedIntList list = new OrderedIntList(100);
		assertEquals(0,list.length());
		assertEquals(100,list.size());
	}
	
	@Test
	public void size() {
		OrderedIntList list = new OrderedIntList();
		assertEquals(10,list.size());
	}
	
	@Test
	public void length() {
		OrderedIntList list = new OrderedIntList();
		list.insert(3);
		list.insert(2);
		assertEquals(2, list.length());
	}
	
	@Test 
	public void insertZero()
	{
		OrderedIntList list = new OrderedIntList();
		
		list.insert(0);	
		
		assertEquals("0", list.toString());
		assertEquals(1, list.length());
	}
	
	@Test 
	public void insertNegative()
	{
		OrderedIntList list = new OrderedIntList();
		
		list.insert(-1);	
		
		assertEquals("-1", list.toString());
		assertEquals(1, list.length());
	}
	
	@Test //insert size increases 50% when full
	public void increaseSize()
	{
		int initalSize = 5;
		int finalSize = 8;
		//final size is the ceiling of (intialsize * 1.5)
		//Must be the ceiling because if the size is one and and full the
		//size will never increase
		
		OrderedIntList list = new OrderedIntList(initalSize);
		
		for (int i = 1; i <= initalSize; i++) {
			list.insert(i);	
		}
		
		assertEquals(finalSize , list.size());
	}
	
	@Test
	public void decreaseSize() {
				
		OrderedIntList list = new OrderedIntList();
		
		for (int i = 1; i <= 5; i++) {
			list.insert(i);	
		}
		
		list.delete(3);
		
		assertEquals(4, list.length());
		assertEquals(6, list.size());
		assertEquals("1 2 4 5", list.toString());
	}
	
	@Test
	public void deleteOne() {
				
		OrderedIntList list = new OrderedIntList();
		
		list.insert(20);	
				
		list.delete(20);
		
		assertEquals(0, list.length());
		assertEquals(6, list.size());
		assertEquals("", list.toString());
	}
	
	@Test
	public void deleteMiddle() {
				
		OrderedIntList list = new OrderedIntList();
		
		for (int i = 1; i <= 3; i++) {
			list.insert(i);	
		}
		
		list.delete(2);
		
		assertEquals(2, list.length());
		assertEquals("1 3", list.toString());
	}

	@Test
	public void deleteFirst() {
				
		OrderedIntList list = new OrderedIntList();
		
		for (int i = 1; i <= 3; i++) {
			list.insert(i);	
		}
		
		list.delete(1);
		
		assertEquals(2, list.length());
		assertEquals("2 3", list.toString());
	}

	@Test
	public void deleteLast() {
				
		OrderedIntList list = new OrderedIntList();
		
		for (int i = 1; i <= 3; i++) {
			list.insert(i);	
		}
		
		list.delete(3);
		
		assertEquals(2, list.length());
		assertEquals("1 2", list.toString());
	}
	
	@Test
	public void deleteNotFound() {
				
		OrderedIntList list = new OrderedIntList();
		
		for (int i = 2; i < 10; i = i + 2) {
			list.insert(i);	
		}
		int lengthBefore = list.length();
		
		list.delete(5);
		
		assertEquals(lengthBefore, list.length());
		assertEquals("2 4 6 8", list.toString());
	}

	@Test
	public void deleteEmpty() {
				
		OrderedIntList list = new OrderedIntList();
		
		list.delete(5);
		
		assertEquals(0, list.length());
		assertEquals(6, list.size());
		assertEquals("", list.toString());
	}
	
	@Test
	public void deleteSizeOne() {
				
		OrderedIntList list = new OrderedIntList(1);
		
		list.delete(5);
		
		assertEquals(0, list.length());
		assertEquals(1, list.size());
		assertEquals("", list.toString());
	}
	
	@Test
	public void checkToString(){
		OrderedIntList list = new OrderedIntList();
		list.insert(2);
		list.insert(3);
		list.insert(1);
		list.insert(4);
		list.insert(5);
		assertEquals("1 2 3 4 5", list.toString());
	}
	
	@Test
	public void emptyToString(){
		OrderedIntList list = new OrderedIntList();
		assertEquals("",list.toString());
	}
}