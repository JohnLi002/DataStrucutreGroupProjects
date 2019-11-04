package project4Lists;

public class Hand extends Pile{	
	private int NumAces;
	
	public Hand(Card[] cards) {
		setNumAces(0);
		for(Card card : cards) {
			if(card.getRank().equals(Rank.ACE)) {
				NumAces++;
			}
			addCard(card);
		}
	}
	
	public void addCard(Card c) {
		add(c);
	}
	
	public Card[] getHand() {
		Card[] c =  new Card[getNumCards()];
		
		for(int i= 0; i < c.length; i++) {
			c[i] = getFirstNode().getCard(); //takes the first card
			remove(c[i]); //removes said card
		}
		
		for(Card cards: c) { //adds back all cards taken out
			add(cards);
		}
		
		return c;
	}
	
	public int getValue() {
		
		return 0;
	}
	
	public int getValueCard(Card c) {
		Rank r = c.getRank();
		switch (r) {
			case ACE:
				return 1; //ACE can be either 1 or 11, user chooses whether to use one or eleven;
			case TWO:
				return 2;
			case THREE:
				return 3;
			case FOUR:
				return 4;
			case FIVE:
				return 5;
			case SIX:
				return 6;
			case SEVEN:
				return 7;
			case EIGHT:
				return 8;
			case NINE:
				return 9;
			default: //The rank must be either TEN, JACK, KING, or QUEEN who all have the same value;
				return 10;
		}
		
	}

	public int getNumAces() {
		return NumAces;
	}

	public void setNumAces(int numAces) {
		NumAces = numAces;
	}
}
