package lekce6;

import java.io.IOException;
import java.util.Scanner;

public class Input {
		
	private static Scanner scan;

	public static String getStringAnswerFromTheUser() {
		scan = new Scanner(System.in);
		String answer = scan.nextLine();
		return answer;
	}
	
	public static char getCharAnswerFromTheUser() throws IOException {
		return (char) System.in.read();	
	}
}
