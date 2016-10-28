package com.rc.cards;

public class Deck {
	
	// properties / member variables
	private Card[] cards = new Card[52];
	private int currentCard;
	
	
	//get & set methods
	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	
	public int getRemainingCards(){
		return cards.length - currentCard;
	}

	//constructors
	public Deck(){
		//create an instance of each card
		int n = 0;
		for (int s=1; s<=4; s++){
			for (int v=1; v<=13; v++){
				Card c = new Card(v, s);
				cards[n++] = c;
			}
		}
		currentCard = 0;
	}
	
	//other methods
	public void display(){
		for (int i =0; i<cards.length; i++){
			cards[i].display();
			
			if (i == 12 || i == 25 || i == 38 || i == 51) {
				System.out.println();
			}
		} System.out.println();
	}
	
	public Card getCurrentCard(){
		Card card;
		try{
			card = cards[currentCard];
		}catch (ArrayIndexOutOfBoundsException ex) {
			card = null;
		}
		return card;
	}
	
	public Card getNextCard(){
		
		Card card;
		try{
			card = cards[++currentCard];
		} catch(ArrayIndexOutOfBoundsException ex){
			card = null;
		}
		return card;
	}
	
	//didn't end up using this
	public void reset(){
		
		//shuffle deck
		shuffle(10000);
		//reset the currentcard to 0
	}
	
	public void shuffle(int n){
		for (int i =0; i < n; i++){
			int r1 = (int)(Math.random() * 52);
			int r2 = (int)(Math.random() * 52);
			
			//Swap the card
			Card t = cards[r1];
			cards[r1] = cards[r2];
			cards[r2] = t;
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck deck = new Deck();
		
		deck.display();
		deck.shuffle(1);
		
		deck.display();
		deck.shuffle(10);
		
		deck.display();
		deck.shuffle(100);
		
		Card card;
		do {
			card = deck.getNextCard();
			
			if(card != null){
				card.display();
			}
		}while (card != null);
	}
}

