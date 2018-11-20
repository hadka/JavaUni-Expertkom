package lekce5;

import java.util.HashMap;

public class CharCounter {
	
	String sentence;

	public CharCounter(String sentence) {
		super();
		this.sentence = sentence;
	}
	
	public HashMap<Character, Integer> getCountOfCharacters(){
		char[] arrayOfChars = convertStringToArrayOfChars(this.sentence);
		HashMap<Character, Integer> mapOfChars = new HashMap<>();
		
		for (char ch : arrayOfChars) {
			if(mapOfChars.containsKey(ch)) {
				mapOfChars.put(ch, mapOfChars.get(ch) + 1);
			}else {
				mapOfChars.put(ch, 1);
			}
		}
		return mapOfChars;
	}
	
	private char[] convertStringToArrayOfChars(String sentence) {
		char[] arrayOfChars = sentence.toCharArray();
		return arrayOfChars;
	}
	
	public void printResult(HashMap<Character, Integer> mapOfChars) {
		System.out.println(mapOfChars);
	}
}
