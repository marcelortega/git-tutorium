package summierer;

import static gdi.MakeItSimple.readInt;

public class Summierer {

	public static void main(String[] args) {
		int userInput = 0;
		int result = 0;
		boolean isInputValid = true;
		
		do {
			System.out.print("Geben Sie ein Zahl ein (negative Zahl, zum Beenden): ");
			userInput = readInt();
			
			if (userInput > 0) {
				result += userInput;
			} else {
				isInputValid = false;
			}
		} while(isInputValid);
		
		System.out.println("Ergebnis = " + result);
	}

}
