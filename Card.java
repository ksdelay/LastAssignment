
public class Card 
{
	//Enum stuff not used right now doe
	public enum Suit
	{
		SPADES,CLUBS,HEARTS,DIAMONDS
	}
	public enum Rank
	{
		ACE, JACK, QUEEN, KING
	}
	
	//Suit and rank containers
	public int rank;
	public String suit;
	
	//Constructor taking two ints
	public Card(int userSuit, int userRank)
	{
		if(userSuit==1)
			suit = "SPADES";
		else if(userSuit==2)
			suit = "CLUBS";
		else if(userSuit ==3)
			suit = "HEARTS";
		else
			suit = "DIAMONDS";
		
		rank = userRank;
	}
	
	//Copy constructor
	public Card(Card og)
	{
		this.rank = og.rank;
		this.suit = og.suit;
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
	public String getSuit()
	{
		return(suit);
	}
	//Setters
	public void setRank(int desRank)
	{
		rank = desRank;
	}
	public void setSuit(String desSuit)
	{
		suit = desSuit;
	}

}