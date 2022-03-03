package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class CalcEng {

	public static void main(String[] args) {
		
		double[] leftVals = {100.0d,25.0d,225.0d,11.0d};
		double[] rightVals = {50.0d,92.0d,17.0d,3.0d};
		char[] opcodes = {'d','a','s','m'} ;
		double[] results = new double[opcodes.length] ;
		
		if(args.length == 0)
		{
		
			for(int i = 0 ;i < opcodes.length ; i++)
		{
		    results[i] = execute(opcodes[i],leftVals[i],rightVals[i]) ;
		}
		
			for(double d : results)
		{
		   
			System.out.println(d);
		}
			
	    }
		else if(args.length == 1 && args[0].equals("interactive"))
		{
			executeInteractively();
		}
		
		else if(args.length == 3)
		{
			handleCommandlineArguments(args) ;
		}
		
		else
		{
			System.out.println("Please provide an operation code and two numeric values ");
		}
			
	}
	
	private static void executeInteractively() {
		
		System.out.println("Enter an operation and two operations ");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine() ;
		String[] parts = userInput.split(" ");
    	performOperations(parts);
		scanner.close();
	}
	
	private static void performOperations(String[] parts) {
		
		 char opCode = opCodeFromString(parts[0]);
		 if(opCode=='w')
		 {
			 handleWhen(parts);
		 }
		 else {
		 double leftVal = valueFromWord(parts[1]);
		 double rightVal = valueFromWord(parts[2]) ;
		 double result = execute(opCode,leftVal,rightVal);
	//	 System.out.println(result);
		 displayResult(opCode,leftVal,rightVal,result);
		 }
	}
        /* Shows Date */
	private static void handleWhen(String[] parts) {
	
		LocalDate startDate = LocalDate.parse(parts[1]);
		long daysToAdd = (long)valueFromWord(parts[2]);
		LocalDate newDate = startDate.plusDays(daysToAdd) ;
		String output = String.format("%s plus %d is %s",startDate,daysToAdd,newDate) ;
		System.out.println(output);
		
	}

	private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
		
		char symbol = symbolFromOpCode(opCode) ;
//		StringBuilder builder = new StringBuilder(20);
//		builder.append(leftVal);
//		builder.append(" ");
//		builder.append(symbol);
//		builder.append(" ");
//		builder.append(rightVal);
//		builder.append(" = ");
//		builder.append(result);
//		String output = builder.toString();
		
		String output = String.format("%.3f %c %.3f = %.3f",leftVal,symbol,rightVal,result) ;
		System.out.println(output);
		
	}

	private static char symbolFromOpCode(char opCode) {
	
		char[] opCodes = {'a','s','m','d'} ;
		char[] symbols = {'+','-','*','/'} ;
		char symbol = ' ';
		
		for(int index = 0 ; index < opCodes.length;index++)
		{
			if(opCode == opCodes[index])
			{
				symbol = symbols[index] ;
				break ;
			}
		}
		
		return symbol ;
		
	}
    private static void handleCommandlineArguments(String[] args) {
		
		 char opCode = args[0].charAt(0);
		 double leftVal = Double.parseDouble(args[1]);
		 double rightVal = Double.parseDouble(args[2]);
		 double result = execute(opCode,leftVal,rightVal);
		 
		 System.out.println(result);
		 
		
	}



	private static double execute(char opcode,double leftVal,double rightVal)
	{
		double result ;
		switch(opcode)
		{
		case 'a' :
			result = leftVal + rightVal;
		    break;
		 
		case 's' :
			result = leftVal - rightVal ;
			break ;
			
		case 'm' :
			result = leftVal * rightVal ;
			break;
			
		case 'd' :
			result = rightVal != 0 ? leftVal/rightVal : 0.0d ;
			break;
		
			default:
				System.out.println("Invalid opcode : "+opcode);
				result = 0.0d ;
				break;
		}
		
		return result;
	}
	
	private static char opCodeFromString(String operationName)
	{
		char opCode = operationName.charAt(0);
		
		return opCode ;
	}
	private static double valueFromWord(String word)
	{
		String[] numbers = {"zero","one","two","three","four",
				             "five","six","seven","eight","nine" } ;
		
		double value = -1d ;
		
		for(int index = 0 ; index < numbers.length ;index++)
		{
			if(word.equals(numbers[index]))
			{
				value = index ;
				break;
			}
		}
		if(value == -1d)
			value = Double.parseDouble(word);
		
		return value ;
	}
}
