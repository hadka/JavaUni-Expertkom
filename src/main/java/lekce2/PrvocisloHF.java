package lekce2;

public class PrvocisloHF {
	
	public void jePrvocisloAndrea(int number) {
		if(isEvaluatedAsPrime(number)) {
			System.out.println("Number"+number+"is prime.");
		}else {
			System.out.println("Number"+number+"is NOT prime.");
		}
	}
	
	public Boolean isEvaluatedAsPrime(int number) {
		Boolean procislo = true;
		for(int delitel = 2; delitel <= number / 2; delitel++) {
		    if (number % delitel == 0) {
		        procislo = false;
		        break;
		    }
		}
		return procislo;
	}
}
