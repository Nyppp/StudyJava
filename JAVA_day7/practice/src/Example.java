//패키지 경로 ./com/expample/cardgame 에 있는 패키지 import
package com.example.cardgame;

//시간값 관련 라이브러리 임포트
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//자바 라이브러리 임포트(util 전체, Collectors 클래스)
import java.util.*;
import java.util.stream.Collectors;

//함수형 인터페이스 Printable 선언
@FunctionalInterface
interface Printable {
    //해당 인터페이스를 포함한 클래스는 모두 print() 함수를 오버라이딩 해야 한다.
    void print();
}

//EmptyDeckExeption 클래스 선언 (RuntimeException 클래스 상속)
class EmptyDeckException extends RuntimeException {
    //String 변수를 파라미터로 하는 생성자 선언, 내부 동작은 상위 클래스의 생성자를 따라간다
    public EmptyDeckException(String msg) {
        super(msg);
    }
}

public class Example {
    //Printable 인터페이스를 따르는 Card 레코드 선언
    public static record Card(String suit, String rank, LocalDateTime createdAt) implements Printable {
        //레코드이기 때문에 필드값들에 대한 모든 초기화, 생성자는 생략
        //2개의 인자가 주어졌을 때에 대해서 생성자 오버로딩
        public Card(String suit, String rank) {
            this(suit, rank, LocalDateTime.now());
        }
        
        //인터페이스 함수 오버라이딩
        @Override
        public void print() {
            //객체 자신을 프린트한다
            //레코드의 경우, 멤버들에 대한 getter, toString 메소드 등이 자동적으로 생성되기에 print에 호환
            System.out.println(this);
        }
    }

    //정적 클래스 Utils 선언
    public static class Utils {
        //Card 클래스 자체에 대한 생성은 Card 클래스에서 진행하고,
        //이를 데이터화 해서 관리하기 위해 List<Card>에 담는 함수 작성
        public static List<Card> createDeck() {
            List<Card> deck = new ArrayList<>();
            String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
            String[] ranks = {
                    "2","3","4","5","6","7","8","9","10",
                    "Jack","Queen","King","Ace"
            };
            //4종류의 문양과 13종류의 숫자 조합으로 카드 생성 후, 리스트에 추가
            for (var s : suits)
                for (var r : ranks)
                    deck.add(new Card(s, r));
            return deck;
        }
        //Collection > suffle 함수 사용해 리스트 요소들 무작위로 섞기
        public static void shuffle(List<Card> deck) {
            Collections.shuffle(deck);
        }
        //카드 우위 비교 함수
        public static void sortByRank(List<Card> deck) {
            //List 라이브러리 내부 sort 함수에 List<Card> 타입에 대한 비교 함수 선언
            //숫자 비교를 최우선으로 > 이후 문양에 대한 비교
            deck.sort(Comparator
                    .comparing(Card::rank)
                    .thenComparing(Card::suit));
        }
        
        //덱에서 카드를 한장 뽑는 함수
        public static Card draw(List<Card> deck) {
            //덱이 비어있는 경우 에러 핸들링 > 컴파일 에러로 넘기지 않고 예외처리 하여, 덱에 카드가 없다는 문자 출력
            if (deck.isEmpty()) throw new EmptyDeckException("Deck is empty!");
            
            //카드가 충분한 경우 0번 인덱스의 카드 반환 후 덱에서 제거(pop)
            return deck.remove(0);
        }
        
        //draw 함수 오버로딩 > 덱에서 몇 장을 뽑을지 파라미터 추가 + 반환 타입은 카드 리스트로 오버로딩
        public static List<Card> draw(List<Card> deck, int count) {
            var hand = new ArrayList<Card>();
            
            //파라미터 int count만큼 카드 draw(한장씩 뽑는 draw 함수 사용해서 메소드 체이닝)
            for (int i = 0; i < count; i++) {
                hand.add(draw(deck));
            }

            //List객체를 반환.
            return hand;
        }
    }

