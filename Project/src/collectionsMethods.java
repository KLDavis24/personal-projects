import java.util.*;

public class collectionsMethods {
	
	public static void main(String[] args) {
		
		String[] crap = {"apples", "lemons", "geese", "bacon", "youtube"};
		List<String> list = Arrays.asList(crap);
		
		// Sort the array in alphabetical order
		Collections.sort(list);
		System.out.printf("%s\n", list);
		
		// Sort the array in reverse order
		Collections.sort(list, Collections.reverseOrder());
		System.out.printf("%s\n", list);
	}
}
