package lekce6;

public class ExceptionDemo {
	
    int nums[]; 

    public ExceptionDemo(int[] nums) {
		super();
		this.nums = nums;
	}

	public void setOutOfBoundIndex(int indexGivenByUser, int wishedNumberToBeSet) {
		try { 
		      nums[indexGivenByUser] = wishedNumberToBeSet; 
		    } 
		    catch (ArrayIndexOutOfBoundsException exc) {
		    	int maxSize = nums.length;
			    nums[maxSize - 1] = wishedNumberToBeSet;
		    	System.out.println("Index out-of-bounds! Max position is "+maxSize+". Setting max position to "+wishedNumberToBeSet+". "); 
		    	System.out.println("Position "+maxSize+" has value "+nums[maxSize - 1]);
		    	
		    	String localisedMessage = exc.getLocalizedMessage();
		    	System.out.println("\ngetLocalisedMessage(): "+localisedMessage);
		    	
		    	System.out.println("\ngetMessage(): "+ exc.getMessage());
		    	
		    	System.out.println("\nprintStackTrace(): ");
		    	exc.printStackTrace();
		    	
		    	System.out.println("\ntoString(): "+exc.toString());
		    		    	
		    } 
    }    
}
