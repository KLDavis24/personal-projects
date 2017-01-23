public class cards 
{
	// Defining the values for rank and suit of the cards
	private int rank, suit;

	// Placing the suits and card rankings into separate arrays
	private static String[] suits = { "Hearts", "Spades", "Diamonds", "Clubs" };
	private static String[] ranks  = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };

	// Every card will be assigned a suit and a rank
	cards(int suit, int rank)
	{
		this.rank=rank;
		this.suit=suit;
	}

	// Overriding String to print out the rank and suit of the card
	public @Override String toString()
	{
		return ranks[rank] + " of " + suits[suit];
	}

	// Returns the rank of the current card
	public int getRank() 
	{
		return rank;
	}

	// Returns the suit of the current card
	public int getSuit() 
	{
		return suit;
	}
}
