import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Video> videos = Arrays.asList(
                new Video(100),
                new Video(600),
                new Video(2500),
                new Video(300));


        System.out.println(videos);
        Collections.sort(videos);
        System.out.println(videos);






        List<Person> list = Arrays.asList(
                new Person("Jane", 28),
                new Person("Tom", 22),
                new Person("Alice", 31));

        //컬렉션 정렬
//        Collections.sort(list);
//        System.out.println(list);
        
        //내장함수로 정렬
        list.sort(null); //기본 오름차순 정렬
        System.out.println(list);
        list.sort(Comparator.reverseOrder());
        
        //컴퍼레이터 객체로 생성하고, 람다식으로 정렬 방법 변경하는 방법
        //private 필드인 경우 사용 불가함
        Comparator<Person> byName = Comparator.comparing((Person p) -> p.name).thenComparing((Person p)->p.age);
        list.sort(byName);
        System.out.println(list);


    }
}
