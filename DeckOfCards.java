import java.util.ArrayList;
import java.util.Random;
public class DeckOfCards
{
	//Array list of cards
	private ArrayList deck = new ArrayList();
	//Default consturctor 
	public DeckOfCards()
	{
		
		Card temp;
		int suitNum = 1;
		//starts at two goes until fourteen repeats for every suit
		for(int i=2; suitNum<5; i++)
		{
			if(i<=14)
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
	public Card getCard(int choice)
	{
		return((Card)deck.get(choice));
	}
	
	public void remove(Card delCard)
	{
		deck.remove(delCard);
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
