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
	public static String produceAnswer(String input)
	{ 
		// TODO: Implement this function to produce the solution to the input
		String[] array = input.split(" ");
		String firstOperand = array[0];
		String operator = array[1];
		String secondOperand = array[2];
		
		return	}

	// TODO: Fill in the space below with any helper methods that you think you will need
	public static String toImproper(String input) {
		String[] mixednumbersplit = input.split("_");
		String stringWholeNum = mixednumbersplit[0];
		String fraction = mixednumbersplit[1];
		String[] fractionsplit = fraction.split("/");
		String stringNumerator = fractionsplit[0];
		String stringDenominator = fractionsplit[1];
		int wholeNum = Integer.parseInt(stringWholeNum);
		int numerator = Integer.parseInt(stringNumerator);
		int denominator = Integer.parseInt(stringDenominator);
		int answer = wholeNum * denominator;
		answer += numerator;
		Integer.toString(answer); 
		String improperFrac = answer + "/" + denominator;
		return improperFrac;

	}

}
