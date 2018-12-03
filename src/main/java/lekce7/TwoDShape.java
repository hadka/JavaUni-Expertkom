package lekce7;

public class TwoDShape {
	private double width; 
	private double height; 
	 
	public TwoDShape(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	public double countArea() {
		return getWidth() * getHeight();
	}
	
	public void printArea(double area) {
		System.out.println("The area of TwoDShape is "+area);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	void showDim() { 
	  System.out.println("Width and height are " + width + " and " + height); 
	} 
}
