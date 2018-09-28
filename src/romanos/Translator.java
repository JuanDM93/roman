package romanos;

import java.util.HashMap;
import java.util.Scanner;

public class Translator {
	
	static HashMap<Integer, String> letters = new HashMap<Integer, String>();

	private static String parse(int num) {
		
		String result = "";
		
		while (num > 0) {
			
			switch (num % 10) {
			
			case 1:
			case 2:
			case 3:
				result = "Min * mod";
				
			case 6:
			case 7:
			case 8:
				result = "Mid, Min * mod";
				
			case 4:
				result = "Min, Mid";
			case 9:
				result = "Min, Max";
				
			case 5:
				result = "Mid";
				
			case 0:
				result = "Max";
			}
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
			 
			if (test > 100) {
				letters.put(1000, "M");
				letters.put(500, "D");
				letters.put(100, "C");
			}if (test > 10) {
				letters.put(100, "C");
				letters.put(50, "L");
				letters.put(10, "X");
			}if (test > 1) {
				letters.put(10, "X");
				letters.put(5, "V");
				letters.put(1, "I");
			}
			
			result = parse(test);
		}		
		return result;
	}

	public static void main(String[] args) {
		
		while (true) {
			
			Scanner scan = new Scanner(System.in);
			int input = 0;
			String text = "";
			
			System.out.println("Enter a number between 1 - 1000: ");
			
			try {
				input = scan.nextInt();
				text = translate(input);				
				System.out.println("Your number is: " + text);
			}			
			catch (Exception ex){
				System.out.println("Wrong input, try again");;
			}
			System.out.println();
		}
	}
}
