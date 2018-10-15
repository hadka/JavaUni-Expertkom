package lekce2;

import java.io.IOException;

public class KeyboardEntry {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Press key and then enter: ");
		char keyboardEntry = (char) System.in.read();
		System.out.println("You have entered "+keyboardEntry);
	}

}
