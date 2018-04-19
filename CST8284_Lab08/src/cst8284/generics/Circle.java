package cst8284.generics;


public class Circle extends BasicShape {

	public Circle(){
		this(1.0);
	}
	
	public Circle(double width) {
		this.setWidth(width);
	}
	
	public Circle(Circle circle) {
		this(circle.getWidth());
	}
	
	
	@Override
	public double getArea() {
		return ( this.getWidth() / 2 ) * ( this.getWidth() / 2 ) * Math.PI;
	}

	@Override
	public double getPerimeter() {
		return this.getWidth() * Math.PI;
	}

	@Override
	public String toString() {
		return ("Circle Overrides " + super.toString());
	}

	
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof Circle) {
//			return (this.getWidth() == ((Circle)obj).getWidth());
//		} else {
//			return false;
//		}
//	}
}
