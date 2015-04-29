import java.util.Scanner;
import java.util.ArrayList;
public class warGameCW
{
	private Hand player1;
	private Hand player2;
	private ArrayList <Card> warDeck;
	private WarGame game;
	/**
	 * Default war game constructor
	 */
	public warGameCW()
	{
	 game = new WarGame();
	 warDeck = new ArrayList();
	 player1 = game.getPlayer1();
	 player2 = game.getPlayer2();
	}
	/**
	 * Returns the Loser of the game
	 * @return
	 */
	public int playGame()
	{
		Card player1Card = player1.playHand();
		Card player2Card = player2.playHand();	
		int loser;
		while(!(player1Card==null)&&!(player2Card==null))
				{					
					System.out.println("Player 1 card: "+ player1Card.getRank()+" player 2 card: "+ player2Card.getRank());
					if(!(player1Card.getRank()==1)&&!(player1Card.getRank()==1))
					{
					//If player1 is greater add both cards to p1
					//If player 2 is greater add both cards to p2
					//If equal go into the war method
					if(player1Card.getRank()>player2Card.getRank())
					{
						player1.addUsedCard(player2Card);
						player1.addUsedCard(player1Card);
						System.out.println("Player 1 wins this hand!");
					}
					else if(player1Card.getRank()<player2Card.getRank())
					{
						player2.addUsedCard(player2Card);
						player2.addUsedCard(player1Card);
						System.out.println("Player 2 wins this hand!");
					}
					else if(player1Card.getRank()==player2Card.getRank())
					{
						
						//Add cards to war deck then call the war method
						warDeck.add(player1Card);
						warDeck.add(player2Card);
						boolean war = true;
						while(war)
						{
							System.out.println("WAR!!");
							war = war();
						}
					}
					player1Card = player1.playHand();
					player2Card = player2.playHand();
					}
					
				}
		if(player1Card==null)
			loser = 1;
		else
			loser = 2;
		return(loser);
	}
	/**
	 * War method returning true if its a war false if not
	 * @return
	 */
	public boolean war()
	{
		boolean war = false;
		if(player1.isEmpty()||player2.isEmpty())
		{
			return(war);
		}
		
		//Creates a war deck array list and a boolean war value
		//adds the original cards,next card drawn, and the two after that
		Card p1;
		Card p2;
		p1 = player1.playHand();
		p2 = player2.playHand();
		System.out.println("SWAG"+p1.getRank());
		
		warDeck.add(p1);
		warDeck.add(p2);
		p1 = player1.playHand();
		p2 = player2.playHand();
		System.out.println("P1 hand: "+ p1.getRank() + " P2 hand: "+ p2.getRank());
		warDeck.add(p1);
		warDeck.add(p2);
		//if player 1's card bigger add the war deck to him
		if(p1.getRank()>p2.getRank())
		{
			System.out.println("Player 1 won!");
			for(int i=0;i<warDeck.size();i++)
			{
				player1.addUsedCard(warDeck.get(i));
				warDeck.remove(i);
			}
		}
		//If player 2's is better give war deck to him
		else if(p1.getRank()<p2.getRank())
		{
			System.out.println("Player 2 won!");
			for(int i=0;i<warDeck.size();i++)
			{
				player2.addUsedCard(warDeck.get(i));
				warDeck.remove(i);
			}
		}
		//If its another war set war to true, then finally return war
		else
		{
			if(!(p1.getRank()==1)&&!(p1.getRank()==0))
			{
				
			war = true;
			}
		}
		
		
		return(war);
		}
		
	
}
