package lekce6;

public class ConstructorOvearloading {
	int x;  
	  
	ConstructorOvearloading() { 
	    x = 0; 
	} 
	 
	ConstructorOvearloading(int i) {  
	    x = i;  
	} 
	 
	ConstructorOvearloading(double d) { 
	    x = (int) d; 
	} 
	 
	ConstructorOvearloading(int i, int j) { 
	    x = i * j; 
	}
}
