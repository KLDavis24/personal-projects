package numbers;

import java.util.Stack;

public class numbers 
{
	public static void main(String[]args)
	{
		final int limit = 100;
		int count = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int number = 2; number < limit; number++)
		
		if(isPrime(number))
		{
			stack.push(number);
			count++;
		}
		
		System.out.println("The prime numbers less than 120 are \n");

	    final int NUMBER_PER_LINE = 10;
	    
	    while (!stack.empty()) 
		{
			System.out.print(stack.pop() + " ");
		}
	}
	
	public static boolean isPrime(int number)
	{
		boolean isPrime = true;
		
		for(int divisor = 2; divisor <= number / 2; divisor++)
		{
			if(number % divisor == 0)
			{
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
