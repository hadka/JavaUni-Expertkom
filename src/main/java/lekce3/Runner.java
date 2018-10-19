package lekce3;

public class Runner {

	public static void main(String[] args) {
		
		Product banan = new Product(55, "Banan", 45, "g", 5.1f);
		Product banan2 = new Product(55, "Banan2", 25, "g", 5.29f);
		Product banan3 = new Product(55, "Banan3", 35, "g", 5.3f);
						
		int amountOfBananas = 5;		
		float totalPrice = banan.countTotalPrice(amountOfBananas);
		banan.printInfoAboutTotalPRice(totalPrice);
		
		int amountOfBananas2 = 3;
		float totalPrice2 = banan2.countTotalPrice(amountOfBananas2);
		banan2.printInfoAboutTotalPRice(totalPrice2);
		
		int amountOfBananas3 = 15;
		float totalPrice3 = banan3.countTotalPrice(amountOfBananas3);
		banan3.printInfoAboutTotalPRice(totalPrice3);		
	}
}
