package lekce2;

public class Surname {

	public static void main(String[] args) {
		
		String mySurname = "Chovanova";
		
		if(mySurname.endsWith("ova")) {
			System.out.println("You are woman.");
		}else if(mySurname.endsWith("u")) {
			System.out.println("You may be a man as well as woman.");
		}else {
			System.out.println("You are a man.");
		}
		
	}
}
