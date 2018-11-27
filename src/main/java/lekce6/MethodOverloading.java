package lekce6;

public class MethodOverloading {
	
	void ovlDemo() {  
	    System.out.println("No parameters");  
	}  
	  
	void ovlDemo(int a) {  
	  System.out.println("One parameter: " + a);  
	}  
	  
	int ovlDemo(int a, int b) {  
	  System.out.println("Two parameters: " + a + " " + b);  
	  return a + b; 
	}  
	  
	double ovlDemo(double a, double b) { 
	  System.out.println("Two double parameters: " + a + " "+ b);  
	  return a + b;  
	} 
}
