import java.util.ArrayList;
import java.util.Random;

public class shuffledDeck 
{
	private ArrayList<cards> cards;

	// Creating a special Deck to shuffle the cards
	 shuffledDeck()
	 {
		/* 
		* Creating the array list for the cards and
		* defining the indexes and a temp card value
		*/
		cards = new ArrayList<cards>();
		int index_1, index_2;
		Random generator = new Random();
		cards temp;
		
		// Picking a suit for the card (0-3)
		for (int a = 0; a <= 3; a++)
		{
		    // Picking a value for the card (0-12)
			for (int b = 0; b <= 12; b++)
			 {
			   cards.add(new cards(a,b));
			 }
		}
		
		// Randomly taking 200 pairs of cards and shuffling them around in the deck
		for (int i = 0; i < 200; i++)
		{
			index_1 = generator.nextInt(cards.size() - 1);
			index_2 = generator.nextInt(cards.size() - 1);

			temp = (cards) cards.get(index_2);
			cards.set(index_2 , cards.get(index_1));
			cards.set(index_1, temp);
		}
	 }

	// Drawing the cards from the created deck
	public cards drawFromDeck()
	{	   
		return cards.remove(0);
	}

	// Counting the total number of cards in the deck
	public int getTotalCards()
	{
		return cards.size();
	}
}
