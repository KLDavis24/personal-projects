import java.util.*;

public class reverseAndCopyMethods {
	
	public static void main(String[] args) {
		
		// Create an array and convert it to a list
		Character[] ray = {'p', 'w', 'n'};
		List<Character> list = Arrays.asList(ray);
		
		System.out.println("List is : ");
		output(list);
		
		// Reverse and print out the list
		Collections.reverse(list);
		System.out.println("After reverse : ");
		output(list);
		
		// Create a new array and a new list
		Character[] newRay = new Character[3];
		List<Character> listCopy = Arrays.asList(newRay);
		
		// Copy the contents of 'list' into 'listCopy'
		Collections.copy(listCopy, list);
		System.out.println("Copy of list: ");
		output(listCopy);
		
		// Fill the collection with the argument 'X'
		Collections.fill(list, 'X');
		System.out.println("After filling the list: ");
		output(list);
	}
	
	// Output method
	private static void output(List<Character> theList) {
		
		// Loop though whatever list you pass into it, and treat each element as 'thing'
		for (Character thing: theList) {
			System.out.printf("%s ", thing);
		}
		
		System.out.println();	
	}

}
