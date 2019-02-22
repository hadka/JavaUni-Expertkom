package lekce6;

import java.io.File;
import java.util.List;

import kamenNuzkyPapir.Game;

public class Runner {

	public static void main(String[] args) {

	}

	public static void writerAndReader() {
		Writer writer = new Writer();
		writer.writeToNewFile("andrea.txt", "toto chcem zapisat");
		
		Reader reader = new Reader();
		File file = new File("C:\\Users\\andre\\Documents\\workspace-sts-3.9.4.RELEASE\\JavaExpertkomUni\\andrea.txt");
		List<String> textFromReader = reader.readByBufferedReader(file);
		for(String s : textFromReader) {
			System.out.println(s);
		}
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
