package lekce1;

public class LIghtning {

	public static void main(String[] args) {
		double time = 5.2;
		int speed = 330;
		boolean iAmSage;
		
		double distance = time * speed;
		
		if(distance > 1000) {
			iAmSage = true;
			System.out.println("iAmSage " + iAmSage + ". You can enjoy the storm. ");
		}if(distance <= 1000) {
			iAmSage = false;
			System.out.println("iAmSage " + iAmSage + ". You'd better run.");
		}
	}
}
