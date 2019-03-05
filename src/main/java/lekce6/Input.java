package lekce6;

import java.io.IOException;
import java.util.Scanner;

public class Input {
	
	private Scanner scan;
	
	public String getStringAnswerFromTheUser() {
		scan = new Scanner(System.in);
		String answer = scan.nextLine();
		return answer;
	}
	
	public char getCharAnswerFromTheUser() throws IOException {
		return (char) System.in.read();	
	}
}
