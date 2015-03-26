package adressregister;

import static gdi.MakeItSimple.readInt;
import static gdi.MakeItSimple.readLine;

public class AdressRegister {

	public static void main(String[] args) {
		int userInput = 0;
		boolean isInputValid = true;
		AdressRegister adressReg = new AdressRegister();
		
		do {
			userInput = getUserOperation();
			
			switch(userInput) {
			case 1:
				insertAdress(adressReg);
				break;
			case 2:
				deleteAdress(adressReg);
				break;
			case 3: 
				System.out.println(adressReg);
				break;
			default:
				exit();
				isInputValid = false;
				break;
			}
			
		} while(isInputValid);
	}
	
	public static void insertAdress(AdressRegister adressRegister) {
		int position = getPosition();
		String newAdress = getNewName();
		adressRegister.insert(position, newAdress);
	}
	
	public static void deleteAdress(AdressRegister adressRegister) {
		int position = getPosition();
		adressRegister.delete(position);
	}
	
	public static int getUserOperation() {
		int userOperation = -1;
		System.out.println("1. Einfügen\n2. Löschen\n3. Anzeigen");
		userOperation = readInt();
		return userOperation;
	}
	
	public static int getPosition() {
		int position = -1;
		System.out.println("Gebe eine Position an: ");
		position = readInt();
		return position;
	}
	
	public static String getNewName() {
		String newName = "";
		System.out.println("Gebe einen neuen Namen ein: ");
		readLine();
		newName = readLine();
		return newName;
	}
	
	public static void exit() {
		System.out.println("Programm wird beendet.");
	}
	
	private String[] adressList;
	
	public AdressRegister() {
		this.adressList = new String[5];
		this.adressList[0] = "Andreas";
		this.adressList[1] = "Bernd";
		this.adressList[2] = "Carsten";
		this.adressList[3] = "Dennis";
		this.adressList[4] = "Emil";
	}
	
	public void delete(int position) {
		int currentNumberOfAdresses = this.adressList.length;
		String[] newAdressList = new String[currentNumberOfAdresses - 1];
		
		if(position >= newAdressList.length) {
			System.out.println("Position ungültig.");
			return;
		}
		
		for(int i = 0, j = 0; i < currentNumberOfAdresses; i++) {
			if(i+1 != position) {
				newAdressList[j++] = this.adressList[i];
			}
		}
		
		this.adressList = newAdressList;
		
		System.out.println(this);
	}
	
	public void insert(int position, String value) {
		int currentNumberOfAdresses = this.adressList.length;
		String[] newAdressList = new String[currentNumberOfAdresses + 1];
		
		if(position >= newAdressList.length) {
			System.out.println("Position ungültig.");
			return;
		}
		
		for(int i = 0, j = 0; i < currentNumberOfAdresses + 1; i++) {
			if(i+1 == position) {
				newAdressList[i] = value;
			} else {
				newAdressList[i] = this.adressList[j++];
			}
		}
		
		this.adressList = newAdressList;
		
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String outputStr = "";
		outputStr += "Anzahl Adressen: " + this.adressList.length + "\n";
		int end = this.adressList.length;
		
		for(int i = 0; i < end; i++) {
			outputStr += this.adressList[i] + (i < end - 1 ? ", " : "");
		}
		
		return outputStr;
	}

}
