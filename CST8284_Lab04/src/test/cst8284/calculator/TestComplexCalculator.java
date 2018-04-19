package test.cst8284.calculator;
import cst8284.calculator.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestComplexCalculator {
	
	
	// 5. Using assertTrue(boolean), test that two Complex numbers created using the Complex(double, double) constructor 
	// and the Complex(String) constructor give the correct result using the subtract() method.  
	// Use equals(Complex) to compare the actual and expected result (1 mark)
	
	@Test
	public void testSubtract() {

		Complex c1 = new Complex(2.0,3.0);
		Complex c2 = new Complex("4+6i");

		ComplexCalculator cal = new ComplexCalculator();
		Complex c = new Complex(-2.0, -3.0);
		assertTrue(c.equals(cal.subtract(c1, c2)));
		
	}
	
	// 6. Using one or more for() loops over a range of values, check that (A + Bi)*(A - Bi) is a pure real number, 
	// i.e. that imag = 0 for each possible compbination (3 marks)
	
    @Test
    public void testMultiply() {
    	ComplexCalculator multi = new ComplexCalculator();
        Complex c = new Complex();
        int A = 1;
        int B;
        for (B = 1; B < 10; B++) {
            Complex c1 = new Complex(A, B);
            Complex c2 = new Complex(A, -B);
            c = multi.multiply(c1, c2);
            assertEquals(0, c.getImag(), 0.00001);
            
        }	
            
    }
	

	
	
}
