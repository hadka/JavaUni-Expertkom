package lekce6;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Writer {
	
	private BufferedWriter writer;

	public void writeToExistingFile(String pathToFile, String contentToWriteToFile) {
		BufferedWriter bw = null;
		FileWriter fw = null;		
		try {
			fw = new FileWriter(pathToFile, true);
			bw = new BufferedWriter(fw);
			bw.write(contentToWriteToFile);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void writeToNewFile(String newFileName, String somethignToWrite) {
		writer = null;
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(newFileName), "utf-8"));
		    writer.write(somethignToWrite);
		} catch (IOException ex) {
		    ex.getLocalizedMessage();
		} finally {
		   try {
			   writer.close();
		   }catch (Exception ex){
			   ex.getLocalizedMessage();
		   }
		}
	}
}
