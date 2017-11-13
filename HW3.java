import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author TODO: B0544233 陳冠蓁
 * 1.此為預先設只有一副牌，然後利用class Deck裡的Deck方法，實體化deck(nDeck帶1進入)
 * 2.之後就 進行做一個newCard ，利用deck執行Class Deck裡的getOneCard()方法
 * 3.印出newCard
 * 4.再重複步驟2.3，造出newCard2
 * 5.最後執行shuffle>>老師可能想測試shuffle是否有做及可執行，作更下面的判斷
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
