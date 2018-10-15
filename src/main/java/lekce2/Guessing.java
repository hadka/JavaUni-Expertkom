package lekce2;

import java.io.IOException;

public class Guessing {

	public static void main(String[] args) throws IOException {
		
		char answer = 'k';
		char guess = (char) System.in.read();
		
		String myFirstString = "this is my first string";
		if(myFirstString.endsWith("ing")) {
			System.out.println("ok");
		}
		
		int StringLenght = myFirstString.length();
		
		System.out.println(myFirstString);
		if (guess == answer) {
			System.out.println("GREAT!");
		}else {
			System.out.println("Sorry, not a right guess!");
		}
	}
}
