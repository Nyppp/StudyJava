import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListMethodExample {
    public static void main(String[] args) {
        //List, LinkedList도 사용법은 동일함

        //연결리스트와 타 리스트의 메모리 차이
        //연결리스트 : 메모리 배치 불연속적, 다음 / 이전 노드의 메모리 주소를 가지고있어서 탐색은 느리지만 추가/제거 빠름
        //리스트 : 메모리 배치 연속적, 탐색은 빠르지만 추가/제거는 느림

        //리스트 선언
        List<String> list = new ArrayList<>();
        
        //리스트 원소 추가
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        System.out.println(list);

        //리스트 특정 인덱스에 원소 추가
        list.add(2, "orange");
        System.out.println(list);

        //특정 인덱스의 원소 반환
        System.out.println(list.get(2));

        //특정 인덱스 원소 교체
        list.set(2, "blueberry");
        System.out.println(list);

        //특정 인덱스 원소 제거
        list.remove(3);
        System.out.println(list);
        
        //특정 원소가 리스트에 존재하는지 여부 반환
        System.out.println(list.contains("apple"));

        //리스트 사이즈 반환(원소 갯수)
        System.out.println(list.size());

        //리스트가 비어있는지 여부 반환
        System.out.println(list.isEmpty());
        
        //리스트 내 모든 원소 제거 + 초기화
        list.clear();
        System.out.println(list);
    }
}
