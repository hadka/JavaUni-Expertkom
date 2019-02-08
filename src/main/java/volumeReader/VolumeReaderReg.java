package volumeReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class VolumeReaderReg {
	
	public Volume readVolumeFromProductName(String productName) {
		
		String[] volumeUnitsArray = {"ks", "g", "kg", "l", "ml", "cl", "davka", "kapsle", "dkg", "dl"};
		List<String> volumeUnitsNoAccents = Arrays.stream(volumeUnitsArray).collect(Collectors.toList());
		volumeUnitsNoAccents.add("davek");
//		List<String> volumeUnitsNoAccents = new ArrayList<>();
//		for(String volumeUnit : volumeUnits) {
//			String volumeUnitNoAccents = StringUtils.stripAccents(volumeUnit);
//			volumeUnitsNoAccents.add(volumeUnitNoAccents);
//		}
		
		String volume = "";
		String volumeUnit = "";
		
		String productNameNoAccents = StringUtils.stripAccents(productName);
		
//		Pattern p = Pattern.compile("\\d+k");
//		Pattern p = Pattern.compile("\\d+(\\.\\d+)?kg");
//		Pattern p = Pattern.compile("\\d+(\\.\\d+)?(\\s)?kg|\\d+(\\.\\d+)?(\\s)?g");
		String regexCondition = "(\\s)([^x])?\\d+((\\.\\d+)?|(\\,\\d+)?)(\\s)?";
//		String regexCondition = "((\\s)|[^x])?\\d+((\\.\\d+)?|(\\,\\d+)?)(\\s)?";
		for(String volUnit : volumeUnitsNoAccents) {
			String regexPattern = regexCondition+volUnit;
			Pattern p = Pattern.compile(regexPattern);
			Matcher m = p.matcher(productNameNoAccents);
			if (m.find()) {
				String theGroup = m.group(0);
				String volumeRegexCondition = "(\\s)?\\d+((\\.\\d+)|(\\,\\d+))?";
				Pattern pat = Pattern.compile(volumeRegexCondition);
				Matcher mat = pat.matcher(theGroup);
				if(mat.find()) {
					volume = (mat.group(0)).replaceAll(" ", "");
					volumeUnit = theGroup.replace(volume, "").replaceAll(" ", "");
					if(volumeUnit.equals("davek")) {
						volumeUnit = "dávka";
					}
					volume = volume.replaceAll(",", ".");
					break;
				}
			}else {
				volume = "0.0";
				volumeUnit = "neznama jednotka";				
			}
		}
		return new Volume(Double.parseDouble(volume), volumeUnit);
	}

}
