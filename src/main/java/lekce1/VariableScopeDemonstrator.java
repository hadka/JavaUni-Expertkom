package lekce1;

public class VariableScopeDemonstrator {

	public static void main(String[] args) {
		int forTheWholeProgramVar = 10;
		
		if(forTheWholeProgramVar == 10) {
			int onlyForIfBlockVar = 20;
			System.out.println("Variables forTheWholeProgramVar and onlyForIfBlockVar are "
								+forTheWholeProgramVar + " and "+onlyForIfBlockVar);
		}
		
//		onlyForIfBlockVar = 30;
		forTheWholeProgramVar = 50;

	}

}
