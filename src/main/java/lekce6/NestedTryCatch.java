package lekce6;

public class NestedTryCatch {
	
    int numer[]; 
    int denom[];
    
 
    public void devide() {
    	try {
    		for(int i=0; i<numer.length; i++) { 
    	        try { 
    	        System.out.println(numer[i] + " / " + 
    	                           denom[i] + " is " + 
    	                           numer[i]/denom[i]); 
    	        } 
    	        catch (ArithmeticException exc) { 
    	          System.out.println("Can't divide by Zero!"); 
    	        } 
    		} 
    	}catch (ArrayIndexOutOfBoundsException exc) { 
    		System.out.println("No matching element found."); 
    		System.out.println("Fatal error -- program terminated."); 
    	} 
     }
 }