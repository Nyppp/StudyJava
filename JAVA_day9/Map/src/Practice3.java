import java.util.*;

public class Practice3 {
    public static void main(String[] args) {
        //0. 데이터 세팅
        List<String> books = Arrays.asList("클린 코드", "자바의 정석", "이펙티브 자바", "클린 코드", "토비의 스프링", "자바의 정석", "자바는 이렇게");

        Set<String> authors = new LinkedHashSet<>();
        List<String> authorsList = Arrays.asList("로버트 마틴", "조슈아 블로크", "백기선", "로버트 마틴", "김작가", "David", "Zett");
        authors.addAll(authorsList);

        Map<String, Integer> bookStars = new HashMap<>();
        bookStars.put("클린 코드", 5);
        bookStars.put("자바의 정석", 4);
        bookStars.put("이펙티브 자바", 5);
        bookStars.put("토비의 스프링", 3);
        bookStars.put("자바는 이렇게", 5);

        //1. 회원이 실제로 읽은 책만 출력 + 중복 제거
        Set<String> uniqueBooks = new HashSet<>();
        uniqueBooks.addAll(books);
        System.out.println("[회원들이 읽은 책 목록]");
        System.out.println(uniqueBooks);
        System.out.println();

        //2. 별점 5점만 출력하기
        System.out.println("[별점 5점인 책 목록]");
        for(Map.Entry<String, Integer> entry : bookStars.entrySet()){
            if(entry.getValue() == 5){
                System.out.println("★★★★★ "+ entry.getKey());
            }
        }
        System.out.println();
        
        //3. 전체 별점 평균 계산
        int sum = 0;
        double avg = 0;
        for(int score : bookStars.values()){
            sum += score;
        }
        avg = (double)(sum) / (double)bookStars.size();
        String avgString = String.format("%.2f", avg);
        System.out.println("[전체 별점 평균 : " + avgString + "점]");
        System.out.println();

        //4. 책 제목 중 자바가 들어간 책만 출력
        System.out.println("[\"자바\"가 제목에 포함된 책 목록]");
        for(String str : books){
            if(str.indexOf("자바") >= 0){
                System.out.println(str);
            }
        }
        System.out.println();

        //5. 좋아하는 작가 목록을 가나다 순 정렬
        Collections.sort(authorsList);
        authors.clear();
        authors.addAll(authorsList);
        System.out.println("[회원들이 좋아하는 작가 목록]");
        System.out.println(authors);
    }
}
