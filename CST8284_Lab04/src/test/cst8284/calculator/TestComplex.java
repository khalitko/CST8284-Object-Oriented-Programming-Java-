package test.cst8284.calculator;
import cst8284.calculator.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestComplex {

	double delta = 0.0000001;
	// 1. Use assertNotNull() to test the Complex(String) constructor (1 mark)
	
	@Test
	public void testComplexString() {
		Complex c = new Complex("2+3i");
		assertNotNull(c);
		
	}
	
	// 2. Use assertEquals(double, double, double) to test if getReal() returns 
	// the correct value set using the Complex(String[]) constructor (1 mark)
	@Test
	public void testgetReal() {  
		String[] cStr = new String[2];
		cStr[0] ="2";
		cStr[1] = "+3i";
		Complex c = new Complex(cStr);
		assertEquals(2.0, c.getReal(), delta);  
		
    }
	
	// 3. Use assertEquals(double, double, double) to test if setReal() correctly resets 
	// the value set using the Complex(String, String) constructor (1 mark)
	
	@Test
	public void testsetReal() {  
		Complex c = new Complex("1","+3i");
		c.setReal(2.0);
		assertEquals(2.0, c.getReal(), delta); 
		
    }
	
	// 4. Use the no-arg Complex() constructor, and then use the real and imaginary setters to set new integer values.  
	// Then use assertTrue(boolean) to test the validity of your newly-added equals(Complex) method (1 mark)
	
	
	@Test
	public void testEqualsComplex(){
		Complex c = new Complex();
		c.setReal(2.0);
		c.setImag(3.0);
		assertTrue(c.equals(c));
		
	}
	

    

}
