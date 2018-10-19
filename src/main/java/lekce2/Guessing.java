package lekce2;

import java.io.IOException;

public class Guessing {

	public static void main(String[] args) throws IOException {
		
		char answer = 'k';
		
		while (true) {
			System.out.println("Insert char: ");
			char guess = (char) System.in.read();
			if(guess == answer) {
				System.out.println("Right guess, GREAT!");
				break;
			}else {
				System.out.println("Not the right answer!");
				continue;
			}
		}
	}
}
