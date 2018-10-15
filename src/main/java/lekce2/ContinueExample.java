package lekce2;

public class ContinueExample {

	public static void main(String[] args) {
		
		for(int count = 0; count <= 500; count ++) {
			if(count % 2 != 0) {
				continue;
			}
			System.out.println(count);
		}
	}
	
}
