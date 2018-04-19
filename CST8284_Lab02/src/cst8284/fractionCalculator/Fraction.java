package cst8284.fractionCalculator;

public class Fraction {
	
	private int numerator;
	private int denominator;
	
	public Fraction(){            // no-arg constructor
		setNumerator(0); 
		setDenominator(1);
	}
	
	public Fraction(Fraction f){  //copy constructor
		this(f.getNumerator(), f.getDenominator());
	}
	
	public Fraction (String sFraction){ // String input constructor
		this(sFraction.split("/")[0], sFraction.split("/")[1]);
	}
	
	public Fraction(String sNum, String sDenom){ // Double string constructor
		this(Integer.parseInt(sNum), Integer.parseInt(sDenom));
	}
	  
	public Fraction(int iNum, int iDenom){  // two int constructor
		setNumerator(iNum);
		setDenominator(iDenom);
	}
	
	public int getNumerator(){return numerator;}
	public void setNumerator(int n){numerator = n;}
	
	public int getDenominator(){return denominator;}
	public void setDenominator(int d){
		denominator = d;
	}

}
