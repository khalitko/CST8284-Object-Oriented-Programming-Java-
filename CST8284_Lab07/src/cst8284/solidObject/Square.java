package cst8284.solidObject;

import cst8284.solidObject.BasicShape;

public class Square extends BasicShape {

	public Square(){
		this(1.0);
	}
	
	public Square(double width) {
		this.setWidth(width);
	}
	
	public Square(Square square) {
		this(square.getWidth());
	}
	
	
	@Override
	public double getArea() {
		return ( this.getWidth() * this.getWidth() );
	}

	@Override
	public double getPerimeter() {
		return ( 2 * (this.getWidth() + this.getWidth()) );
	}

	@Override
	public String toString() {
		return ( "Square Overrides " + super.toString() );
	}

	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Square) {
			return (this.getWidth() == ((Square)obj).getWidth());
		} else {
			return false;
		}
	}
}
