
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
						war();
					}
					
				}
	}
	public Card war()
	{
		Card winner;
		
		return(winner);
	}

}
