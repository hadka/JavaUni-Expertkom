package lekce6;

import java.util.List;

public class Runner {

	public static void main(String[] args) {
		writerAndReader();
	}

	public static void writerAndReader() {
		String pathToFile = "C:\\Users\\andre\\Desktop\\javaUniTesting\\andrea20.txt";
		String pathToFolder = "C:\\Users\\andre\\Desktop\\javaUniTesting";
		Writer.writeToNewFile(pathToFile, "toto chcem zapisat");
		Writer.writeToExistingFile(pathToFile, "\npridavam text");
		Writer.writeToExistingFile(pathToFile, "\npridavam dalsi text");
		
		List<String> textFromReader = Reader.readByScanner(pathToFile);
		Reader.printOutputFromReader(textFromReader);
		
		List<String> result = FilesFinder.searchForTXTFilesInFolder(pathToFolder);
		FilesFinder.printOutAllTXTFiles(result);
		
		
	}

	public static void devideIntryCatchForLoop() {
		int numer[] = { 4, 8, 16, 32, 64, 128 }; 
	    int denom[] = { 2, 0, 4, 4, 0, 8 }; 
	    
	    TryCatchInForLoop devider = new TryCatchInForLoop(numer, denom);
	    devider.devide();
	}

	public static void denomstrateException() {
		int nums[] = new int[4];
		
		ExceptionDemo demo = new ExceptionDemo(nums);
		demo.setOutOfBoundIndex(7, 5);
	}

	public static void demonstrateMethodOverload() {
		MethodOverloading overloading = new MethodOverloading();
		
		overloading.ovlDemo();
		overloading.ovlDemo(5);
		overloading.ovlDemo(5.5, 2.2);
		overloading.ovlDemo(4, 3);
	}

}
