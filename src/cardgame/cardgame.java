package cardgame;
import java.util.ArrayList;
import java.util.Collections;

public class cardgame {

	public static void main(String[] args) {
		ArrayList<Card> deck = new ArrayList<Card>(); // 배열 deck의 각 원소를 카드 하나하나로 지정함
		int number[]= {1, 2,3,4,5,6,7,8,9,10,11,12,13}; //메인메소드와 Card 클래스의 인스턴스 이름이 같아도 되는지?
		String[] shape = {"heart", "spade", "diamond", "clover"}; 
		
		for(int i=0; i<13; i++) {
			for(int j=0; j<shape.length; j++) { //반복문이 진행되면서 계속 같은 객체의 이름을 사용하는 것인가?
				Card card = new Card();
				card.number = number[i]; //다른 클래스의 인스턴스 변수를 호출하려면 마침표를 사용한다(자바는 두 number를 구별한다)
				card.shape=shape[j];
				deck.add(card); 
			}
		}//카드 덱 만들기 (52장의 카드)
		
		Player p1 = new Player(); //p1 객체 
		Player p2 = new Player(); //p2 객체
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
			System.out.println(p1.name +"가 "+ sum1+"점의 점수로 승리했습니다.");	
		}
		else {
			System.out.println(p2.name +"가 "+ sum2+"점의 점수로 승리했습니다.");	
		}
	}
}

class Card{
	public int number;
	public String shape;
}

class Player {
	ArrayList<Card> Pdeck = new ArrayList<Card>(); //Pdeck이 객체 Card 타입을 갖는가? -> 그렇다. 플레이어간 게임시 추가된 카드를 관리할 배열도 필요한데, 이 역시 카드 형태를 지닌다.
	String name;
		
	public void Card_draw(ArrayList<Card> deck) { //카드를 중복으로 뽑을 여지는 없는 것인가? -> deck.remove(0); 을 통해 구현
		Collections.shuffle(deck);//카드 셔플
		Card card = new Card();
		card.number = deck.get(0).number; //객체 주소를 따라가 번호를 조회한다, 이와 다른 셔플 방법은 없는가?
		card.shape=deck.get(0).shape;
		deck.remove(0); // 전체 카드에서 해당 카드 삭제
		Pdeck.add(card); //0번쨰 순서부터 차례대로 카드를 추가한다
	}
}

/* Point: 플레이어가 한장씩 뽑은 카드를 관리하는 Pdeck 배열 선언하기
 * Pdeck,deck 배열 선언시 원소로 Card 객체의 주소값 넣기
 * 
 */






