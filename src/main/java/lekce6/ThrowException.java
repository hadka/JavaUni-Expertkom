package lekce6;

public class ThrowException {
	
	public void throwException() {
		try { 
		      System.out.println("Before throw."); 
		      throw new ArithmeticException(); 
		      
		}catch (ArithmeticException exc) { 
		      System.out.println("Exception caught."); 
		} 
		
		System.out.println("After try/catch block."); 
	}
}

