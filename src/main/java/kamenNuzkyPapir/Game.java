package kamenNuzkyPapir;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	private final List<String> answers = Arrays.asList("kamen", "nuzky", "papir");
	private Scanner scan;
	
	public void playGame() {
		while (true) {
			System.out.println("\nZadajte \"kamen\", \"nuzky\", \"papir\" alebo \"konec\": ");
			String answer = getAnswerFromThePlayer();
			String randomElement = getRandomFromComputer();
			if(answers.contains(answer)) {
				if(answersAreEqual(answer, randomElement)) {
					System.out.println("Remiza. Pocitac hral " + randomElement + ". Hrac hral "+answer);
				}else if(computerWon(answer, randomElement)) {
					System.out.println("Vyhral pocitac. Pocitac hral "+ randomElement + ". Hrac hral "+answer);
				}else {
					System.out.println("Vyhral hrac! Hrac hral "+answer+". Pocitac hral "+randomElement);
				}
			}else if(playerWishesToEndTheGame(answer)) {
				System.out.println("Hra ukoncena.");
				break;
			}else {
				System.out.println("\nZadejte spravnu odpoved: ");
			}
		}
	}

	private String getAnswerFromThePlayer() {
		scan = new Scanner(System.in);
		String answer = scan.nextLine();
		return answer;
	}
	
	private String getRandomFromComputer() {
		Random rand = new Random();
		String randomElement = answers.get(rand.nextInt(answers.size()));
		return randomElement;
	}

	private boolean playerWishesToEndTheGame(String answer) {
		return answer=="konec";
	}

	private boolean answersAreEqual(String answer, String randomElement) {
		return randomElement.equals(answer);
	}

	private boolean computerWon(String answer, String randomElement) {
		return (randomElement.equals("kamen") && answer.equals("nuzky")) || (randomElement.equals("nuzky") && answer.equals("papir")) || (randomElement.equals("papir") && answer.equals("kamen"));
	}
}
