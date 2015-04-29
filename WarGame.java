import java.util.ArrayList;
public class WarGame 
{
	//each player has a hand with 52 cards and an empty used deck, 
	//Need to have 26 cards each doe
	
	public Hand player1;
	public Hand player2;
	private Hand winner;
	private ArrayList<Card> warDeck = new ArrayList();
	public WarGame()
	{
		DeckOfCards temp = new DeckOfCards();
		player1 = new Hand();
		player2 = new Hand();
		splitDeck(temp);
	}

	public void splitDeck(DeckOfCards deckToSplit)
	{
		player1.clearDeck();
		player2.clearDeck();
		for(int i=0; i<26;i++)
			{
				player1.add(deckToSplit.getCard(i));
			}
		for(int k = 26;k<52;k++)
		{
			player2.add(deckToSplit.getCard(k));
		}
	}
	public Hand getPlayer1()
	{
		return(player1);
	}
	public Hand getPlayer2()
	{
		return(player2);
	}
}
