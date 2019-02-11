package lekce6;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	List<String> answers = Arrays.asList("kamen", "nuzky", "papir");
	
	public void playGame() {
		while (true) {
			System.out.println("Zadajte \"kamen\", \"nuzky\", \"papir\" alebo \"konec\": ");
			String answer = getAnswerFromThePlayer();
			String randomElement = getRandomFromComputer();
			if(answersAreEqual(answer, randomElement)) {
				System.out.println("Remiza. Pocitac hral " + randomElement + ". Hrac hral "+answer);
				continue;
			}else if(computerWon(answer, randomElement)) {
				System.out.println("Vzhral pocitac. Pocitac hral"+ randomElement + ". Hrac hral "+answer);
			}else if(playerWishesToEndTheGame(answer)) {
				System.out.println("Konec.");
			}else {
				System.out.println("Vyhral hrac! Hrac hral "+answer+". Pocitac hral "+randomElement);
			}
		}
	}

	private String getAnswerFromThePlayer() {
		Scanner scan = new Scanner(System.in);
		String answer = scan.nextLine();
		return answer;
	}
	
	private String getRandomFromComputer() {
		Random rand = new Random();
		String randomElement = answers.get(rand.nextInt(answers.size()));
		return randomElement;
	}

	private boolean playerWishesToEndTheGame(String answer) {
		return answer == "konec";
	}

	private boolean answersAreEqual(String answer, String randomElement) {
		return randomElement.equals(answer);
	}

	private boolean computerWon(String answer, String randomElement) {
		return (randomElement == "kamen" && answer == "nuzky") || (randomElement == "nuzky" && answer == "papir") || (randomElement == "papir" && answer == "kamen");
	}
}
