package assign;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testCalculator() {
		Calculator calc = new Calculator();
		assertNotNull(calc);
	}
	
	@Test
	public void testGetTotal() {
		Calculator calc = new Calculator();
		calc.add(10);
		calc.subtract(1);
		calc.divide(9);
		calc.multiply(12);
		assertEquals(12, calc.getTotal());
	}
	
	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		calc.add(25);
		assertEquals(25, calc.getTotal());
	}
	
	@Test
	public void testSubtract() {
		Calculator calc = new Calculator();
		calc.add(25);
		calc.subtract(15);
		assertEquals(10, calc.getTotal());
	}
	
	@Test
	public void testMultiply() {
		Calculator calc = new Calculator();
		calc.add(10);
		calc.multiply(2);
		assertEquals(20, calc.getTotal());
	}
	
	@Test
	public void testDivide() {
		Calculator calc = new Calculator();
		calc.add(10);
		calc.divide(2);
		assertEquals(5, calc.getTotal());
	}
	
	@Test
	public void testDivideByZero(){
		Calculator calc = new Calculator();
		calc.add(10);
		calc.divide(0);
		assertEquals(0, calc.getTotal());
	}
	
	@Test
	public void testGetHistory() {
		Calculator calc = new Calculator();
		calc.add(10);
		calc.subtract(5);
		assertEquals("0 + 10 - 5", calc.getHistory());
	}
	
	@Test
	public void testGetHistory1() {
		Calculator calc = new Calculator();
		calc.add(10);
		calc.subtract(5);
		calc.multiply(4);
		calc.divide(5);
		assertEquals("0 + 10 - 5 * 4 / 5", calc.getHistory());
		assertEquals(4, calc.getTotal());
	}

}
