package lekce5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniqueSelector {
	
	public List<String> selectUniqueFromList(List<String> listwithDuplicates){
		
		HashSet<String> setOfUniqueStrings = new HashSet<>(listwithDuplicates);
		List<String> listOfUniqueStrings = new ArrayList<>(setOfUniqueStrings);
		return listOfUniqueStrings;
	}
	
	public void printUniqueStringsFromList(List<String> listOfUniqueStrings) {
		for(String uniqueString : listOfUniqueStrings) {
			System.out.println(uniqueString);
		}
	}

}
