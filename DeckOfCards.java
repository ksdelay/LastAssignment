import java.util.ArrayList;
/**
 * Deck of cards class creating a 52 card deck
 * Kevin Delay
 * CS 110
 */
import java.util.Random;
public class DeckOfCards
{
	//Array list of cards
	private ArrayList deck = new ArrayList();
	/**
	 * Default  constructor creating a 52 cards deck 
	 */
	public DeckOfCards()
	{
		
		Card temp;
		int suitNum = 0;
		//starts at two goes until fourteen repeats for every suit
		for(int i=2; suitNum<4; i++)
		{
			if(i<=14 && i!=1)
			{
				temp = new Card(suitNum,i);
				deck.add(temp);
			}
			else
			{
				suitNum++;
				i=1;
			}
		}
		shuffle();
	}
	/**
	 * Shuffles the deck into a random order void method
	 */
	public void shuffle()
	{
		Random rand = new Random();
		//i is one less than the size of array object goes unitl equaling 0
		for ( int i = deck.size()-1; i > 0; i-- ) 
		{
            int newInd = (rand.nextInt(i+1));
            Card temp = (Card)deck.get(i);
            deck.set(i, deck.get(newInd));
            deck.set(newInd, deck.get(i));
        }
	}
	/**
	 * Clears the deck
	 */
	public void clear()
	{
		deck.clear();
	}
	/**
	 * gets the card based on the index
	 * @param choice the index of desired card
	 * @return the card desired
	 */
	public Card getCard(int choice)
	{
		return((Card)deck.get(choice));
	}
	/**
	 * Void method removing from an index given by user
	 * @param delInd
	 */
	public void remove(int delInd)
	{
		deck.remove(delInd);
	}
	public void add(Card newCard)
	{
		deck.add(newCard);
	}
	public ArrayList getDeck()
	{
		return(deck);
	}

}
