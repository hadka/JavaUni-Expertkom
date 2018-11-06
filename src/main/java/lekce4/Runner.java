package lekce4;

public class Runner {

	public static void main(String[] args) {
		Reference demonstration = new Reference();
		demonstration.demonstrateObjectReference();
		
		int array1[] = {1, 2, 3, 4, 5};
		int array2[] = {1, 2, 3};
		
		LengthChecker checker = new LengthChecker(array1, array2);
		checker.compareArraysLength();
		
		LengthChecker2 checker2 = new LengthChecker2(array1, array2);
		checker2.getSumOfLongerArrayItems();
		
		int sum = checker2.addAllArrayNumbers(array1);
		System.out.println("Suma arrayu je "+sum);
	}
}
