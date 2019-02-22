package lekce5;

import java.util.HashMap;

public class Dictionary {
	
	public HashMap<Character, Integer> createDictionary(String inputString){
  
        char[] strArray = turnInputStringToArray(inputString); 
  
        HashMap<Character, Integer> charCountMap = addCharactersToHashMap(strArray);
        
        System.out.println(charCountMap.toString());
        
        return charCountMap;
    }

	private char[] turnInputStringToArray(String inputString) {
		char[] strArray = inputString.toCharArray();
		return strArray;
	}
	
	private HashMap<Character, Integer> addCharactersToHashMap(char[] strArray) {
		
		HashMap<Character, Integer> charCountMap 
        = new HashMap<>(); 
		
		for (char c : strArray) { 
            if (charCountMap.containsKey(c)) { 
                charCountMap.put(c, charCountMap.get(c) + 1); 
            } 
            else {
                charCountMap.put(c, 1); 
            } 
        }
		return charCountMap;
	}	
}