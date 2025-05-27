import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Set 선언, 보통 HashSet 객체로 생성
        Set<String> set = new HashSet<>();

        //원소 추가
        set.add("apple");
        set.add("banana");
        System.out.println(set);

        //일반 리스트 생성
        List<String> list = Arrays.asList("banana", "apple", "cherry");
        System.out.println(list);

        //set에 리스트 전체를 추가 > 중복된 원소는 추가되지 않는다.
        set.addAll(list);
        System.out.println("add all 결과: "+set);
    }
}
