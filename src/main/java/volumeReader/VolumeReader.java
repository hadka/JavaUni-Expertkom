package volumeReader;

import java.util.Arrays;

public class VolumeReader {
	
	public Volume readVolumeFromProductName(String productName) {
		char[] productNameArray = convertProductNameToCharArray(productName);
		
		String volume = "";
		String volumeUnit = "";
		
		String volumeWithX = "";
		String volumeUnitWithX = "";
		
		String[] volumeUnits = {"ks", "g", "kg", "l", "ml", "cl", "dávka", "kapsle", "dkg", "dl"};
		
		try {
			for(int i = 0; i <= productNameArray.length - 1; i++) {
				if(characterIsDigitFollowedByDigit(productNameArray, i) || characterIsDigitFollowedByComma(productNameArray, i) || characterIsDigitFollowedByDot(productNameArray, i) || characterIsDigitFollowedByX(productNameArray, i)) {
					volume += productNameArray[i];
				}else if (characterIsCommaFollowedByDigit(productNameArray, i) || characterIsDotFollowedByDigit(productNameArray, i)) {
					volume += '.';
				}else if (characterIsXFollowedByDigit(productNameArray, i)) {
					volume += 'x';
				}else if(characterIsDigitFollowedByOneSyllableVolUnit(productNameArray, volumeUnits, i)){
					volume += productNameArray[i];
					volumeUnit += productNameArray[i+1];
					if(volume.contains("x")) {
						volumeWithX = volume;
						volumeUnitWithX = volumeUnit;
						resetVolume(volume);
						resetVolumeUnit(volumeUnit);
						continue;
					}else {
						break;
					}
				}else if(characterIsDigitFollowedBySpaceAndOneSyllableVolUnit(productNameArray, volumeUnits, i)) {
					volume += productNameArray[i];
					volumeUnit += productNameArray[i+2];
					if(volume.contains("x")) {
						volumeWithX = volume;
						volumeUnitWithX = volumeUnit;
						resetVolume(volume);
						resetVolumeUnit(volumeUnit);
						continue;
					}else {
						break;
					}										
				}else if(characterIsDigitFollowedByTwoSyllableVolUnit(productNameArray, volumeUnits, i)){
					volume += productNameArray[i];
					volumeUnit += Character.toString(productNameArray[i+1]) + Character.toString(productNameArray[i+2]);
					if(volume.contains("x")) {
						volumeWithX = volume;
						volumeUnitWithX = volumeUnit;
						resetVolume(volume);
						resetVolumeUnit(volumeUnit);
						continue;
					}else {
						break;
					}
				}else if(characterIsDigitFollowedByDavka(productNameArray, i)) {
					volume += productNameArray[i];
					volumeUnit += "dávka";
					break;
				}else if(characterIsDigitFollowedByDkg(productNameArray, i)){
					volume += productNameArray[i];
					volumeUnit += "dkg";
					break;
				}else if(characterIsDigitFollowedByKapsle(productNameArray, i)){
					volume += productNameArray[i];
					volumeUnit += "kapsle";
					break;
				}else {
					volume = resetVolume(volume);
					volumeUnit = resetVolumeUnit(volumeUnit);
				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			volume = "0.0";
			volumeUnit = "neznama jednotka";
		}
		
		Volume finalVolume = new Volume();
		if(!volume.equals("")) {
			finalVolume = new Volume(Double.parseDouble(volume), volumeUnit);
		}else if(volumeWithX.contains("x")){
			int i = volumeWithX.indexOf("x");
			String volumePart1 = volumeWithX.substring(0, i);
			String volumePart2 = volumeWithX.substring(i+1, volumeWithX.length());
			finalVolume = new Volume(Double.parseDouble(volumePart1)*Double.parseDouble(volumePart2), volumeUnitWithX);
		}else {
			volume = "0.0";
			volumeUnit = "neznama jednotka";
			finalVolume = new Volume(Double.parseDouble(volume), volumeUnit);
		}
		return finalVolume;
	}
	
	public String resetVolume(String volume) {
		return "";
	}
	
	public String resetVolumeUnit(String volumeUnit) {
		return "";
	}
	
	public boolean characterIsDigitFollowedByDigit(char[] productNameArray, int i) {
		return Character.isDigit(productNameArray[i]) && Character.isDigit(productNameArray[i+1]);
	}
	
	public boolean characterIsDigitFollowedByComma(char[] productNameArray, int i) {
		return Character.isDigit(productNameArray[i]) && productNameArray[i+1] == ',';
	}
	
	public boolean characterIsDigitFollowedByDot(char[] productNameArray, int i) {
		return Character.isDigit(productNameArray[i]) && productNameArray[i+1] == '.';
	}
	
	public boolean characterIsDigitFollowedByX(char[] productNameArray, int i) {
		return (Character.isDigit(productNameArray[i]) && productNameArray[i+1] == 'x') ||
				(Character.isDigit(productNameArray[i]) && productNameArray[i+1] == 'X');
	}
	
	public boolean characterIsCommaFollowedByDigit(char[] productNameArray, int i) {
		return productNameArray[i] == ',' && Character.isDigit(productNameArray[i+1]);
	}
	
	public boolean characterIsDotFollowedByDigit(char[] productNameArray, int i) {
		return productNameArray[i] == '.' && Character.isDigit(productNameArray[i+1]);
	}
	
	public boolean characterIsXFollowedByDigit(char[] productNameArray, int i) {
		return (productNameArray[i] == 'x' && Character.isDigit(productNameArray[i+1])) ||
				(productNameArray[i] == 'X' && Character.isDigit(productNameArray[i+1]));
	}
	
	public boolean characterIsDigitFollowedByOneSyllableVolUnit(char[] productNameArray, String[] volumeUnits, int i) {
		return Character.isDigit(productNameArray[i]) && listOfVolumeUnitsContains(volumeUnits, productNameArray[i+1]);
	}
	
	public boolean characterIsDigitFollowedBySpaceAndOneSyllableVolUnit(char[] productNameArray, String[] volumeUnits,
			int i) {
		return Character.isDigit(productNameArray[i]) && productNameArray[i+1] == ' ' && listOfVolumeUnitsContains(volumeUnits, productNameArray[i+2]);
	}
	
	public boolean characterIsDigitFollowedByTwoSyllableVolUnit(char[] productNameArray, String[] volumeUnits, int i) {
		return Character.isDigit(productNameArray[i]) && listOfVolumeUnitsContains(volumeUnits, Character.toString(productNameArray[i+1])+Character.toString(productNameArray[i+2]));
	}
	
	public boolean characterIsDigitFollowedByDavka(char[] productNameArray, int i) {
		return (Character.isDigit(productNameArray[i]) && productNameArray[i+1] == 'd' && productNameArray[i+2] == 'á') ||
				(Character.isDigit(productNameArray[i]) && productNameArray[i+1] == ' ' && productNameArray[i+2] == 'd' && productNameArray[i+3] == 'á');
	}
	
	public boolean characterIsDigitFollowedByDkg(char[] productNameArray, int i) {
		return (Character.isDigit(productNameArray[i]) && productNameArray[i+1] == 'd' && productNameArray[i+2] == 'k') ||
				(Character.isDigit(productNameArray[i]) && productNameArray[i+1] == ' ' && productNameArray[i+2] == 'd' && productNameArray[i+3] == 'k');
	}
	
	public boolean characterIsDigitFollowedByKapsle(char[] productNameArray, int i) {
		return (Character.isDigit(productNameArray[i]) && productNameArray[i+1] == 'k' && productNameArray[i+2] == 'a') ||
				(Character.isDigit(productNameArray[i]) && productNameArray[i+1] == ' ' && productNameArray[i+2] == 'k' && productNameArray[i+3] == 'a');
	}
	
	public char[] convertProductNameToCharArray(String productName) {
		char[] productNameArray = productName.toCharArray();
		return productNameArray;
	}
	
	public boolean listOfVolumeUnitsContains(String[] volumeUnits, char ch) {
		boolean answer = Arrays.stream(volumeUnits).anyMatch(Character.toString(ch)::equals);
		return answer;
	}
	
	public boolean listOfVolumeUnitsContains(String[] volumeUnits, String s) {
		boolean answer = Arrays.stream(volumeUnits).anyMatch(s::equals);
		return answer;
	}
}
