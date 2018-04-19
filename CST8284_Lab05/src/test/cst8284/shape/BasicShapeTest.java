package test.cst8284.shape;

import static org.junit.Assert.*;
import cst8284.shape.*;
import org.junit.Test;

public class BasicShapeTest {

	@Test
	public void testInstaceOfSquareEqualsRectangle() {
        Rectangle c = new Rectangle();
        assertTrue(c instanceof Square);
	}

	@Test
    public void testObjectSquareNotEqualCircle() {
        assertFalse(new Circle().equals(new Square()));
    }
	
	@Test
	public void testEqualsObjectCircleToCircle() {
		//assertTrue(new Circle().equals(new Circle(new Circle())));
	
		Circle a = new Circle(3);
		assertTrue(a.equals(new Circle(a)));
 
	}	
}

