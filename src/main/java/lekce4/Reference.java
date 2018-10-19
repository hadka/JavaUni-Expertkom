package lekce4;

public class Reference {
	
	public void demonstrateObjectReference(){
		
	    int nums1[] = setValuesForArray(); 
	    int nums2[] = setValuesForArray();
	    
	    System.out.print("Here is nums1: ");
		printValuesOfAnArray(nums1);
		
		System.out.print("Here is nums2: ");
		printValuesOfAnArray(nums2);
	 
	    nums2 = nums1;
	 
	    System.out.print("Here is nums2 after assignment: "); 	    
	    printValuesOfAnArray(nums2);
	 
	    nums2[3] = 99; 
	 
	    System.out.print("Here is nums1 after change through nums2: "); 
	    printValuesOfAnArray(nums1);
	}

	public int[] setValuesForArray() {
		int nums[] = new int[10];
		int i;
		for(i=0; i < 10; i++) 
	      nums[i] = i;
		return nums;
	}
	
	public void printValuesOfAnArray(int[] nums) {
		int i;
	    for(i=0; i < 10; i++) {
	    	System.out.print(nums[i] + " ");   
	    }
	    System.out.println();
	}
}
