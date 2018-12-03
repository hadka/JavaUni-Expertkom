package lekce7;

public class Runner {

	public static void main(String[] args) {
		compareHuman();
	}

	public static void compareHuman() {
		Human h1 = new Human("andrea", 30);
		Human h2 = new Human("andrea", 30);
		System.out.println(h1.equals(h2));
	}

	public static void buildShapes() {
		TwoDShape twoDshape = new TwoDShape(7, 8);
		double twoDShapeArea = twoDshape.countArea();
		twoDshape.printArea(twoDShapeArea);
		
		Triangle triangle = new Triangle(7, 8, "blue");
		double triangleArea = triangle.countArea();
		triangle.printArea(triangleArea);
	}
}
