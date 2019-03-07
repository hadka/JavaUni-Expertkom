package lekce6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
	
	public static List<String> readByScanner(String pathToFile) {
		List<String> text = new ArrayList<>();
		try { 
			Scanner scanner = new Scanner(new File(pathToFile));
			while (scanner.hasNextLine()) {
				text.add(scanner.nextLine());
			}
			scanner.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return text;
	}
	
	public static void deleteTextFromFile(List<String> readContent, String textToDelete, String pathToFile) {
		if(readContent.remove(textToDelete)) {
			String textToWrite = "";
			for(String s : readContent) {
				textToWrite += s+"\n";
			}
			Writer.writeToNewFile(pathToFile, textToWrite);
		}
	}
	
	public static void printOutputFromReader(List<String> textFromReader) {
		for(String s : textFromReader) {
			System.out.println(s);
		}
	}
	
	public static List<String> readByBufferedReader(String pathToFile){
		List<String> text = new ArrayList<>();
		File file = new File(pathToFile);

		BufferedReader br = null;

        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line;

            while( (line = br.readLine()) != null ) {
                text.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.toString());
        } catch (IOException e) {
            System.out.println("Unable to read file: " + file.toString());
        }finally {
            try {
                br.close();
            }catch(IOException e) {
                System.out.println("Unable to close file: " + file.toString());
            }catch(NullPointerException ex) {
            	System.out.println("File was never opened. ");
            }
        }
        return text;
	}
}
