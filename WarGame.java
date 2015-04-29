import java.util.ArrayList;
/**
 * CS 110 Final Assignment
 * @author Kevin Delay
 * War game class
 */

public class WarGame 
{
	//hands for each player  
	public Hand player1;
	public Hand player2;
	/**
	 * Default constructor for war game 
	 * Makes 2 new hands and a temp deck to call split deck with
	 */
	public WarGame()
	{
		DeckOfCards temp = new DeckOfCards();
		player1 = new Hand();
		player2 = new Hand();
		splitDeck(temp);
	}
	
	/**
	 * splits the two players decks in half
	 * @param deckToSplit the temporary deck thats being split
	 */
	public void splitDeck(DeckOfCards deckToSplit)
	{
		//Clears both players decks
		player1.clearDeck();
		player2.clearDeck();
		//Splits the first half of the deck to the 1st player and the second to player 2
		for(int i=0; i<26;i++)
			{
				player1.add(deckToSplit.getCard(i));
			}
		for(int k = 26;k<52;k++)
		{
			player2.add(deckToSplit.getCard(k));
		}
	}
	/**
	 * Returns the 1st players hand
	 * @return
	 */
	public Hand getPlayer1()
	{
		return(player1);
	}
	/** 
	 * Returns the second players hand
	 * @return
	 */
	public Hand getPlayer2()
	{
		return(player2);
	}
}
