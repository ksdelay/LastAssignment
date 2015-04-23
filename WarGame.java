import java.util.ArrayList;
public class WarGame 
{
	public Hand player1;
	public Hand player2;
	private Hand winner;
	public WarGame()
	{
		player1 = new Hand();
		player2 = new Hand();
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
						boolean war = true;
						while(war)
						{
							war = war(player1Card,player2Card);
						}
					}
					
				}
	}
	public boolean war(Card p1, Card p2)
	{
		//Creates a war deck array list and a boolean war value
		ArrayList warDeck = new ArrayList();
		boolean war = false;
		//adds the original cards,next card drawn, and the two after that
		warDeck.add(p1);
		warDeck.add(p2);
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
				player1.addUsedCard((Card)warDeck.get(i));
			}
		}
		//If player 2's is better give war deck to him
		else if(p1.getRank()<p2.getRank())
		{
			for(int i=0;i<warDeck.size();i++)
			{
				player2.addUsedCard((Card)warDeck.get(i));
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
