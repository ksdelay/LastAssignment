import java.util.ArrayList;
public class Hand extends DeckOfCards
{
	//List of used cards
	ArrayList usedCards;
	public Hand()
	{
		//Calls super then make new empty used cards list
		super();
		usedCards = new ArrayList();
	}
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
	//change deck method
	//
	public void clearDeck()
	{
		super.clear();
	}
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
	public boolean isLoser()
	{
		boolean loser = false;
		if(super.getDeck().isEmpty()&&usedCards.isEmpty())
			loser = true;
		return(loser);
	}
	public void addUsedCard(Card newCard)
	{
		usedCards.add(newCard);
	}

}
