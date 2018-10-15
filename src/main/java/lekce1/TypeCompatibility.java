package lekce1;

public class TypeCompatibility {

	public static void main(String[] args) {
		
		int i = 10;
		int j = 8;
		
		int r = i / j;
		float f= (float) i / j;
		double d = (double) i / j;
		long l = i / j;
		double h = 1.23 / 5;
		
		System.out.println("Integer oreze desatinne miesta: "+r);
		System.out.println("Float ponecha desatinne miesta: "+f);
		System.out.println("Double ponecha desatinne miesta: "+d);
		System.out.println("Long ponecha desatinne miesta: "+l);
		System.out.println("h="+h);
	}
}
