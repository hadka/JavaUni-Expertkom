package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import volumeReader.Volume;
import volumeReader.VolumeReaderReg;

public class VolumeReaderRegTesting {
	
	VolumeReaderReg reader;
	
	@Before
	public void init() {
		reader = new VolumeReaderReg();
	}
	
	@Test
	public void firstPrint() {
		Volume finalVolume = reader.readVolumeFromProductName("Brat 1.400g");
		assertTrue(finalVolume.getVolume().equals(1.400));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void firstPrint2() {
		Volume finalVolume = reader.readVolumeFromProductName("Nesquik Go čokoládová příchuť (4x80g) 320g");
		assertTrue(finalVolume.getVolume().equals(320.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume1b3ml() {
		Volume finalVolume = reader.readVolumeFromProductName("Pinot Grigio Garganega 2016, suché bílé 0,75l");
		assertTrue(finalVolume.getVolume().equals(0.75));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}
	
	@Test
	public void readVolume11aDavka() {
		Volume finalVolume = reader.readVolumeFromProductName("Prasek 80 dávek");
		assertTrue(finalVolume.getVolume().equals(80.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}
	
	@Test
	public void readVolume9Brackets() {
		Volume finalVolume = reader.readVolumeFromProductName("Klokaní steak (cca800g)");
		assertTrue(finalVolume.getVolume().equals(800.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
}