    //정적 추상클래스 Game 클래스 선언 + Game 클래스는 인스턴스 객체로 사용될 수 없음
    public static abstract class Game {
        //해당 클래스를 상속하는 클래스는 아래의 추상함수 start()를 반드시 오버라이드 해야 한다.
        public abstract void start();
        //end 함수의 경우 추상화 된 함수가 아니어서, 오버라이드 하지 않아도 에러 발생하지 않음
        public void end() {
            var time = LocalDateTime.now()
                    .format(DateTimeFormatter.ISO_LOCAL_TIME);
            System.out.println("===== 게임 종료 시각: " + time + " =====");
        }
    }

    //Game 클래스를 상속하는 정적 클래스 CardGame 선언
    public static class CardGame extends Game {
        //CardGame 클래스의 private 필드
        private List<Card> deck;
        private final Example outer;

        //생성자 > 정적 클래스 Utils를 통해 생성자 체이닝
        public CardGame() {
            deck = Utils.createDeck();
            outer = new Example();
        }

        //추상 클래스 Game에서 선언된 추상메서드 start() 오버라이딩
        @Override
        public void start() {
            //전체적인 게임 시작 기능과 초기화 동작을 수행한다
            System.out.println("===== CardGame 시작 =====");
            //카드 덱 섞고, 첫 카드를 뽑는다 > 이 카드는 손패에 넣지 않는다.
            Utils.shuffle(deck);
            Card first = Utils.draw(deck);
            System.out.println("뽑은 첫 카드: " + first);
            
            //이후 다섯장을 추가로 뽑고, 손 패에 넣는다
            Hand hand = outer.new Hand(deck, 5);
            System.out.print("내 손패: ");
            //내 손패의 모든 카드 출력
            hand.showHand();
            //뽑은 카드 중, 하트 카드가 몇개인지 출력
            long hearts = hand.countSuit("Hearts");
            System.out.println("하트 개수: " + hearts);

            //이후 문양별로 카드 갯수를 파악하기 위해 Map 자료형으로 key - value 저장
            //groupingBy함수 통해 문양 - 문양에 맞는 카드 갯수 로 저장되도록
            Map<String, Long> suitCount = hand.getCards().stream()
                    .collect(
                            Collectors.groupingBy(Card::suit, Collectors.counting())
                    );
            //map에 대한 print > key=value
            System.out.println("모양별 개수: " + suitCount);
        }
    }

    //Hand 클래스 선언
    public class Hand {
        //Hand 클래스의 private 필드
        private final List<Card> cards;

        //Hand 클래스의 생성자는 파라미터를 2개로 사용한다. (카드덱, 카드 갯수) > n개만큼 뽑아서 손에 쥔다
        public Hand(List<Card> source, int count) {
            cards = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                cards.add(Utils.draw(source));
            }
        }

        //Hand 클래스 필드의 cards에 대한 getter 함수
        public List<Card> getCards() {
            return List.copyOf(cards);
        }
    
        //내 손패의 카드를 보여주는 함수
        public void showHand() {
            //내부 지역클래스 Formatter 선언
            class Formatter {
                //카드 출력 방식에 대한 간단한 기능 동작
                String format(Card c) {
                    return "[" + c.rank() + " of " + c.suit() + "]";
                }
            }
            //지역 내부클래스 사용해서, 카드를 포맷에 맞게 출력한다.
            Formatter fmt = new Formatter();
            for (var c : cards) {
                System.out.print(fmt.format(c) + " ");
            }
            System.out.println();
        }

        //같은 문양의 카드가 내 패에서 몇개 있는지 반환하는 함수
        //count() 함수의 반환 타입이 long이기 때문에, 데이터 유실 방지를 위해 해당 함수 반환타입도 long으로 선언
        public long countSuit(String suit) {
            //입력받은 파라미터에 대해 일치하는 것의 갯수를 필터링
            return cards.stream()
                    .filter(c -> c.suit().equals(suit))
                    .count();
        }
    }

    public static void main(String[] args) {
        //메인 함수
        //Game 타입을 참조하는, CardGame 객체 game 생성
        Game game = new CardGame();
        
        //게임 시작과 종료 코드 수행 후, 메인함수 종료
        game.start();
        game.end();
    }
}
