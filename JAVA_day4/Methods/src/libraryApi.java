import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.lang.Math;

public class libraryApi {
    public static void main(String[] args) {
        String s = "Hello";

        //문자열 길이 출력 메소드
        System.out.println(s.length());

        //문자열 자르기 메소드
        s = "JavaLibrary";
        System.out.println(s.substring(4, 11));

        //해당하는 문자가 위치한 인덱스 가져오기
        s = "apple, banana, cherry";
        System.out.println(s.indexOf("banana")); //banana 문자가 위치한 시작 위치 = 7
        System.out.println(s.indexOf('b')); //char를 인자로 넣어도 동작 > indexOf는 오버로딩 함수
        System.out.println(s.indexOf("peer")); //없는 경우 > -1 출력


        //ArrayList 선업, 추가, 출력 방법
        //ArrayList > 자료형 / List > 인터페이스 (ArrayList를 객체로 사용)
        List<String> list = new ArrayList<>();
        list.add("ABC");
        list.add("BCD");
        list.add("DEF");
        System.out.println(list.get(1));

        //remove > 인덱스 , 객체 직접 접근
        list.remove(0);
        list.remove("DEF");

        System.out.println(list);
        System.out.println(list.size());

        int[] arr = {5,2,8,1};
        Arrays.sort(arr);
        //루프로 직접 출력
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        //toString 메소드로 출력
        System.out.println(Arrays.toString(arr));

        //요소들을 리스트로 변환 asList
        List<String> listString = Arrays.asList("A", "B", "C");
        System.out.println(listString);


        //Math 내장함수 > max 함수(최대값 구하기) , min 함수(최소값 구하기)
        System.out.println(Math.max(3,7));
        System.out.println(Math.min(3,7));
        //random 함수 > 리턴값 0 ~ 1 사이 > 원하는 수 만큼 *하면 그 수에 맞춰 리턴.
        System.out.println(Math.random() * 100);


        //시간 관련 라이브러리
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Seoul")));
        System.out.println(Instant.now());

        LocalTime nowTime = LocalTime.now();
        //메소드 중첩 적용 > 앞의 동작이 먼저 수행된다
        LocalTime laterTime = nowTime.plusHours(5).plusMinutes(30);
        System.out.println(laterTime);
    }
}
