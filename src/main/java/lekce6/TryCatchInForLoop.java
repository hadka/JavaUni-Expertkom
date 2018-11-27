package lekce6;

public class TryCatchInForLoop {
    int numer[]; 
    int denom[]; 
 
    public TryCatchInForLoop(int[] numer, int[] denom) {
		super();
		this.numer = numer;
		this.denom = denom;
	}
    
	public void devide() {
    	for(int i=0; i<this.numer.length; i++) { 
    		try { 
    			System.out.println(this.numer[i] + " / " + 
                       this.denom[i] + " is " + 
                       this.numer[i]/this.denom[i]); 
    		}catch (ArithmeticException exc) { 
    			System.out.println("Can't divide by Zero!"); 
    		}catch (ArrayIndexOutOfBoundsException exc) { 
    	        System.out.println("No matching element found."); 
    	    }
    	} 
    }
}
