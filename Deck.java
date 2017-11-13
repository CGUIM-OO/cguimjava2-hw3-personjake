import java.util.ArrayList;
import java.util.Random;
/**
 * Description:
 * 1.Deck��k���إߤ@��ArrayList-cards�MusedCard �e�̰��s�@�Ʃҭn��J��arrayList,��̩�getoneCard�᪺�P
 * 2.int nUsed�@���p��ⱼ�F�X�i�P
 * 3.
 */
public class Deck {
	private ArrayList<Card> cards;
	public ArrayList<Card> usedCard ;
	public int nUsed;

	//Deck��k�� ����� cards�MusedCard�A����i��T��for�j��A
	//�Ĥ@�h�����X�ƵP����X��(nDeck)
	//�ĤG�h��enhanced for loop�NCard �̭���suit���ȦL�X��(Club, Diamand, Heart, Spade)
	//�ĤT�h��1-13(rank)
	//  �j��\�ର �Q��Class Card �����card�A�i�JClass Card �̪�Card �褧��N����ƫ᪺card��JArraylist-cards
	// �̫�A�I�sshuffle��k
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		usedCard = new ArrayList<Card>();
		
		for (int deck = 1; deck <= nDeck; deck++) {
		for (Card.Suit s : Card.Suit.values()) {
			for (int rank = 1; rank <= 13; rank++) {
				Card card = new Card(s, rank);
				cards.add(card);
			}
		}
		shuffle();
	}}

	
	//����k�|���b�����@�~�Ψ�A���LprintDeck��k�O�N Arraylist-cards �Q�� Enhanced for Loop �L�X�Ȩ� (Class Card�̭���printCard)
	public void printDeck() {

		for (Card allcards : cards) {
			allcards.printCard();
		}

	}
	
     //����k�|���b�����@�~�Ψ�A��getAllCards��k���^�� Arraylist-cards
	public ArrayList<Card> getAllCards() {
		return cards;
	}

	//1.getOneCard��k�O ���]�@�� a ��ɭ� �n��J �qArraylist cards�̩��
	//2. �p�G���cards(ArrayList)�O�Ū��A�N�|������shuffle����k�A�A���� ���cards���Ĥ@�i�P�A��J�@���ܼ�a�A�ñN���ƥ�JusedCard�̡A�ò���cards���Ĥ@�i�P�AuseCard++���ܰ���L�@��
	//3. �Y���O�Ū��N�|����:���cards���Ĥ@�i�P�A��J�@���ܼ�a�A�ñN���ƥ�JusedCard�̡A�ò���cards���Ĥ@�i�P�AuseCard++���ܰ���L�@��
	//�̫� �^��a �ȡA�^�Ǹ�ƫ��A��Card
	public Card getOneCard() {
		Card a = null;
		if (cards.isEmpty()) {
			shuffle();
			a = cards.get(0);
			usedCard.add(a);
			cards.remove(0);
			nUsed++;

		} else {
			a = cards.get(0);
			usedCard.add(a);
			cards.remove(0);
			nUsed++;
		}
		return a;

	}

	//������ƶüƲ��ͤ�k�A�ñNusedCard-ArrayList�̪��d�����[�Jcards-ArrayList��
	//���@��for�j�� �q0�}�l����cards-ArrayList���d��e(0<=i<cards.size())
	//�j�餺�e:  Card �@���ܼ�a���Ӷ��Ǫ���i�ӡA�A�]�@�ӼȦs�ܼ�temp��a; �b�Q�� rnd.nextInt(cards.size())��j�]��0<=i<cards.size()���ơA
	//			Card �@���ܼ�b ���bcards �̲�j����m�A  �̫�N��i�Ӧ�m���쬰b�F��j��m���N���Ȧs���(�����i�Ӧ�m���d)
	//  �̫�M���Ҧ��busedCard-ArrayList�̪��d,�NnUsed���m��0
	public void shuffle() {

		Random rnd = new Random();
		cards.addAll(usedCard);
		for (int i = 0; i < cards.size(); i++) {
			Card a = cards.get(i);
			Card temp = a;

			int j = rnd.nextInt(cards.size());
			Card b = cards.get(j);

			cards.set(i, b);
			cards.set(j, temp);

		}
		usedCard.clear();
		nUsed = 0;
	}

}