package com.rc.cards;

public class Card {
	
	//properties
	private int suit;
	private int value;
	
	//get & set methods
	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	//constructor (s)
	public Card () {
		
	}
	
	public Card (int value, int suit){
		this.value = value;
		this.suit = suit;
	}
	
	//other methods
	public void display(){
		//display the card
		//System.out.println("value:" + value + ", suit:" + suit);
		
		String c = "" + value;
		
		switch (value) {
		case 1:
			c = "A";
			break;
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			c = "" + value;
			break;
		case 10:
			c = "" + value;
			break;
		case 11:
			c = "J";
			break;
		case 12:
			c = "Q";
			break;
		case 13:
			c = "K";
			break;
		default:
			c = "?";
			break;
		}
		
		if (suit == 1){
			c = c + "H ";
		}else if (suit == 2){
			c = c + "S ";
		}else if (suit == 3){
			c = c + "C ";
		}else if (suit == 4){
			c = c + "D ";
		}else {
			c= c + "?";
		}
		System.out.print(c);
	}
	
	public String toString(){
		//display the card
		//System.out.println("value:" + value + ", suit:" + suit);
		
		String c = "" + value;
		
		switch (value) {
		case 1:
			c = "A";
			break;
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			c = "" + value;
			break;
		case 10:
			c = "" + value;
			break;
		case 11:
			c = "J";
			break;
		case 12:
			c = "Q";
			break;
		case 13:
			c = "K";
			break;
		default:
			c = "?";
			break;
		}
		
		if (suit == 1){
			c = c + "H ";
		}else if (suit == 2){
			c = c + "S ";
		}else if (suit == 3){
			c = c + "C ";
		}else if (suit == 4){
			c = c + "D ";
		}else {
			c= c + "?";
		}
		return c;
	}
	
	public String displayAsImage(){
		//this function return the html to display
		//it as an image on a webpage
		
		String card = this.toString().toLowerCase().trim();
		
		String html = "<img src = 'images/" + card + ".png'>";
		
		return html;
	}
	
	public int compare(Card card){
		//this function compares two cards and returns
		//-1 if card is less than this
		//0 if card is equal to this
		//1 if card is greater than this
		
		if (value < card.value){
			return -1;
		} else if (value == card.value){
			return 0;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
				
		Card card  = new Card(5, 1); //Ace of hearts
		Card card2 = new Card(13,4); //King of diamonds
		Card card3 = new Card(5,4);
		Card card4 = new Card(1,1);
		
		System.out.println((card.compare(card2)));
		System.out.println((card.compare(card3)));
		System.out.println((card.compare(card4)));
		/*
		card.display(); //should display AH
		card2.display(); //should dispaly the KD
		
		System.out.println();
		
		for (int s=1; s<=4; s++){
			for (int v=1; v<=13; v++){
				Card c = new Card(v, s);
				c.display();
			}
			System.out.println();
			
		}*/
		
		//now test some out of bounds conditions
		Card c = new Card(0, 0);
		c.display();

	}


}
