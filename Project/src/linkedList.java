import java.util.*;

public class linkedList {
	
	public static void main(String[] args) {
		
		String[] things = {"apples", "noobs", "pwnage", "bacon", "goATS"};
		List<String> list1 = new LinkedList<String>();
		
		// Populate list1 with the items in 'things'
		for (String x : things) {
			list1.add(x);
		}
		
		String[] things2 = {"sausage", "bacon", "goats", "harrypotter"};
		List<String> list2 = new LinkedList<String>();
		
		// Populate list2 with the items in 'things2'
		for (String y : things2) {
			list2.add(y);
		}
		
		// Take everything from 'list2' and add it to 'list1'
		list1.addAll(list2);
		list2 = null;
		
		printMe(list1);
		
		// Remove the items in 'list1' from 2-4
		removeStuff(list1, 2,5);
		
		// Print list1 with items 2-4 removed
		printMe(list1);
		
		// Take everything in 'list1' and reverse it
		reverseMe(list1);
	}
	
	// Basic method to go through a list and print it out
	private static void printMe(List<String> list) {
		
		// Loop through the array 'list' and treat each element as 'b'
		for (String b : list) {
			System.out.printf("%s ",  b);
		}
		System.out.println();
	}
	
	// Method to remove items from the list from the int 'from' to the int 'to'
	private static void removeStuff(List<String> list, int from, int to) {
		
		// Take a portion from the list and delete it
		list.subList(from, to).clear();
	}
	
	// Method to find the end point of the list, and reverse the items inside
	private static void reverseMe(List<String> list) {
		
		// Create an iterator to get the end point of the list and begin there
		ListIterator<String> reverse = list.listIterator(list.size());
		
		// While the list has items to loop through, print out the items 1 by 1
		while (reverse.hasPrevious()) {
			System.out.printf("%s ", reverse.previous());
		}
	}
}
