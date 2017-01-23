import java.util.Scanner;

public class dealer 
{
	public static void main(String[] args)
	{
		// Creating a new deck of cards
		deckOfCards deck = new deckOfCards();
		// Creating a new deck to be shuffled
		shuffledDeck deck2 = new shuffledDeck();
		cards C;

	   /*
	    * While the number of cards in the deck does not equal zero,
	    * draw the cards from the deck in ascending order by suit
	    */
	   while (deck.getTotalCards() != 0)
	   {
		   C = deck.drawFromDeck();
		   System.out.println(C.toString());
	   }
	   
	   // Asking the user if they would like the cards to be shuffled
	   Scanner scanner = new Scanner(System.in);
	   System.out.println("\nDo you want to shuffle the cards?");
	   System.out.println("1. Yes");
	   System.out.println("2. No");
	   
	   // Taking the user's input
	   int choice = scanner.nextInt();
	   
	   // If the user picks 1(yes), the deck will be shuffled without using the shuffle() function
	   if (choice == 1)
	   {
		   while (deck2.getTotalCards() != 0)
		   {
			   C = deck2.drawFromDeck();
			   System.out.println(C.toString());
		   }
	   }
	}
}
