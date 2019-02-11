package tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import volumeReader.VolumeFromProductName;
import volumeReader.VolumeReaderReg;

public class VolumeReaderTesting {
	
	VolumeReaderReg reader;
	
	@Before
	public void init() {
		reader = new VolumeReaderReg();
	}

//	@Test
//	public void checkIfVolumeUnitListContains1() {
//		String[] volumeUnits = {"g", "kg", "l", "ml"};
//		assertTrue(reader.listOfVolumeUnitsContains(volumeUnits, 'g'));
//	}
//	
//	@Test
//	public void checkIfVolumeUnitListContains2() {
//		String[] volumeUnits = {"g", "kg", "l", "ml"};
//		assertTrue(reader.listOfVolumeUnitsContains(volumeUnits, "kg"));
//	}
	
	@Test
	public void readVolume1Grams() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Brit 400g");
		assertTrue(finalVolume.getVolume().equals(400.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume2Liter() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Alpro Soya Chocolate sójový nápoj 1l");
		assertTrue(finalVolume.getVolume().equals(1.0));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}
	
	@Test
	public void readVolume3VolumeInDoubleFormat() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Cappy+ 0,8lFruit & Veggie Juice ");
		assertTrue(finalVolume.getVolume().equals(0.8));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}
	
	@Test
	public void readVolume4PercentageInProductName() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Tatra Tvaroh polotučný 18% 250g");
		assertTrue(finalVolume.getVolume().equals(250.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume5BracketsPercentageDoubleFormat() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Božkov Originál (37,5%) 0,5l");
		assertTrue(finalVolume.getVolume().equals(0.5));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}
	
	@Test
	public void readVolume7Kusy() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Moltex nature no.1 Mini dětské bio plenky 3-6 kg, 42ks");
		assertTrue(finalVolume.getVolume().equals(42.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ks"));
	}
	
	@Test
	public void readVolume8NoVolumeInProductName() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Česká produkce-Cibulka lahůdková svazek");
		assertTrue(finalVolume.getVolume().equals(0.0));
		assertTrue(finalVolume.getVolumeUnit().equals("neznama jednotka"));
	}
	
	@Test
	public void readVolume9Brackets() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Klokaní steak (cca800g)");
		assertTrue(finalVolume.getVolume().equals(800.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume10TextAfterVolume() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Česká produkce-Česnek rozdružený vanička 100g II.jakost");
		assertTrue(finalVolume.getVolume().equals(100.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume10TwoUnits1() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Vandemoortele Americký Hod dog rohlík mražený 60g/ks");
		assertTrue(finalVolume.getVolume().equals(60.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume10TwoUnits2() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("La 80ks/g");
		assertTrue(finalVolume.getVolume().equals(80.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ks"));
	}
	
	@Test
	public void readVolume11aDavka() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Prasek 80dávek");
		assertTrue(finalVolume.getVolume().equals(80.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}
	
	@Test
	public void readVolume11bDavka() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Surf Color tropical prací prášek na barevné prádlo 20 dávek");
		assertTrue(finalVolume.getVolume().equals(20.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}
	
	@Test
	public void readVolume11cDavkaAndVolume() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Coccolino Creations Tiare Flower aviváž 67 dávek 1,68l");
		assertTrue(finalVolume.getVolume().equals(67.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}
	
	@Test
	public void readVolume12aKapsle() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Prasek 80kapsli");
		assertTrue(finalVolume.getVolume().equals(80.0));
		assertTrue(finalVolume.getVolumeUnit().equals("kapsle"));
	}
	
	@Test
	public void readVolume12bKapsle() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Nescafé Dolce Gusto Grande (16 kapslí)");
		assertTrue(finalVolume.getVolume().equals(16.0));
		assertTrue(finalVolume.getVolumeUnit().equals("kapsle"));
	}
	
	@Test
	public void readVolume12cKapsle() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Nescafé Dolce Gusto Ristretto Ardenza 112g (16 kapslí)");
		assertTrue(finalVolume.getVolume().equals(16.0));
		assertTrue(finalVolume.getVolumeUnit().equals("kapsle"));
	}
	
	@Test
	public void readVolume13aml() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Casolare Olivový olej s česnekem a chilli 250ml");
		assertTrue(finalVolume.getVolume().equals(250.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ml"));
	}
	
	@Test
	public void readVolume1b3ml() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Pinot Grigio Garganega 2016, suché bílé 0,75l");
		assertTrue(finalVolume.getVolume().equals(0.75));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}
	
	@Test
	public void readVolume14general() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Česká produkce-Česnek rozdružený vanička 100g II.jakost ");
		assertTrue(finalVolume.getVolume().equals(100.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume15_4digitsVolume() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("G&G Koláč tvarohový 1250g mražený");
		assertTrue(finalVolume.getVolume().equals(1250.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume16kg() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Tatranský sýr balkánského typu 3kg (pevný podíl 1,5kg)-kyblík");
		assertTrue(finalVolume.getVolume().equals(3.0));
		assertTrue(finalVolume.getVolumeUnit().equals("kg"));
	}
	
	@Test
	public void readVolume17percentageAndkg() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Tami Zakysaná smetana 16% 3kg");
		assertTrue(finalVolume.getVolume().equals(3.0));
		assertTrue(finalVolume.getVolumeUnit().equals("kg"));
	}
	
	@Test
	public void readVolume17aSpace() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Edeka frucht joghurt erdbeere 0,1%fett 150 g");
		assertTrue(finalVolume.getVolume().equals(150.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume17bSpace() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Cibule žlutá síť 1 kg-střední");
		assertTrue(finalVolume.getVolume().equals(1.0));
		assertTrue(finalVolume.getVolumeUnit().equals("kg"));
	}
	
	@Test
	public void readVolume17percentageTextAndkg() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Edeka frucht joghurt erdbeere 0,1%fett 150g");
		assertTrue(finalVolume.getVolume().equals(150.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume18xAndVolume() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Nesquik Go čokoládová příchuť (4x80g) 320g");
		assertTrue(finalVolume.getVolume().equals(320.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume19aXAndVolume() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Nesquik Go čokoládová příchuť (4X80g) 320g");
		assertTrue(finalVolume.getVolume().equals(320.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume19bXAndVolume() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Tortilla 12 6x110g C&C 450g");
		assertTrue(finalVolume.getVolume().equals(660.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume20aXoVolume() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Nesquik Snack mléčný 4x26g");
		assertTrue(finalVolume.getVolume().equals(104.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void readVolume20bXNoVolumeMl() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Dixi Arvit vlasové tonikum proti vypadávání vlasů 6x10ml");
		assertTrue(finalVolume.getVolume().equals(60.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ml"));
	}
	
	@Test
	public void readVolume20cXNoVolumeMl() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Lenor tekutá aviváž Summer duopack (2x45 pracích dávek) 2x1360ml");
		assertTrue(finalVolume.getVolume().equals(90.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}
	
	@Test
	public void readVolume21NoVolumeUnt() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("G&G Sladidlo dávkovač 1200 tablet");
		assertTrue(finalVolume.getVolume().equals(0.0));
		assertTrue(finalVolume.getVolumeUnit().equals("neznama jednotka"));
	}	
	
	@Test
	public void readVolume22aDavkaAndVolume() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Lovela Prací prášek powder color (40 pracích dávek) 5kg");
		assertTrue(finalVolume.getVolume().equals(40.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}	
	
	@Test
	public void readVolume22bDavkaAndVolume() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Coccolino Creations Waterlily & Pink Grapefruit aviváž (42 pracích dávek) 1.5l");
		assertTrue(finalVolume.getVolume().equals(42.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}	
	
	@Test
	public void readVolume23TwoVolumes() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Asan Pet Aloe podestýlka pro hlodavce 45l (9,7kg)");
		assertTrue(finalVolume.getVolume().equals(9.7));
		assertTrue(finalVolume.getVolumeUnit().equals("kg"));
	}
	
	@Test
	public void generalTest1() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Balis Potravinová folie 30m 1ks");
		assertTrue(finalVolume.getVolume().equals(1.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ks"));
	}
	
	@Test
	public void generalTest2() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Bonaqua jemně perlivá sklo 24x250ml");
		assertTrue(finalVolume.getVolume().equals(6000.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ml"));
	}
	
	@Test
	public void generalTest3() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Funtastic Tortilla 4x25cm");
		assertTrue(finalVolume.getVolume().equals(4.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ks"));
	}
	
	@Test
	public void generalTest4() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Alete Bio Příkrm Brambory na smetaně s květákem a telecím masem 220g + Při koupi 3ks dáreček");
		assertTrue(finalVolume.getVolume().equals(220.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void generalTest5() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Strep Sugaring voskové depilační pásky na tělo 20ks + 4 ubrousky");
		assertTrue(finalVolume.getVolume().equals(20.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ks"));
	}
	
	@Test
	public void generalTest6() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("G&G Filtry na kávu velikost 4 100ks");
		assertTrue(finalVolume.getVolume().equals(100.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ks"));
	}
	
	@Test
	public void generalTest7() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("ma Dóza FRESHBOX 3ks (0.2l ,0.5l, 1.0l)");
		assertTrue(finalVolume.getVolume().equals(3.0));
		assertTrue(finalVolume.getVolumeUnit().equals("ks"));
	}
	
	@Test
	public void generalTest8() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Finish Powerball Quantum Max tablety do myčky nádobí 60ks 930g");
		assertTrue(finalVolume.getVolume().equals(930.0));
		assertTrue(finalVolume.getVolumeUnit().equals("g"));
	}
	
	@Test
	public void generalTest9() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Tyrconnell Port Casks 10y 0,7l 46%");
		assertTrue(finalVolume.getVolume().equals(0.7));
		assertTrue(finalVolume.getVolumeUnit().equals("l"));
	}
	
	@Test
	public void testPraciDavka() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Lovela Prací prášek powder color (40 pracích dávek) 5kg");
		assertTrue(finalVolume.getVolume().equals(40.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}
	
	@Test
	public void testPraciDavkaSX() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Lenor tekutá aviváž Summer duopack (2x45 pracích dávek) 2x1360ml");
		assertTrue(finalVolume.getVolume().equals(90.0));
		assertTrue(finalVolume.getVolumeUnit().equals("dávka"));
	}	
	
	@Test
	public void testDEN() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("SCHOLL Light LEGS Kompresní punčochové kalhoty 20 DEN tělové L");
		assertTrue(finalVolume.getVolume().equals(0.0));
		assertTrue(finalVolume.getVolumeUnit().equals("neznama jednotka"));
	}	
	
	@Test
	public void testXWithSpace() {
		VolumeFromProductName finalVolume = reader.readVolumeFromProductName("Feyel Kachní Foie Gras 2 × 40g");
		assertThat(finalVolume.getVolume()).isEqualTo(80.0);
		assertThat(finalVolume.getVolumeUnit()).isEqualTo("g");
	}
}
