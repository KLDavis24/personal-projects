package primes;



import java.util.Stack;

public class primes // Printing prime numbers in descending order
{
	public static void main(String[] args) 
	{
	    final int LIMIT = 120;
	    int count = 0;

	    Stack<Integer> stack = new Stack<Integer>();
	    
	    // Find prime numbers and keep repeating to 120
	    for (int number = 2; number < LIMIT; number++)

	    if (isPrime(number)) 
	    {
	    	stack.push(number);
		    // Increase the count
	        count++;   
	    }

	    // Print the prime numbers in decreasing order
	    System.out.println("The prime numbers less than 120 are \n");

	    final int NUMBER_PER_LINE = 10;

		while (!stack.empty()) 
		{
			System.out.print(stack.pop() + " ");

			if (stack.size() % NUMBER_PER_LINE == 0)
			{
				 //advance to the new line
				//System.out.println(); 
			}

		}
	}

	public static boolean isPrime(int number) 
	{
	    // Assume the number is prime
	    boolean isPrime = true;

	    for (int divisor = 2; divisor <= number / 2; divisor++) 
	    {
	    	//If true, the number is not prime
	    	if (number % divisor == 0) 
	    	{
	    		// Set isPrime to false, if the number is not prime
	    		isPrime = false;
	    		break;
	    		
	    	}
	    }
		return isPrime;
	}
	
}


	   




