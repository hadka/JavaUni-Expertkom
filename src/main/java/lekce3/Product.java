package lekce3;

public class Product {
	
	int id;
	String name;
	int volume;
	String volumeUnit;
	float price;
	
	Product(){
		id = 10;
	}

	Product(int id, String name, int volume, String volumeUnit, float price) {
		super();
		this.id = id;
		this.name = name;
		this.volume = volume;
		this.volumeUnit = volumeUnit;
		this.price = price;
	}
	
	String getInfoAboutProduct() {
		return "Moj vyrobok je "+name+". Ma id"+id+
		". Jeho vaha je "+volume+volumeUnit+".";
	}
	
	int getProductId() {
		return this.id;
	}
	
	float countTotalPrice(int amount) {
		return amount * this.price;
	}
	
	void applyAmountDiscount(int amount) {
		if(amount > 4) {
			amount = 3;
		}
	}
	
	void printInfoAboutTotalPRice(float totalPrice) {
		System.out.println("The total price of "+this.name+" is "+totalPrice);
	}
}
