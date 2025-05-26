import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        List<Deck.Card> hand = new ArrayList<>();

        deck.shuffle();

        for (int i = 0; i < 5; i++) {
            hand.add(deck.draw());
        }

        for (int i = 0; i < hand.size(); i++) {
            System.out.println("현재 손에 있는 카드 : " + hand.get(i).toString());
        }

        System.out.println("덱의 남은 카드 갯수 : " + deck.remainingCards());
    }
}
