package cst8284.generics;

public class SolidObject <T extends BasicShape> {
	
   // TODO: Use the UML diagram to create the members required
	private double depth;
	private T shape;
	
	protected SolidObject (T shape, double depth) {
		this.depth = depth;
		this.shape = shape;
	}
	
	protected SolidObject (T shape) {
		this.shape = shape;
		setDepth(shape.getWidth());
	}
			
	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public T getShape() {
		return shape;
	}

	public void setShape(T shape) {
		this.shape = shape;
	}

	public String toString(){
		String solidTypeEquivalent = "unknown   ";
		String className = getShape().getClass().toString();
		className = className.substring(className.lastIndexOf('.')+1);
		switch (className) {
			case "Circle": solidTypeEquivalent = "cylinder "; break;
			case "Square": solidTypeEquivalent = "cube     "; break;
			case "Rectangle": solidTypeEquivalent = "block    "; break;
			case "Triangle": solidTypeEquivalent = "prism    "; break;
		}	
		return solidTypeEquivalent;
	}
	
	public double getVolume() {
		return getShape().getArea() * getDepth();
	}

	public double getSurfaceArea() {
		
		return ( (getShape().getPerimeter() * getDepth() ) + ( 2 * getShape().getArea() ) );
				
	}
	
	@Override
	public boolean equals(Object o) {

		return (o.equals(this.getVolume()));
	}
}
