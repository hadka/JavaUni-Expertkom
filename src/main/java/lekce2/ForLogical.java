package lekce2;

import java.io.IOException;

public class ForLogical {

	public static void main(String[] args) throws IOException {
	 
	    System.out.println("Press S to stop."); 
	 
	    for(int i = 0; (char) System.in.read() != 'S'; i++) {
	    	System.out.println("Pass #" + i);
	    }
	    System.out.println("End.");
	 }   
}
