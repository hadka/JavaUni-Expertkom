package lekce6;

import java.util.Scanner;

public class Input {
	
	private Scanner scan;
	
	public String getAnswerFromThePlayer() {
		scan = new Scanner(System.in);
		String answer = scan.nextLine();
		return answer;
	}
}
