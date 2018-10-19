package lekce4;

public class LengthChecker {
	
	int[] array1;
	int[] array2;
	
	LengthChecker(int[] array1, int[] array2) {
		super();
		this.array1 = array1;
		this.array2 = array2;
	}
	
	void compareArraysLength() {
		if(firstGivenArrayIsLonger()) {
			System.out.println("First Array is longer.");
		}else {
			System.out.println("Second array is longer");
		}
	}

	boolean firstGivenArrayIsLonger() {
		if(this.array1.length > this.array2.length) {
			return true;
		}else {
			return false;
		}
	}
	
	int addAllArrayNumbers(int[] array) {
		int sum = 0;
		for(int i : array) {
			sum += i;
		}
		return sum;
	}
}
