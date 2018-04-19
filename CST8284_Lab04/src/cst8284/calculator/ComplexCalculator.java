package cst8284.calculator;

public class ComplexCalculator {
	
	private java.util.Scanner op = new java.util.Scanner(System.in);
	private Complex c;  // stores result of current calculation for use in next calculation
	
	public ComplexCalculator(){	}
	
	
	public ComplexCalculator(Complex c1, Complex c2){
		
		System.out.println("Which math operation do you wish to perform?  Enter +, -, *, /");
		char mathOp = op.nextLine().charAt(0);
		
		switch (mathOp){
		   case '+':
		      c = plus(c1, c2);
		      break;
		   case '-':
			   c = subtract(c1, c2);
				  break;
			  //TODO: Call the subtraction method here
		   case '*':
			   c = multiply(c1, c2);
				  break;
			  //TODO: Call the multiplication method here
		   case '/':
			   c = divide(c1, c2);
				  break;
		      //TODO: Call the division method here
		   default:
			  System.out.println("Unknown operation requested");
		}
		
	}
	
	public Complex plus(Complex c1, Complex c2){
		double real = c1.getReal() + c2.getReal();
		double imag = c1.getImag() + c2.getImag();
		return(c = new Complex(real, imag)); // save the result to this class's Complex number
		
	}

   //TODO Uncomment the following block of code and write code to perform the other three
   // math operations indicated, as outlined in the appendix.  The plus() method above 
   // indicates what your output will look like.
	
	public Complex subtract(Complex c1, Complex c2){
		double real = c1.getReal() - c2.getReal();
		double imag = c1.getImag() - c2.getImag();
		return (c = new Complex(real, imag));
				 
	}
	
	public Complex multiply(Complex c1, Complex c2){
		double real = (c1.getReal() * c2.getReal()) - (c1.getImag() * c2.getImag());
		double imag = (c1.getReal() * c2.getImag()) + (c2.getReal() * c1.getImag()); 
		return (c = new Complex(real, imag));
		
	}
	
	public Complex divide(Complex c1, Complex c2){	
		double real = ((c1.getReal() * c2.getReal()) + (c1.getImag() * c2.getImag())) / ((c2.getReal() * c2.getReal()) + (c2.getImag() * c2.getImag())); 
		double imag = ((c2.getReal() * c1.getImag()) - (c1.getReal() * c2.getImag())) / ((c2.getReal() * c2.getReal()) + (c2.getImag() * c2.getImag()));
		c = new Complex(real, imag);
		if (c2.isZero()) {
			System.out.println("Divide-by-zero error detected");
			return (c = new Complex(0, 0));
		} else {
		return c;
		}
	 //TODO: check for possible division by 0 and output an error message to the screen
	 //return a constructor with value 0 + 0i);
	} 
	
    // If attempting Bonus C, comment out the above divide() method, which must use
	// the calculation given in the Lab 03 document--this must be included for marks--and
	// add a new divide() method here that employs the complex conjugate in the Complex
	// class, as described in the BONUS MARKS section of the Lab 3 document.

	
    //TODO: write the code for getComplexResult() (the header is provided below) that outputs the
	// result of the current calculation i.e. the Complex value c associated with the
	// ComplexCalculator class.  
	public Complex getComplexCalculator(){
		return this.c;
		
	}

	
	//TODO: write the code for toString() (the header is provided below) that outputs the
	// String value of the result of the current calculation i.e. the Complex value c 
	// associated with the ComplexCalculator class, but chain the toString() method of 
	// the Complex class for this purpose.
	public String toString(){
		return c.toString();
	
	}


}
