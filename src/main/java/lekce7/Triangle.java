package lekce7;

public class Triangle extends TwoDShape{
	String style; 
	   
	public Triangle(double width, double height, String style) {
		super(width, height);
		this.style = style;
	}

	public double countArea() { 
	  return getWidth() * getHeight() / 2; 
	} 
	
	public void printArea(double area) {
		System.out.println("The area of triangle is "+area);
	}
	 
	void showStyle() { 
	  System.out.println("Triangle is " + style); 
	} 
}
