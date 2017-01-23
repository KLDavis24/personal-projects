
public class genericReturnTypes {
	
	public static void main(String[] args) {
		
		// Print out the maximum Integer(42)
		System.out.println(max(23, 42, 1));
		
		// Print out the maximum of the first letters of the Strings(t)
		System.out.println(max("apples", "tots", "chicken"));
	}
	
	// Creating a generic Method that returns any generic data type
	
	// Take 3 items and return the maximum
	// Only objects that inherit from the Comparable class can be used in this Method
	public static <T extends Comparable<T>> T max(T a, T b, T c) {
		
		// Start off by assuming 'a' is the maximum
		T m = a;
		
		// If 'b' is greater than 'a', 'b' is the new maximum
		if (b.compareTo(a) > 0) {
			m = b;
		}
		
		// If 'c' is greater than the maximum, 'c' is the new maximum
		if (c.compareTo(m) > 0) {
			m = c;
		}
		
		// Return the maximum
		return m;
	}

}
