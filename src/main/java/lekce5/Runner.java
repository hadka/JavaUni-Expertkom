package lekce5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		List<String> data = new ArrayList<>();
		data.add("one");
		data.add("two");
		data.add("andrea");
		data.add("two");		
		
		StringCounter counter = new StringCounter();
		HashMap<String, Integer> results = counter.countStringsInList(data);
		System.out.println(results);
	}


	public static void organiseList() {
		ArrayOrganiser organiser = new ArrayOrganiser();
		Integer[] unsortedArray1 = {14, 0, 58, 16, 20};
		Integer[] unsortedArray2 = {14, 0, 58, 16, 20};
		Integer[] sortedArrayDescending = organiser.sortArrayDescending(unsortedArray1);
		Integer[] sortedArrayAscending = organiser.sortArrayAscending(unsortedArray2);
		System.out.println("Descending: ");
		organiser.printArray(sortedArrayDescending);
		System.out.println("Ascending: ");
		organiser.printArray(sortedArrayAscending);
	}


	public static void findShorterThan5Animals() {
		List<String> animals = new ArrayList<>();
	    animals.add("kocka");
	    animals.add("had");
	    animals.add("pes");
	    animals.add("kralik");
	    
	    ZooList zooList = new ZooList(animals);
	    
	    List<String> animalsShorterThan5 = zooList.findShorterThan5();
	    zooList.printRestuls(animalsShorterThan5);
	}
	

	public static void duplicitiesSelector() {
		List<String> listString = new ArrayList<String>();
		listString.add("vicky");
        listString.add("chirag");
        listString.add("heer");
        listString.add("riddhi");
        listString.add("chirag");
        
        DuplicitiesSelector selector = new DuplicitiesSelector();
        List<String> duplicities = selector.selectDuplicities(listString);
        selector.printDuplicities(duplicities);
	}


	public static void runUniqueSelector() {
		List<String> listString = new ArrayList<String>();
		listString.add("vicky");
        listString.add("chirag");
        listString.add("heer");
        listString.add("riddhi");
        listString.add("chirag");
        UniqueSelector selector = new UniqueSelector();
        List<String> listOfUniqueWords = selector.selectUniqueFromList(listString);
        selector.printUniqueStringsFromList(listOfUniqueWords);
	}


	public static void countStringsInList() {
		List<String> listWithStringsToBeCounted = new ArrayList<>();
		listWithStringsToBeCounted.add("one");
		listWithStringsToBeCounted.add("two");
		listWithStringsToBeCounted.add("andrea");
		listWithStringsToBeCounted.add("two");
		
		
		StringCounter counter = new StringCounter();
		counter.countStringsInList(listWithStringsToBeCounted);
	}


	public static void dictionaryCalling() {
		Dictionary dic = new Dictionary();
		dic.createDictionary("It�s not a bug � it�s an undocumented feature. (Anonymous)");
	}


	public static void referenceAurguments() {
		ReferenceArguments ob = new ReferenceArguments(15, 20); 
		 
	    System.out.println("ob.a and ob.b before call: " + 
	                       ob.a + " " + ob.b); 
	 
	    ob.change(ob); 
	 
	    System.out.println("ob.a and ob.b after call: " + 
	                       ob.a + " " + ob.b);
	}

	
	public static void demonstrateValueArguments() {
		ValueArgument ob = new ValueArgument(); 
	    
	    int a = 15, b = 20; 
	 
	    System.out.println("a and b before call: " + 
	                       a + " " + b); 
	 
	    ob.makeNoChange(a, b);  
	 
	    System.out.println("a and b after call: " + 
	                       a + " " + b);
	}

	public static void runAminalsDemonstration() {
		findShorterThan5Animals();
	}

	public static void demoRunner() {
		AccessDemo demo = new AccessDemo();  
	    
	    demo.setAlpha(-99); 
	    System.out.println("ob.alpha is " + demo.getAlpha()); 
	 
	    // You cannot access alpha like this: 
	    //  ob.alpha = 10; // Wrong! alpha is private! 
	    
	    demo.beta = 88;  
	    demo.gamma = 99;
	} 
}
