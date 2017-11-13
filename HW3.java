import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author TODO: B0544233 ���a�
 * 1.�����w���]�u���@�ƵP�A�M��Q��class Deck�̪�Deck��k�A�����deck(nDeck�a1�i�J)
 * 2.����N �i�氵�@��newCard �A�Q��deck����Class Deck�̪�getOneCard()��k
 * 3.�L�XnewCard
 * 4.�A���ƨB�J2.3�A�y�XnewCard2
 * 5.�̫����shuffle>>�Ѯv�i��Q����shuffle�O�_�����Υi����A�@��U�����P�_
 */

public class HW3 {
	
	public static void main(String[] args) {
		
		int nDeck=1;//1.
		
	
		Deck deck=new Deck(nDeck);
		
		Card newCard=deck.getOneCard();  //2.
		newCard.printCard();   //3.
		Card newCard2=deck.getOneCard();//4.
		newCard2.printCard();//4.
		deck.shuffle();//5.
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			if(!isShuffleWorking(deck,newCard,newCard2)){
				System.out.println("All Card: Well done! But shufller is not working");
			}else{
				System.out.println("Well done!");
			}
			
		}else{
			System.out.println("All Card: Error, please check your sourse code");
		}

	}
	/**
	 * This method is used for checking your result, not a part of your HW3
	 */
	private static boolean isShuffleWorking(Deck deck,Card newCard,Card newCard2){
		deck.shuffle();
		boolean isCorrect=true;
		if(newCard.getSuit().equals(newCard2.getSuit()) &&
				newCard.getRank()==newCard2.getRank()){
					isCorrect=false;
					return isCorrect;
		}
		for(int i=0;i<53;i++){
			deck.getOneCard();
		}
		if(deck.nUsed!=1){
			isCorrect=false;
		}
		return isCorrect;
	}
	
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			Card.Suit suit= card.getSuit();
			int rank = card.getRank();
			if(rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52||checkHash.keySet().size()==50){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
