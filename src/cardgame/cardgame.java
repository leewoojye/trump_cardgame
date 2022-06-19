package cardgame;
import java.util.ArrayList;
import java.util.Collections;

public class cardgame {

	public static void main(String[] args) {
		ArrayList<Card> deck = new ArrayList<Card>(); // �迭 deck�� �� ���Ҹ� ī�� �ϳ��ϳ��� ������
		int number[]= {1, 2,3,4,5,6,7,8,9,10,11,12,13}; //���θ޼ҵ�� Card Ŭ������ �ν��Ͻ� �̸��� ���Ƶ� �Ǵ���?
		String[] shape = {"heart", "spade", "diamond", "clover"}; 
		
		for(int i=0; i<13; i++) {
			for(int j=0; j<shape.length; j++) { //�ݺ����� ����Ǹ鼭 ��� ���� ��ü�� �̸��� ����ϴ� ���ΰ�?
				Card card = new Card();
				card.number = number[i]; //�ٸ� Ŭ������ �ν��Ͻ� ������ ȣ���Ϸ��� ��ħǥ�� ����Ѵ�(�ڹٴ� �� number�� �����Ѵ�)
				card.shape=shape[j];
				deck.add(card); 
			}
		}//ī�� �� ����� (52���� ī��)
		
		Player p1 = new Player(); //p1 ��ü 
		Player p2 = new Player(); //p2 ��ü
		p1.name = "A";	
		p2.name = "B";
		
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i=0; i<5; i++) {
			p1.Card_draw(deck);
			p2.Card_draw(deck);
			sum1+=p1.Pdeck.get(i).number;
			sum2+=p2.Pdeck.get(i).number;
		}
			
		if(sum1 > sum2) {
			System.out.println(p1.name +"�� "+ sum1+"���� ������ �¸��߽��ϴ�.");	
		}
		else {
			System.out.println(p2.name +"�� "+ sum2+"���� ������ �¸��߽��ϴ�.");	
		}
	}
}

class Card{
	public int number;
	public String shape;
}

class Player {
	ArrayList<Card> Pdeck = new ArrayList<Card>(); //Pdeck�� ��ü Card Ÿ���� ���°�? -> �׷���. �÷��̾ ���ӽ� �߰��� ī�带 ������ �迭�� �ʿ��ѵ�, �� ���� ī�� ���¸� ���Ѵ�.
	String name;
		
	public void Card_draw(ArrayList<Card> deck) { //ī�带 �ߺ����� ���� ������ ���� ���ΰ�? -> deck.remove(0); �� ���� ����
		Collections.shuffle(deck);//ī�� ����
		Card card = new Card();
		card.number = deck.get(0).number; //��ü �ּҸ� ���� ��ȣ�� ��ȸ�Ѵ�, �̿� �ٸ� ���� ����� ���°�?
		card.shape=deck.get(0).shape;
		deck.remove(0); // ��ü ī�忡�� �ش� ī�� ����
		Pdeck.add(card); //0���� �������� ���ʴ�� ī�带 �߰��Ѵ�
	}
}

/* Point: �÷��̾ ���徿 ���� ī�带 �����ϴ� Pdeck �迭 �����ϱ�
 * Pdeck,deck �迭 ����� ���ҷ� Card ��ü�� �ּҰ� �ֱ�
 * 
 */






