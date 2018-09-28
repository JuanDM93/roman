package romanos;

import java.util.Scanner;

public class Translator {
	
	private static String parse(int num, String[] letters) {
		
		String result = "";
		int test = num % 10;
		
		switch (test) {
		case 1:
		case 2:
		case 3:
			for (int i = 0; i < test; i++) {
				result += letters[0];
			}
			break;
		case 4:
			result = letters[0] + letters[1];
			break;
		case 5:
			result = letters[1];
			break;
		case 9:
			result += letters[0] + letters[2];
			break;
		case 6:
		case 7:
		case 8:
			result += letters[1];
			for (int i = 0; i < test - 5; i++) {
				result += letters[0];
			}
			break;
		}
		return result;	
	}
	
	private static String translate(int test) {
		
		String result = "";
		
		if (test > 1000 || test < 0) {
			return "Number not in range";
		}
		if (test == 0) {
			result = "0";
		}
		else {
			String[] units = {"C", "D", "M"};
			result = parse((test/100), units);
			
			String[] tens = {"X", "L", "C"}; 
			result += parse((test/10), tens);
			
			String[] cents = {"I", "V", "X"};
			result += parse((test), cents);
		}		
		return result;
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		boolean flag = true;
		while (flag) {
			
			int input = 0;
			String text = "";
			System.out.println("Enter a number between 1 - 1000 or -1 to exit: ");
						
			try {
				input = scan.nextInt();
				if (input < 0) {
					flag = !flag;
					break;
				}
				text = translate(input);				
				System.out.println("Your number is: " + text);
			}			
			catch (Exception ex){
				System.out.println("Wrong input, try again");;
			}
			System.out.println();
		}
		scan.close();
	}
}
