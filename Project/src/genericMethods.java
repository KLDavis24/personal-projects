
public class genericMethods {
	
	public static void main(String[] args) {
		
		// Create an array of intergers and an array of characters
		Integer[] iRay = {1, 2, 3, 4};
		Character[] cRay = {'b', 'u', 'c', 'y'};
		
		printMe(iRay);
		printMe(cRay);
		
	}
	
	// Overloading Methods to work the the Integer and the Character arrays
	
	public static void printMe(Integer[] i) {
		
		// Loop through the Integer array and print the items one by one
		for (Integer x : i) {
			System.out.printf("%s ", x);
		}
		
		System.out.println();
	}
	
public static void printMe(Character[] i) {
		
		// Loop through the Character array and print the items one by one
		for (Character x : i) {
			System.out.printf("%s ", x);
		}
		
		System.out.println();
	}

}
