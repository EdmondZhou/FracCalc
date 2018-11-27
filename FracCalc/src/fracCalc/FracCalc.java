package fracCalc;
import java.util.*;
public class FracCalc {

	public static void main(String[] args) 
	{	
		Scanner userInput = new Scanner(System.in);
		boolean test=false;
		while (test == false) {
			System.out.println("Please enter values you want calculated.");
			String input = userInput.nextLine();
			System.out.println(produceAnswer(input));
			System.out.println("Type quit if you want to end.");
			if (userInput.nextLine() == "quit") {
				test = true;
			}
			// TODO: Read the input from the user and call produceAnswer with an equation
		}
		userInput.close();

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
	//      e.g. input ==> "1/2 + 3/4"
	//        
	// The function should return the result of the fraction after it has been calculated
	//      e.g. return ==> "1_1/4"
	public static String produceAnswer(String input){ 
		// TODO: Implement this function to produce the solution to the input
		String[] array = input.split(" ");
		String firstOperand = array[0];
		String operator = array[1];
		String secondOperand = array[2];
		firstOperand = toImproperFracString(firstOperand);
		secondOperand = toImproperFracString(secondOperand);
		String[] firstOpSplit = firstOperand.split("/");
		String[] secondOpSplit = secondOperand.split("/");
		String firstNumer = firstOpSplit[0];
		String firstDenom = firstOpSplit[1];
		String secondNumer = secondOpSplit[0];
		String secondDenom =secondOpSplit[1];
		int firstNumerator = Integer.parseInt(firstNumer);
		int firstDenominator = Integer.parseInt(firstDenom);
		int secondNumerator = Integer.parseInt(secondNumer);
		int secondDenominator = Integer.parseInt(secondDenom);
		int commonDenominator = firstDenominator * secondDenominator;
		firstNumerator *= secondDenominator;
		secondNumerator *= firstDenominator;
		if (operator.equals("+")) {
			if(secondNumerator < 0 && firstNumerator >= 0) {
				firstNumerator -= secondNumerator;
			}
			if(secondNumerator >= 0 && firstNumerator >=0 || secondNumerator < 0 && firstNumerator < 0 || firstNumerator < 0 && secondNumerator >0){
				firstNumerator += secondNumerator;
			}
		}
		if (operator.equals("-")) {
			if(secondNumerator < 0 && firstNumerator >= 0) {
				firstNumerator += secondNumerator;
			}
			if(secondNumerator >= 0 && firstNumerator >=0 || secondNumerator < 0 && firstNumerator < 0 || firstNumerator < 0 && secondNumerator >0) {
				firstNumerator -= secondNumerator;
			}
		}
		if (operator.equals("*")) {
			firstNumerator *= secondNumerator;
			commonDenominator *= commonDenominator;
		}
		if (operator.equals("/")) {
			firstNumerator *= commonDenominator;
			commonDenominator *= secondNumerator;
		}
		return (firstNumerator + "/" + commonDenominator);
	}

	// TODO: Fill in the space below with any helper methods that you think you will need
	public static String toImproperFracString(String input) {
		int numerator = 0;
		int denominator = 1;
		int wholeNum = 0;
		int improperNumerator = 0;
		String[] mixednumbersplit = input.split("_");
		String stringWholeNum = mixednumbersplit[0];
		if(mixednumbersplit.length == 2) {
			String fraction = mixednumbersplit[1];
			String[] fractionsplit = fraction.split("/");
			String stringNumerator = fractionsplit[0];
			String stringDenominator = fractionsplit[1];
			wholeNum = Integer.parseInt(stringWholeNum);
			numerator = Integer.parseInt(stringNumerator);
			denominator = Integer.parseInt(stringDenominator);
			if(wholeNum < 0) {
				improperNumerator = wholeNum*denominator - numerator;
			}
			if(wholeNum >= 0) {
				improperNumerator = wholeNum * denominator + numerator;
			}
			return (improperNumerator + "/" + denominator);
		}
		else {
			String fraction = mixednumbersplit[0];
			String[] fractionsplit = fraction.split("/");
			if (fractionsplit.length == 2){
				String stringNumerator = fractionsplit[0];
				String stringDenominator = fractionsplit[1];
				numerator = Integer.parseInt(stringNumerator);
				denominator = Integer.parseInt(stringDenominator);
				improperNumerator = numerator;
				return (improperNumerator + "/" + denominator);
			}
			if(fractionsplit.length == 1) {
				wholeNum= Integer.parseInt(stringWholeNum);
				return (Integer.toString(wholeNum) + "/" + denominator);
			}
		}
		return ("error");
	}

}