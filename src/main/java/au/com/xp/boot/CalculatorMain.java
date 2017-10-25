package au.com.xp.boot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import au.com.xp.calculator.Calculator;
import au.com.xp.calculator.exception.InValidOperationException;
import au.com.xp.calculator.exception.InvalidOperandException;
import au.com.xp.calculator.exception.NotImplementedException;

public class CalculatorMain {
	
	public static void main (String args[]) {
		Calculator calculator = new Calculator();
		System.out.println();
		System.out.println();
		System.out.println("Calculator APP - {type 'QQ' to exit}");
	do {
			System.out.println();
			System.out.println();
			System.out.println("Enter expression to calculate.. [Operand Operation Operand]");
		
			Scanner scanner = new Scanner(System.in);
			String expression = scanner.nextLine();
			
			if(expression == null || expression.equals("")) {
				continue;
			} else if (expression.equals("QQ")){
				System.exit(0);
			}
			
			
			
			String [] tokens = expression.split("\\s");
			List<String> params = new ArrayList<String>();
			for (String arg : tokens)
			{
			    if (arg != null && arg.length() > 0)
			    {
			    	params.add(arg);
			    }
			}
			
			try {
				System.out.println(calculator.execute(params));
			} catch (InValidOperationException | NotImplementedException | InvalidOperandException e) {
				System.out.println(e.getMessage());
			} 
		}while (true);
	}

}
