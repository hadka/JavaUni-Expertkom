package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import volumeReader.Volume;
import volumeReader.VolumeReader;

public class VolumeReaderTesting {
	
	VolumeReader reader;
	
	@Before
	public void init() {
		reader = new VolumeReader();
	}
	
	@Test
	public void checkIfVolumeUnitListContains1() {
		String[] volumeUnits = {"g", "kg", "l", "ml"};
		assertTrue(reader.listOfVolumeUnitsContains(volumeUnits, 'g'));
	}
	
	@Test
	public void checkIfVolumeUnitListContains2() {
		String[] volumeUnits = {"g", "kg", "l", "ml"};
		assertTrue(reader.listOfVolumeUnitsContains(volumeUnits, "kg"));
	}
	
	@Test
	public void readVolume1Grams() {
		Volume finalVolume = reader.readVolumeFromProductName("Brit 400g");
		assertTrue(finalVolume.getVolume().equals(400.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume2Liter() {
		Volume finalVolume = reader.readVolumeFromProductName("Alpro Soya Chocolate sójový nápoj 1l");
		assertTrue(finalVolume.getVolume().equals(1.0));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}
	
	@Test
	public void readVolume3VolumeInDoubleFormat() {
		Volume finalVolume = reader.readVolumeFromProductName("Cappy+ 0,8lFruit & Veggie Juice ");
		assertTrue(finalVolume.getVolume().equals(0.8));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}
	
	@Test
	public void readVolume4PercentageInProductName() {
		Volume finalVolume = reader.readVolumeFromProductName("Tatra Tvaroh polotučný 18% 250g");
		assertTrue(finalVolume.getVolume().equals(250.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume5BracketsPercentageDoubleFormat() {
		Volume finalVolume = reader.readVolumeFromProductName("Božkov Originál (37,5%) 0,5l");
		assertTrue(finalVolume.getVolume().equals(0.5));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}
	
	@Test
	public void readVolume7Kusy() {
		Volume finalVolume = reader.readVolumeFromProductName("Moltex nature no.1 Mini dětské bio plenky 3-6 kg, 42ks");
		assertTrue(finalVolume.getVolume().equals(42.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ks"));
	}
	
	@Test
	public void readVolume8NoVolumeInProductName() {
		Volume finalVolume = reader.readVolumeFromProductName("Česká produkce-Cibulka lahůdková svazek");
		assertTrue(finalVolume.getVolume().equals(0.0));
		assertTrue(finalVolume.getVolumeUnit().equals("neznama jednotka"));
	}
	
	@Test
	public void readVolume9Brackets() {
		Volume finalVolume = reader.readVolumeFromProductName("Klokaní steak (cca800g)");
		assertTrue(finalVolume.getVolume().equals(800.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume10TextAfterVolume() {
		Volume finalVolume = reader.readVolumeFromProductName("Česká produkce-Česnek rozdružený vanička 100g II.jakost");
		assertTrue(finalVolume.getVolume().equals(100.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume10TwoUnits1() {
		Volume finalVolume = reader.readVolumeFromProductName("Vandemoortele Americký Hod dog rohlík mražený 60g/ks");
		assertTrue(finalVolume.getVolume().equals(60.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume10TwoUnits2() {
		Volume finalVolume = reader.readVolumeFromProductName("La 80ks/g");
		assertTrue(finalVolume.getVolume().equals(80.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ks"));
	}
	
	@Test
	public void readVolume11aDavka() {
		Volume finalVolume = reader.readVolumeFromProductName("Prasek 80dávek");
		assertTrue(finalVolume.getVolume().equals(80.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}
	
	@Test
	public void readVolume11bDavka() {
		Volume finalVolume = reader.readVolumeFromProductName("Surf Color tropical prací prášek na barevné prádlo 20 dávek");
		assertTrue(finalVolume.getVolume().equals(20.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}
	
	@Test
	public void readVolume11cDavkaAndVolume() {
		Volume finalVolume = reader.readVolumeFromProductName("Coccolino Creations Tiare Flower aviváž 67 dávek 1,68l");
		assertTrue(finalVolume.getVolume().equals(67.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}
	
	@Test
	public void readVolume12aKapsle() {
		Volume finalVolume = reader.readVolumeFromProductName("Prasek 80kapsli");
		assertTrue(finalVolume.getVolume().equals(80.0));
		assertTrue(finalVolume.getVolumeUnit().equals("kapsle"));
	}
	
	@Test
	public void readVolume12bKapsle() {
		Volume finalVolume = reader.readVolumeFromProductName("Nescafé Dolce Gusto Grande (16 kapslí)");
		assertTrue(finalVolume.getVolume().equals(16.0));
		assertTrue(finalVolume.getVolumeUnit().equals("kapsle"));
	}
	
	@Test
	public void readVolume12cKapsle() {
		Volume finalVolume = reader.readVolumeFromProductName("Nescafé Dolce Gusto Ristretto Ardenza 112g (16 kapslí)");
		assertTrue(finalVolume.getVolume().equals(112.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume13aml() {
		Volume finalVolume = reader.readVolumeFromProductName("Casolare Olivový olej s česnekem a chilli 250ml");
		assertTrue(finalVolume.getVolume().equals(250.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ml"));
	}
	
	@Test
	public void readVolume1b3ml() {
		Volume finalVolume = reader.readVolumeFromProductName("Pinot Grigio Garganega 2016, suché bílé 0,75l");
		assertTrue(finalVolume.getVolume().equals(0.75));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}
	
	@Test
	public void readVolume14general() {
		Volume finalVolume = reader.readVolumeFromProductName("Česká produkce-Česnek rozdružený vanička 100g II.jakost ");
		assertTrue(finalVolume.getVolume().equals(100.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume15_4digitsVolume() {
		Volume finalVolume = reader.readVolumeFromProductName("G&G Koláč tvarohový 1250g mražený");
		assertTrue(finalVolume.getVolume().equals(1250.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume16kg() {
		Volume finalVolume = reader.readVolumeFromProductName("Tatranský sýr balkánského typu 3kg (pevný podíl 1,5kg)-kyblík");
		assertTrue(finalVolume.getVolume().equals(3.0));
		assertTrue(finalVolume.getVolumeUnit().equals("kg"));
	}
	
	@Test
	public void readVolume17percentageAndkg() {
		Volume finalVolume = reader.readVolumeFromProductName("Tami Zakysaná smetana 16% 3kg");
		assertTrue(finalVolume.getVolume().equals(3.0));
		assertTrue(finalVolume.getVolumeUnit().equals("kg"));
	}
	
	@Test
	public void readVolume17aSpace() {
		Volume finalVolume = reader.readVolumeFromProductName("Edeka frucht joghurt erdbeere 0,1%fett 150 g");
		assertTrue(finalVolume.getVolume().equals(150.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume17bSpace() {
		Volume finalVolume = reader.readVolumeFromProductName("Cibule žlutá síť 1 kg-střední");
		assertTrue(finalVolume.getVolume().equals(0.0));
		assertTrue(finalVolume.getVolumeUnit().equals("neznama jednotka"));
	}
	
	@Test
	public void readVolume17percentageTextAndkg() {
		Volume finalVolume = reader.readVolumeFromProductName("Edeka frucht joghurt erdbeere 0,1%fett 150g");
		assertTrue(finalVolume.getVolume().equals(150.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume18xAndVolume() {
		Volume finalVolume = reader.readVolumeFromProductName("Nesquik Go čokoládová příchuť (4x80g) 320g");
		assertTrue(finalVolume.getVolume().equals(320.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume19aXAndVolume() {
		Volume finalVolume = reader.readVolumeFromProductName("Nesquik Go čokoládová příchuť (4X80g) 320g");
		assertTrue(finalVolume.getVolume().equals(320.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume19bXAndVolume() {
		Volume finalVolume = reader.readVolumeFromProductName("Tortilla 12 6x110g C&C 450g");
		assertTrue(finalVolume.getVolume().equals(450.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume20aXoVolume() {
		Volume finalVolume = reader.readVolumeFromProductName("Nesquik Snack mléčný 4x26g");
		assertTrue(finalVolume.getVolume().equals(104.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume20bXNoVolumeMl() {
		Volume finalVolume = reader.readVolumeFromProductName("Dixi Arvit vlasové tonikum proti vypadávání vlasů 6x10ml");
		assertTrue(finalVolume.getVolume().equals(60.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ml"));
	}
	
	@Test
	public void readVolume20cXNoVolumeMl() {
		Volume finalVolume = reader.readVolumeFromProductName("Lenor tekutá aviváž Summer duopack (2x45 pracích dávek) 2x1360ml");
		assertTrue(finalVolume.getVolume().equals(2720.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ml"));
	}
	
	@Test
	public void readVolume21NoVolumeUnt() {
		Volume finalVolume = reader.readVolumeFromProductName("G&G Sladidlo dávkovač 1200 tablet");
		assertTrue(finalVolume.getVolume().equals(0.0));
		assertTrue(finalVolume.getVolumeUnit().equals("neznama jednotka"));
	}	
	
	@Test
	public void readVolume22aDavkaAndVolume() {
		Volume finalVolume = reader.readVolumeFromProductName("Lovela Prací prášek powder color (40 pracích dávek) 5kg");
		assertTrue(finalVolume.getVolume().equals(5.0));
		assertTrue(finalVolume.getVolumeUnit().equals("kg"));
	}	
	
	@Test
	public void readVolume22bDavkaAndVolume() {
		Volume finalVolume = reader.readVolumeFromProductName("Coccolino Creations Waterlily & Pink Grapefruit aviváž (42 pracích dávek) 1.5l");
		assertTrue(finalVolume.getVolume().equals(1.5));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}	
	
	@Test
	public void readVolume23TwoVolumes() {
		Volume finalVolume = reader.readVolumeFromProductName("Asan Pet Aloe podestýlka pro hlodavce 45l (9,7kg)");
		assertTrue(finalVolume.getVolume().equals(45.0));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}	
}
