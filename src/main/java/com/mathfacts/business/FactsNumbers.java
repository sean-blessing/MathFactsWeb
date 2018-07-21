package com.mathfacts.business;

public class FactsNumbers {
	private int number1;
	private int number2;
	
	public FactsNumbers() {
		
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	
	/**
	 * generateFactsNumbers will generate a new instance
	 * of this class w/ 2 random numbers.  The #s will need
	 * to adhere to a few generation rules based on the 
	 * operation to be performed:
	 * - For subtraction, number1 must be >= number2
	 * - For division, the quotient must be a whole number
	 *   so the quotient can be a max of 100 and the
	 *   result of numerator % denominator must be zero. 
	 * @return
	 */
	public static FactsNumbers generateFactsNumbers(Operation opr) {
		FactsNumbers fn = new FactsNumbers();
		
		int number1 = getRandomNbr(10);
		int number2 = getRandomNbr(10);
		if (opr.getOperationSymbol().equals("-")) {
			// ensure number 1 >= number2
			if (number2 > number1) {
				int hold = number1;
				number1 = number2;
				number2 = hold;
			}
		}
		else if (opr.getOperationSymbol().equals("/")) {
			// ensure the quotient is a whole number???
			int remainder = 1;
			while (remainder!=0) {
				number1 = getRandomNbr(100);
				// ensure number 1 >= number2
				if (number2 > number1) {
					int hold = number1;
					number1 = number2;
					number2 = hold;
				}
				remainder = number1 % number2;
			}
		}
		fn.setNumber1(number1);
		fn.setNumber2(number2);
		return fn;
	}
	
	/*
	 * Get a random # between 1 and n
	 */
	private static int getRandomNbr(int n) {
		int a = (int)(Math.random()*n)+1;
		return a;
	}
}
