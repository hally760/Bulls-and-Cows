import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int sNum[] = {0,0,0,0};						//stores the secret number
		String out;									//stores the output for the user
		sNum = randomisingNumbers(sNum);
		
		//loops around until the user guesses the secret number correctly
		while (true) {
			int gNum[] = {0,0,0,0};					//stores the users guess
			gNum = userInp(gNum);
			out = getBullsCows(gNum, sNum);
			System.out.println(out);
			
			//breaks out of the while loop if the number of bulls is detected as the character '4'
			if (out.charAt(6) == '4') {
				break;
			}
		}
		System.out.println("Game over!");
		
	}
	
	//creates a 4 digit number where there are no duplicate numbers
	public static int[] randomisingNumbers(int[] array) {
		Random r = new Random();
		
		for (int i = 0; i < array.length; i++) {
			boolean found = true;
			int num = 0;
			
			while (found) {
				found = false;
				num = r.nextInt(9) + 1;
				found = arrayChecker(num, array);
			}
			array[i] = num;
		}
		return array;
	}
	
	//allows user to input their guess and separates it out into an integer array
	public static int[] userInp(int[] array) {
		Scanner sc = new Scanner(System.in);
		boolean correct = false;
		System.out.println("Input number: ");
		
		while (!correct) {
			ArrayList<Integer> digits = new ArrayList<Integer>();
			correct = true;
			int input = sc.nextInt();
			
			//separates the users input into 4 individual numbers so it can be stored in an array
			while (input > 0) {
				digits.add(input % 10);
				input /= 10;
			}
			if (digits.size() < 4 || digits.size() > 4) {
				correct = false;
			} else {
				//as the digits section turns the number backwards this inputs the numbers into the array in reverse order
				for (int i = digits.size() - 1; i > -1; i--) {
					if (arrayChecker(digits.get(i), array) == true) {
						correct = false;
					} else {
						array[i] = digits.get(i);
					}
				}
			}
			if (correct == false) {
				System.out.println("guess invalid please try again: ");
			}
		}
		return array;
	}
	
	//reutrns the number of bulls and cows to the user
	public static String getBullsCows(int[] guess, int[] secret) {
		String BCs;
		int bulls = 0;
		int cows = 0;
		int found = 0;

		for(int i = 0; i < guess.length; i++) {
			if (arrayChecker(guess[i], secret)) {
				found++;
			}
		}
		//if the guesses numbers have been detected this then determines whether to designate it as a bull or a cow
		if (found > 0) {
			for (int i = 0; i < guess.length; i++) {
				if (guess[i] == secret[i]){
					bulls++;
					found --;
				}
			}
			if (found > 0) {
				cows = found;
			}
		}
		BCs = "bulls " + bulls + ", cows " + cows;
		return BCs;
	}
	
	//a small method i wrote to make searching through the arrays for numbers more efficient
	public static boolean arrayChecker(int inp, int[] array) {
		for(int i = 0; i < array.length; i++) {
			if (inp == array[i]) {
				return true;
			}
		}
		return false;
	}

}
