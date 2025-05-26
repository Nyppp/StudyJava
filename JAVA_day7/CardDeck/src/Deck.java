import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    //List<Card> cards 필드
    private List<Card> cards;

    //생성자 (4가지 무늬와 13가지 랭크 조합하여 52개 카드 덱 생성)
    public Deck(){
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    //카드 덱 섞기
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //리스트 0번 인덱스부터 카드 한장 뽑기
    public Card draw(){
        if(cards.size() == 0){
            return null;
        }else{
            return cards.remove(0);
        }
    }

    //남은 카드 갯수 리턴
    public int remainingCards(){
        return cards.size();
    }

    //내부 정적 클래스 Card
    public static class Card{
        //suit, rank 필드
        private String suit;
        private String rank;

        //필드값들을 파라미터로 하는 생성자
        public Card(String suit, String rank){
            this.suit = suit;
            this.rank = rank;
        }

        //toString 오버라이드
        @Override
        public String toString(){
            return rank + " of " + suit;
        }
    }
}
