
public class genericMethods2 {
	
	public static void main(String[] args) {
		
		// Create an array of intergers and an array of characters
		Integer[] iRay = {1, 2, 3, 4, 5};
		Character[] cRay = {'b', 'u', 'c', 'k', 'y'};
				
		printMe(iRay);
		printMe(cRay);
	}
	
	// Creating a generic Method to handle everything
	
	// Pass in the data type <T> to handle all data types
	public static <T> void printMe(T[] x) {
		
		for (T b : x) {
			System.out.printf("%s ", b);
		}
		
		System.out.println();
	}

}
