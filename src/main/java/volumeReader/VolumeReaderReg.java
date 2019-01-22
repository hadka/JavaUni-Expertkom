package volumeReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VolumeReaderReg {
	
	public String readVolumeFromProductName(String productName) {
		Pattern p = Pattern.compile("\\d\\bkg\\b");
		Matcher m = p.matcher(productName);
		if (m.find()) {
			String theGroup = m.group(0);
			System.out.println(theGroup);
		}
		
		return null;
	}

}
