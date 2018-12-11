package lekce1;

public class LIghtning {

	public static void main(String[] args) {
		double time = 5.2;
		int speed = 330;
		boolean iAmSafe;
		
		double distance = time * speed;
		
		if(distance > 1000) {
			iAmSafe = true;
			System.out.println("iAmSage " + iAmSafe + ". You can enjoy the storm. ");
		}if(distance <= 1000) {
			iAmSafe = false;
			System.out.println("iAmSage " + iAmSafe + ". You'd better run.");
		}
	}
}
