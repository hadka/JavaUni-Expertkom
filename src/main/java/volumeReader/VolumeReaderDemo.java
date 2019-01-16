package volumeReader;

import java.util.ArrayList;
import java.util.List;

public class VolumeReaderDemo {
	
	public Integer readVolume(String productName) {
		char[] productNameArray = convertProductNameToCharArray(productName);
		List<Character> volumeDigits = selectDigitsFromProductName(productNameArray);
		String volumeText = convertVolumeDigitsToString(volumeDigits);
		Integer volume = Integer.parseInt(volumeText);
		return volume;
	}

	public char[] convertProductNameToCharArray(String productName) {
		char[] productNameArray = productName.toCharArray();
		return productNameArray;
	}
	
	public List<Character> selectDigitsFromProductName(char[] productNameArray){
		List<Character> volumeDigits = new ArrayList<>();
		for(char ch : productNameArray) {
			if(Character.isDigit(ch)) {
				volumeDigits.add(ch);
			}
		}
		return volumeDigits;
	}
	
	public String convertVolumeDigitsToString(List<Character> volumeDigits) {
		String volumeText = "";
		for(char ch : volumeDigits) {
			volumeText += ch;
		}
		return volumeText;
	}
}
