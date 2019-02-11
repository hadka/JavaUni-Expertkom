package volumeReader;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class VolumeReaderReg {
	
	public Volume readVolumeFromProductName(String productName) {
		
		String[] volumeUnitsArray = {"pracich davek", "davek", "kapsli", "g", "ks", "kg", "l", "ml", "cl", "davka", "kapsle", "praci davka", "dkg", "dl"};
		List<String> volumeUnitsNoAccents = Arrays.stream(volumeUnitsArray).collect(Collectors.toList());
		
		String volume = "";
		String volumeUnit = "";
		
		String productNameNoAccents = StringUtils.stripAccents(productName);
		
		for(String currentVolUnit : volumeUnitsNoAccents) {
			String regexCondition1 = returnConditionForAxBPattern();
			Matcher m1 = searchMatchBasedOnRegexCondition(productNameNoAccents, currentVolUnit, regexCondition1);
			if(m1.find()) {
				return determineVolumeFromAxBPattern(m1, currentVolUnit);
			}else {
				String regexCondition2 = returnConditionForStandardVolumePattern();
				Matcher m2 = searchMatchBasedOnRegexCondition(productNameNoAccents, currentVolUnit, regexCondition2);
				if (m2.find()) {
					String theGroup2 = m2.group(0);
					String volumeRegexCondition2 = returnConditionForNumberPartOfTheVolume();
					Matcher mat2 = searchMatchBasedOnRegexCondition(theGroup2, "", volumeRegexCondition2);
					if(mat2.find()) {
						return determineVolumeFromStandardVolumePattern(volume, volumeUnit, mat2, theGroup2);
					}
				}
			}
		}
		if(volumeAndVolumeUnitIsStillUndetermined(volume, volumeUnit)) {
			String regexCondition3 = returnConditionForAxPattern();
			Matcher m3 = searchMatchBasedOnRegexCondition(productNameNoAccents, "", regexCondition3);
			if(m3.find()) {
				return determineVolumeByPieces(m3, volume, volumeUnit);
			}
		}
		return inAnyOtherCaseSetVolumeToUndetermined(volume, volumeUnit);
	}

	
	private String returnConditionForAxBPattern() {
		String regexCondition1 = "(\\d+[xX]\\d+(\\s)?)";
		return regexCondition1;
	}
	
	private Matcher searchMatchBasedOnRegexCondition(String searchedString, String addedString, String regexCondition1) {
		String regexPattern = regexCondition1+addedString;
		Pattern p = Pattern.compile(regexPattern);
		Matcher m = p.matcher(searchedString);
		return m;
	}
	
	private Volume determineVolumeFromAxBPattern(Matcher m, String currentVolUnit) {
		String theGroup = m.group(0).replaceAll("X", "x");
		int i = theGroup.indexOf("x");
		String volumePart1 = theGroup.substring(0, i);
		String volumePart2 = theGroup.substring(i+1, theGroup.length()).replace(currentVolUnit, "");
		String volumePartTotal = volumePart1+"x"+volumePart2;
		currentVolUnit = formatVolume(volumePartTotal, currentVolUnit, theGroup);
		return new Volume(Double.parseDouble(volumePart1)*Double.parseDouble(volumePart2), currentVolUnit);
	}

	private String formatVolume(String volume, String volumeUnit, String theGroup2) {
		volumeUnit = theGroup2.replace(volume, "").replaceAll(" ", "").replace("a", "");
		if(volumeUnit.equals("davek")||volumeUnit.equals("dvek")||volumeUnit.equals("prcichdvek")) {
			volumeUnit = "dávka";
		}else if(volumeUnit.equals("kapsli")||volumeUnit.equals("kpsli")||volumeUnit.equals("kpsle")) {
			volumeUnit = "kapsle";
		}
		return volumeUnit;
	}
	
	private String returnConditionForStandardVolumePattern() {
		String regexCondition2 = "(\\d+((\\.\\d+)?|(\\,\\d+)?)(\\s)?)";
		return regexCondition2;
	}
	
	private String returnConditionForNumberPartOfTheVolume() {
		String volumeRegexCondition2 = "(\\s)?\\d+((\\.\\d+)|(\\,\\d+))?";
		return volumeRegexCondition2;
	}
	
	private Volume determineVolumeFromStandardVolumePattern(String volume, String volumeUnit, Matcher m, String theGroup) {
			volume = (m.group(0));
			volumeUnit = formatVolume(volume, volumeUnit, theGroup);
			volume = volume.replaceAll(",", ".");
			return new Volume(Double.parseDouble(volume), volumeUnit);
	}
	
	private boolean volumeAndVolumeUnitIsStillUndetermined(String volume, String volumeUnit) {
		return volume.equals("") && volumeUnit.equals("");
	}
	
	private String returnConditionForAxPattern() {
		String regexCondition3 = "\\d+[xX]";
		return regexCondition3;
	}
	
	private Volume determineVolumeByPieces(Matcher m, String volume, String volumeUnit) {
		String theGroup1 = m.group(0);
		int i = theGroup1.indexOf("x");
		volume = theGroup1.substring(0, i);
		volumeUnit = "ks";
		return new Volume(Double.parseDouble(volume), volumeUnit);
	}
	
	private Volume inAnyOtherCaseSetVolumeToUndetermined(String volume, String volumeUnit) {
		volume = "0.0";
		volumeUnit = "neznama jednotka";				
		return new Volume(Double.parseDouble(volume), volumeUnit);
	}
}
