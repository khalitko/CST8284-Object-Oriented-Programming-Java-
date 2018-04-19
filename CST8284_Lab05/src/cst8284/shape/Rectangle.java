package cst8284.shape;

public class Rectangle extends Square{


	private double height;
	
	public Rectangle(){
		this(1.0,1.0);
	}
	
	public Rectangle(double width, double height) {
		
		super(width);
		this.setHeight(height);
	}
	
	public Rectangle(Rectangle rectangle){
		this ( rectangle.getWidth(), rectangle.getHeight() );
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
	@Override
	public double getArea() {
		return ( this.getWidth() * this.getHeight() );
	}
	
	@Override
	public double getPerimeter() {
		return ( 2*(this.getWidth() + this.getHeight() ));
	}
	
	@Override
	public String toString() {
		return ("Rectangle Overrides " + super.toString());
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			return (this.getHeight() == ((Rectangle)obj).getHeight() && (super.equals(obj))) ;
		} else {
			return false;
		}
	}
}
