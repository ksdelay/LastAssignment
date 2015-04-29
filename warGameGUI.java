import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class warGameGUI extends JFrame
{
	  private WarGame game; // the guts
	   private JPanel player1Panel,player2Panel, gamePanel;  // break up regions
	   private JButton playHand;    // grid of buttons
	   private JLabel lastWinner,player1Deck,player2Deck,player1Current,player2Current;  // game status
	   private JLabel title;   // static title
	   private Hand player1,player2;
	   private ArrayList <Card> warDeck;
	   // build the GUI
	   /**
	    * Default constructor for the gui implementation initializing every thing
	    */
	   public warGameGUI()
	   {
		   setLayout(new GridLayout(3,2));
		   game = new WarGame();
		   player1Panel = new JPanel();
		   player1Panel.setBackground(Color.BLUE);
		   gamePanel = new JPanel();
		   gamePanel.setBackground(Color.BLUE);
		   player2Panel = new JPanel();
		   player2Panel.setBackground(Color.BLUE);
		   lastWinner = new JLabel("Last winner was player: ");
		   player1Deck = new JLabel();
		   ImageIcon temp = new ImageIcon("back.jpg");
		   player1Deck.setIcon(temp);
		   player2Deck = new JLabel();
		   player2Deck.setIcon(temp);
		   player1Current = new JLabel();
		   player2Current = new JLabel();
		   title = new JLabel("A Game of War!");
		   playHand = new JButton();
		   playHand.addActionListener(new ButtonListener());
		   playHand.setText("Play Hand");
		   player1Panel.add(player1Deck);
		   player1Panel.add(player1Current);
		   gamePanel.add(playHand);
		   gamePanel.add(lastWinner);
		   player2Panel.add(player2Deck);
		   player2Panel.add(player2Current);
		   add(player1Panel);
		   add(gamePanel);
		   add(player2Panel);
		   player1 = game.getPlayer1();
		   player2 = game.getPlayer2();
		   warDeck = new ArrayList();
	   }
	   /** 
	    * Button listener class
	    * @author Kevin
	    *
	    */
	   private class ButtonListener implements ActionListener
	   {
		   public void actionPerformed(ActionEvent e)
		   {
			   int winner;
			   Card player1Card = player1.playHand();
			   Card player2Card = player2.playHand();
			   ImageIcon temp = new ImageIcon(player1Card.getCardPic());
			   player1Current.setIcon(temp);
			   temp = new ImageIcon(player2Card.getCardPic());
			   player2Current.setIcon(temp);
			   //Sets the card pics and gets the hand
			   //If player 1 and player 2 haven't lost yet
			   if(!(player1Card==null)&&!(player2Card==null))
			   {
				   //If player 1 wins
				   if(player1Card.getRank()>=player2Card.getRank())
				   {
					   lastWinner.setText("Player 1 won!");
					   player1.addUsedCard(player2Card);
						player1.addUsedCard(player1Card);
				   }
				   // If player 2 wins
				   else if(player2Card.getRank()>=player1Card.getRank())
				   {
					   player2.addUsedCard(player2Card);
						player2.addUsedCard(player1Card);
						lastWinner.setText("Player 2 Won!");
				   }
				   //If war
				   else
				   {
					   boolean war = true;
					   warDeck.add(player2Card);
					   warDeck.add(player1Card);
					   while(war)
					   {
						  war = war();
						  
					   }
				   }
			   }
			   //Tests if player 1 or player 2 lsot
			   else if(player1Card==null)
			   {
				   lastWinner.setText("Player 1 wins the game!");
				   disableAll();
			   }
			   else
			   {
				   lastWinner.setText("Player 2 wins the game!");
				   disableAll();
			   }
			   
		   }
		   
	   }
	   /**
	    * War returns true if theres another war and false if not
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
			warDeck.add(p1);
			warDeck.add(p2);
			p1 = player1.playHand();
			p2 = player2.playHand();
			ImageIcon temp = new ImageIcon(p1.getCardPic());
			player1Current.setIcon(temp);
			temp = new ImageIcon(p2.getCardPic());
			player2Current.setIcon(temp);
			warDeck.add(p1);
			warDeck.add(p2);
			//if player 1's card bigger add the war deck to him
			if(p1.getRank()>p2.getRank())
			{
				lastWinner.setText("Player 1 won the war!!");
				for(int i=0;i<warDeck.size();i++)
				{
					player1.addUsedCard(warDeck.get(i));
					warDeck.remove(i);
				}
			}
			//If player 2's is better give war deck to him
			else if(p1.getRank()<p2.getRank())
			{
				lastWinner.setText("Player 2 won the war!!");
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
		public void disableAll()
		{
			playHand.setEnabled(false);
		}
}
