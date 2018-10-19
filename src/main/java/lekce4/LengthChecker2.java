package lekce4;

public class LengthChecker2 {
	
	int[] array1;
	int[] array2;
	
	LengthChecker2(int[] array1, int[] array2) {
		super();
		this.array1 = array1;
		this.array2 = array2;
	}
	
	void getSumOfLongerArrayItems() {
		int[] longerArray = firstGivenArrayIsLonger();
		int sum = addAllArrayNumbers(longerArray);
		printSumOfLongerArrayItems(sum);
	}
		
	int[] firstGivenArrayIsLonger() {
		int[] longerArray;
		if(this.array1.length > this.array2.length) {
			longerArray = this.array1;
		}else {
			longerArray = this.array2;
		}
		return longerArray;
	}
	
	int addAllArrayNumbers(int[] array) {
		int sum = 0;
		for(int i : array) {
			sum += i;
		}
		return sum;
	}
	
	void printSumOfLongerArrayItems(int sum) {
		System.out.println("The sum of longerArray Items is: "+sum);
	}
}
