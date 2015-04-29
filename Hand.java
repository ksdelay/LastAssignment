import java.util.ArrayList;
/**
 * Hand class extending deck of cards
 * @author Kevin Delay
 *
 */
public class Hand extends DeckOfCards
{
	//List of used cards
	ArrayList usedCards;
	/*
	 * Defauklt constructor creating a deck an initializing the used cards array list
	 */
	public Hand()
	{
		//Calls super then make new empty used cards list
		super();
		usedCards = new ArrayList();
	}
	/**
	 * Play hand tests if its a loser then if not returns the next card and moves it to used Cards
	 * @return card on top of the deck
	 */
	public Card playHand()
	{
		//If the deck is empty recylce the used cards
		if(isLoser())
			return(null);
		else if(super.getDeck().isEmpty())
		{
			recycleCards();
		}
		//Temp is the current card adds it to used card then removes it from the deck 
		//Returns the rank of card
		Card temp = super.getCard(0);
		super.remove(0);
		return(temp);
		
	}
	//Clear deck method
	//
	public void clearDeck()
	{
		super.clear();
	}
	/**
	 * Void method recylce cards shuffles the sed cards back into the deck
	 */
	public void recycleCards()
	{
		
		//for each used card add it then at the end shuffle 
		for(int i=0;i<usedCards.size();i++)
		{
			super.add((Card)usedCards.get(i));
			usedCards.remove(i);
		}
		super.shuffle();
	}
	/**
	 * Is empty returns true if its empty false if not
	 * @return
	 */
	public boolean isEmpty()
	{
		//if the deck is empty return true 
		boolean empty = false;
		if(super.getDeck().isEmpty())
		{
			empty = true;
		}
		return empty;
	}
	/**
	 * Tests if the hand is out of used cards and normal cards
	 * @return
	 */
	public boolean isLoser()
	{
		boolean loser = false;
		if(super.getDeck().isEmpty()&&usedCards.isEmpty())
			loser = true;
		return(loser);
	}
	/**
	 * Void method adding cards to the used card list
	 * @param newCard the card to be added
	 */
	public void addUsedCard(Card newCard)
	{
		usedCards.add(newCard);
	}

}
