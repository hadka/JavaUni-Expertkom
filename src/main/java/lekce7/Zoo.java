package lekce7;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

	public static void main(String[] args) {
		
		List<Animal> animals = new ArrayList<>();
		
		Animal dog = new Dog();
		animals.add(dog);
		
		Animal cat = new Cat();
		animals.add(cat);
		
		Animal kangoroo = new Kengoroo();
		animals.add(kangoroo);
		
		for(Animal animal : animals) {
			animal.makeNoise();
		}
	}
}
