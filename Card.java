
public class Card 
{
	
	//Suit and rank containers
	public int rank;
	public String suit;
	public String cardPic;
	private final String [] suits = {"SPADES","CLUBS","HEARTS","DIAMONDS"};
	//Constructor taking two ints
	/**
	 * Constructor taking in two ints one for suit one for rank and sets the picture accordingly
	 * @param userSuit
	 * @param userRank
	 */
	public Card(int userSuit, int userRank)
	{
		suit = suits[userSuit];
		
		rank = userRank;
		if(rank<=10)
			cardPic = ""+rank;
		else
		{
			if(rank==11)
				cardPic = "jack";
			else if(rank==12)
				cardPic = "queen";
			else if(rank==13)
				cardPic = "king";
			else
				cardPic = "ace";
		}
		if(userSuit==0)
			cardPic+="s.jpg";
		else if(userSuit==1)
			cardPic+="c.jpg";
		else if(userSuit==2)
			cardPic+="h.jpg";
		else
			cardPic+="d.jpg";
		
	}
	
	/**
	 * Copy constructor taking in another card
	 * @param og
	 */
	public Card(Card og)
	{
		this.rank = og.rank;
		this.suit = og.suit;
		this.cardPic = og.cardPic;
	}
	/**
	 * Returns the card pic string
	 * @return
	 */
	public String getCardPic()
	{
		return(cardPic);
	}
	//To string method
	public String toString()
	{
		String temp;
		temp = suit.toLowerCase() + " ";
		if(rank==11)
			temp += "Jack";
		else if(rank==12)
			temp += "Queen";
		else if(rank ==13)
			temp += "King";
		else if(rank == 14)
			temp += "Ace";
		else
			temp +=rank;
		return(temp);		
	}
	
	//Rank getter
	public int getRank()
	{
		return(rank);
		
	}
	/*
	 * Suit Getter
	 */
	public String getSuit()
	{
		return(suit);
	}
	/**
	 * Set rank method
	 * @param desRank
	 */
	public void setRank(int desRank)
	{
		rank = desRank;
	}
	/**
	 * Set suit method
	 * @param desSuit
	 */
	public void setSuit(String desSuit)
	{
		suit = desSuit;
	}

}