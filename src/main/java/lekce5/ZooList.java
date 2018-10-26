package lekce5;

import java.util.ArrayList;
import java.util.List;

public class ZooList {
	
	private List<String> pets;

	public ZooList(List<String> pets) {
		super();
		this.pets = pets;
	}
	
	public List<String> findShorterThan5(){
		List<String> animalsShorterThan5 = new ArrayList<String>();
		for(String animal : this.pets) {
			if(animal.length() < 5) {
				animalsShorterThan5.add(animal);
			}
		}
		return animalsShorterThan5;
	}
	
	public void printRestuls(List<String> animalsShorterThan5) {
		for(String s : animalsShorterThan5) {
			System.out.println(s);
		}
	}
}
