package cst8284.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Integer;

import cst8284.generics.BasicShape;
import cst8284.generics.Circle;
import cst8284.generics.Rectangle;
import cst8284.generics.SolidObject;
import cst8284.generics.Square;

public class GenericTableDemo {

	public static void main(String[] args) {
	
		
		ArrayList<Integer> integers = new ArrayList<Integer>(Arrays.asList(1,2,2,1));
		ArrayList<String> strings = new ArrayList<>();
		ArrayList<BasicShape> shapes = new ArrayList<>();
		ArrayList<SolidObject<BasicShape>> solids = new ArrayList<>();

		// instantiate strings and add to strings ArrayList		
		strings.add("myString");
		strings.add(new String ("myString"));
		strings.add("myString");
		
		// instantiate 2D objects and add to shapes ArrayList
		
//	     *        Circle(3.0)               5.0
//	     *        Rectangle(10.0, 9.0)      2.0
//	     *        Rectangle(3.0, 6.0)       10.0
//	     *        Square(6.0)    
	     
	     
		Circle circle1 = new Circle(3.0);
		Square square1 = new Square(6.0);
		Rectangle rectangle1 = new Rectangle(10.0, 9.0);
		Rectangle rectangle2 = new Rectangle(3.0, 6.0);
		shapes.add(circle1);
		shapes.add(square1);
		shapes.add(rectangle1);
		shapes.add(rectangle2);

		// instantiate and add 3D objects to solids ArrayList 
		solids.add(new SolidObject<BasicShape>(circle1, 5.0));
		solids.add(new SolidObject<BasicShape>(square1, 6.0));
		solids.add(new SolidObject<BasicShape>(rectangle1, 2.0));
		solids.add(new SolidObject<BasicShape>(rectangle2, 10.0));
		
		// Compare the contents of each ArrayList
		Table.displayEqualityTable(integers);
		Table.displayEqualityTable(strings);
		Table.displayEqualityTable(shapes);
		Table.displayEqualityTable(solids);

	}
}
