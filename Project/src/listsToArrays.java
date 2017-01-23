import java.util.*;

public class listsToArrays {
	
	public static void main(String[] args) {
		
		String[] stuff = {"babies", "watermelong", "melons", "fudge"};
		
		// Creating a linked list and converting the 'stuff' array into a list
		LinkedList<String> theList = new LinkedList<String>(Arrays.asList(stuff));
		
		// METHODS THAT ONLY LISTS CAN USE
		//--------------------------------------
		theList.add("pumpkin");
		theList.addFirst("firstThing");
		//--------------------------------------
		
		// Convert the list back to an array
		stuff = theList.toArray(new String[theList.size()]);
		
		// Print out the array with the added items
		for (String x : stuff) {
			System.out.printf("%s ", x);
		}
	}
}
