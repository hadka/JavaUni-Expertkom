package lekce6;

public class BadOverload {
//	void doSomething(int x) { 
//	    System.out.println("Inside f(int): " + x); 
//	  } 
	 
	  int doSomething(int x) { 
	    System.out.println("Inside f(double): " + x);
	    return x;
	  }
}
