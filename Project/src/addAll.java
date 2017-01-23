import java.util.*;

public class addAll {
	
	public static void main(String[] args) {
		
		// Create an array to hold String data and convert to a List
		String[] stuff = {"apples", "beef", "corn", "ham"};
		List<String> list1 = Arrays.asList(stuff);
		
		// Create an ArrayList and add elements into it
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("youtube");
		list2.add("google");
		list2.add("digg");
		
		// Print out 'list2'
		for (String x : list2) {
			System.out.printf("%s ", x);
		}
		
		// Take all the elements from 'stuff' and add them to 'list2'
		Collections.addAll(list2, stuff);
		System.out.println();
		
		// Print out the modified 'list2'
		for (String x : list2) {
			System.out.printf("%s ", x);
		}
		System.out.println();
		
		// Check if the item 'digg' appears in 'list2', and prints out the frequency
		System.out.println(Collections.frequency(list2, "digg"));
		
		// Returns true or false if the two lists have items in common
		// (true for no items in common, false for items in common)
		boolean trueOrFalse = Collections.disjoint(list1, list2);
		System.out.println(trueOrFalse);
		
		if (trueOrFalse) {
			System.out.println("These lists do not have anything in common");
		}
		else {
			System.out.println("These lists must have something in common!");
		}
	}

}
