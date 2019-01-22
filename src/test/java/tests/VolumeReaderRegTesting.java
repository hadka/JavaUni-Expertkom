package tests;

import org.junit.Before;
import org.junit.Test;

import volumeReader.VolumeReaderReg;

public class VolumeReaderRegTesting {
	
	VolumeReaderReg reader;
	
	@Before
	public void init() {
		reader = new VolumeReaderReg();
	}
	
	@Test
	public void firstPrint() {
		reader.readVolumeFromProductName("Brit 400kg");
	}

}
