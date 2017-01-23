import java.util.*;

public class hashSet {
	
	public static void main(String[] args) {
		
		// Creating an array with at least one duplicate item, and convert the array to a List
		String[] things = {"apple", "bob", "ham", "bob", "bacon"};
		List<String> list = Arrays.asList(things);
		
		System.out.printf("%s ", list);
		System.out.println();
		
		// Converting 'list' into a set, which removes duplicate items
		Set<String> set = new HashSet<String>(list);
		System.out.printf("%s ", set);
	}

}
