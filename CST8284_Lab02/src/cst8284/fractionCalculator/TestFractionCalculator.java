package cst8284.fractionCalculator;

import java.util.Scanner;

public class TestFractionCalculator {

	private Scanner input = new Scanner(System.in);
	private static Fraction f, fResult;

	public static void main(String[] args) {

		TestFractionCalculator tc = new TestFractionCalculator();

		while (true) {

			System.out.println("Enter the first fraction");
			Fraction f1 = tc.enterFraction();

			System.out.println("Enter the second fraction");
			Fraction f2 = tc.enterFraction();

			if ((f1.getDenominator() == 0) || (f2.getDenominator() == 0))
				break;
			else {
				System.out.println("Enter + or - to add or subtract these fractions");
				char mathOp = tc.input.next().charAt(0);
				int num = f1.getNumerator() * f2.getDenominator();
				num += ((mathOp == '-') ? -1 : 1) * f2.getNumerator() * f1.getDenominator();
				int denom = f1.getDenominator() * f2.getDenominator();
				fResult = new Fraction(num, denom);
			}
			
			System.out.println("The result is " + fResult.getNumerator() + "/" + fResult.getDenominator());
		}
		System.out.println("Exiting");
	}

	public static void showMenu() {
		System.out.println("How will this fraction be entered? Select one of the following");
		System.out.println("1. As a single string");
		System.out.println("2. As two separate Strings");
		System.out.println("3. As two separate integers");
		System.out.println("4. Use the last fraction generated");
		System.out.println("Note: Enter a '0' in either denominator to exit");
	}

	public Fraction enterFraction() {

		showMenu();
		int choice = input.nextInt(); // Enter input choice

		switch (choice) {
		
		case 1: // Enter fraction as a single string
			System.out.println("Enter the fraction as a string e.g. in the form 2/3");
			f = new Fraction(input.next());
			break;
			
		case 2: // Enter fraction as two separate Strings
			System.out.println("Enter the numerator");
			String sNum = input.next();
			System.out.println("Enter the denominator");
			String sDenom = input.next();
			f = new Fraction(sNum, sDenom);
			break;
			
		case 3: // Enter fraction as two separate Integers
			System.out.println("Enter the numerator");
			int iNum = input.nextInt();
			System.out.println("Enter the denominator");
			int iDenom = input.nextInt();
			f = new Fraction(iNum, iDenom);
			break;
			
		case 4:  // Enter using last fraction calculated (Caution: could be 0/0 if first calculation)
			f = new Fraction(fResult);
			break;
			
		default: // Possible problem? Sets numerator = 0 and trigger exit
			f = new Fraction();
		}
		return f;
	}
}
