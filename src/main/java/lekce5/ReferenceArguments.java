package lekce5;

public class ReferenceArguments {
	
	int a, b; 
	 
	ReferenceArguments(int i, int j) { 
	    a = i; 
	    b = j; 
	  }
	  
	  void change(ReferenceArguments ob) { 
	    ob.a = ob.a + ob.b; 
	    ob.b = -ob.b; 
	  } 
}
