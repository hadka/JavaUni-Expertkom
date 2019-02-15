package lekce5;

import java.util.HashMap;
import java.util.List;

public class StringCounter {
	
	public HashMap<String, Integer> countStringsInList(List<String> listOfString) {
		HashMap<String, Integer> stringCountMap = new HashMap<>();
		
		for(String s : listOfString) {
			if(stringCountMap.containsKey(s)) {
				stringCountMap.put(s, stringCountMap.get(s) + 1);
			}else {
				stringCountMap.put(s, 1);
			}
		}
		return stringCountMap;
	}

}
