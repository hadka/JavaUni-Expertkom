package lekce5;

public class ArrayOrganiser {
	
	public Integer[] sortArrayDescending(Integer[] numbers){
		
		boolean flag = true;
		
		while(flag) {
			flag = false;
			for(int i=0; i<numbers.length-1; i++) {
				if(numbers[i] < numbers[i+1]) {
					int temp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = temp;
					flag = true;
				}
			}
		}		
		return numbers;
	}
	
	public Integer[] sortArrayAscending(Integer[] numbers){
		
		boolean flag = true;
		
		while(flag) {
			flag = false;
			for(int i=0; i<numbers.length-1; i++) {
				if(numbers[i] > numbers[i+1]) {
					int temp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = temp;
					flag = true;
				}
			}
		}		
		return numbers;
	}
	
	public void printArray(Integer[] numbers) {
		for(Integer i : numbers) {
			System.out.println(i);
		}
	}
}
