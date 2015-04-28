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
	public void playGame()
	{
		while(!(player1.isLoser())&&!(player2.isLoser()))
				{
					Card player1Card = player1.playHand();
					Card player2Card = player2.playHand();
					//If player1 is greater add both cards to p1
					//If player 2 is greater add both cards to p2
					//If equal go into the war method
					if(player1Card.getRank()>player2Card.getRank())
					{
						player1.addUsedCard(player2Card);
						player1.addUsedCard(player1Card);
					}
					else if(player1Card.getRank()<player2Card.getRank())
					{
						player2.addUsedCard(player2Card);
						player2.addUsedCard(player1Card);
					}
					else if(player1Card.getRank()==player2Card.getRank())
					{
						//Add cards to war deck then call the war method
						warDeck.add(player1Card);
						warDeck.add(player2Card);
						boolean war = true;
						while(war)
						{
							war = war();
						}
					}
					
				}
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
	public boolean war()
	{
		//Creates a war deck array list and a boolean war value
		boolean war = false;
		//adds the original cards,next card drawn, and the two after that
		Card p1;
		Card p2;
		p1 = player1.playHand();
		p2 = player2.playHand();
		warDeck.add(p1);
		warDeck.add(p2);
		p1 = player1.playHand();
		p2 = player2.playHand();
		warDeck.add(p1);
		warDeck.add(p2);
		//if player 1's card bigger add the war deck to him
		if(p1.getRank()>p2.getRank())
		{
			for(int i=0;i<warDeck.size();i++)
			{
				player1.addUsedCard(warDeck.get(i));
				warDeck.remove(i);
			}
		}
		//If player 2's is better give war deck to him
		else if(p1.getRank()<p2.getRank())
		{
			for(int i=0;i<warDeck.size();i++)
			{
				player2.addUsedCard(warDeck.get(i));
				warDeck.remove(i);
			}
		}
		//If its another war set war to true, then finally return war
		else
		{
			war = true;
		}
		return(war);
	}
}
