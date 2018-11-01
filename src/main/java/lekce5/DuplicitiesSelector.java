package lekce5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DuplicitiesSelector {
	
	public List<String> selectDuplicities(List<String>listWithDuplicities){
		
		List<String>duplicities = new ArrayList<>();
		HashSet<String>uniqes = new HashSet<>();
		
		for(String s : listWithDuplicities) {
			if(!uniqes.add(s)) {
				duplicities.add(s);
			}
		}
		return duplicities;
	}
	
	public void printDuplicities(List<String>duplicities) {
		for(String s : duplicities) {
			System.out.println(s);
		}
	}
}
