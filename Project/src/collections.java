import java.util.*;

public class collections {
	
	public static void main(String[] args) {
		// Create an array of strings
		String[] things = {"eggs", "lasers", "hats", "pie"};
		List<String> list1 = new ArrayList<String>();
		
		// Add array items to list
		for (String x: things) {
			list1.add(x);
		}
		
		// Create another array of strings
		String[] moreThings = {"lasers", "hats"};
		List<String> list2 = new ArrayList<String>();
		
		// Add array items to list
		for (String y: moreThings) {
			list2.add(y);
		}
		
		// Print the contents of list1
		for (int i = 0; i < list1.size(); i++) {
			System.out.printf("%s ",  list1.get(i));
		}
		
		// Call the method to edit list1
		editList(list1, list2);
		System.out.println();
		
		// Print the contents of the edited list1
		for (int i = 0; i < list1.size(); i++) {
			System.out.printf("%s ",  list1.get(i));
		}
		
	}
	
	// Creating the method to edit the lists
	public static void editList(Collection<String> l1, Collection<String> l2) {
		Iterator<String> it = l1.iterator();
		
		// Looping through the list item by item
		while (it.hasNext()) {
			// If the item is in list2, remove it from list1
			if (l2.contains(it.next())) {
				it.remove();
			}
		}
	}
}
