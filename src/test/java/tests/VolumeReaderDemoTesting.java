package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import volumeReader.VolumeReaderDemo;

public class VolumeReaderDemoTesting {
	
	VolumeReaderDemo reader;
	
	@Before
	public void init() {
		reader = new VolumeReaderDemo();
	}
	
	@Test
	public void testAssetThatExamples() {
		char[] convertedString = reader.convertProductNameToCharArray("Brit Paté & Meat Puppy 400g");
		assertEquals(27, convertedString.length);
	}
	
	@Test
	public void testSelectDigitsFromProductName() {
		char[] productNameArray = {'L', 'e', 'n', 't', 'i', 'l', 'k', 'y', '2', '8'};
		List<Character> volumeDigits = reader.selectDigitsFromProductName(productNameArray);
		assertEquals(2, volumeDigits.size());
		assertTrue(volumeDigits.contains('2'));
		assertTrue(volumeDigits.contains('8'));
	}
	
	@Test
	public void testConvertVolumeDigitsToString() {
		List<Character> volumeDigits = new ArrayList<>();
		volumeDigits.add('5');
		volumeDigits.add('6');
		assertEquals("56", reader.convertVolumeDigitsToString(volumeDigits));
	}
	
	@Test
	public void testReadVolumeFromString1() {
		Integer volume = reader.readVolume("Alpro Soya Chocolate sójový nápoj 1l");
		assertTrue(volume.equals(1));
	}
	
	@Test
	public void testReadVolumeFromString2() {
		Integer volume = reader.readVolume("Božkov Originál (37,5%) 0,5l");
		assertTrue(volume.equals(0.5));
	}

}
