package lekce6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilesFinder {
	
	public static List<String> searchForTXTFilesInFolder(String pathToFolder) {
		File folder = new File(pathToFolder);
        return search(".*\\.txt", folder);
	}
	
	private static List<String> search(String pattern, File folder) {
		List<String> result = new ArrayList<>();
		
        for (final File f : folder.listFiles()) {

            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    result.add(f.getAbsolutePath());
                }
            }
        }
        return result;
    }
	
	public static void printOutAllTXTFiles(List<String> result) {
		int i = 1;
		for (String s : result) {
            System.out.println(i + ". "+s);
            i ++;
        }
	}
}
