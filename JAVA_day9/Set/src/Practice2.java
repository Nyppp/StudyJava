import java.util.*;

public class Practice2 {
    public static void main(String[] args) {
        List<String> aClass = Arrays.asList("Coding", "Dance", "Music", "Drama", "Coding");
        List<String> bClass = Arrays.asList("Music", "Art", "Coding", "Cooking", "Dance", "Cooking");

        //전체 동아리
        Set<String> allClass = new HashSet<>();
        allClass.addAll(aClass);
        allClass.addAll(bClass);
        System.out.println("전체 동아리 목록 : "+allClass);

        //공통 동아리
        Set<String> commonClass = new HashSet<>();
        commonClass.addAll(aClass);
        commonClass.retainAll(bClass);
        System.out.println("공통 동아리 : "+ commonClass);

        //A반 전용 동아리
        Set<String> uniqueAClass = new HashSet<>();
        uniqueAClass.addAll(aClass);
        uniqueAClass.removeAll(bClass);
        System.out.println("A반 전용 동아리 : " + uniqueAClass);

        //B반 전용 동아리 제외한 동아리
        Set<String> uniqueBClass = new HashSet<>();
        uniqueBClass.addAll(bClass);
        uniqueBClass.removeAll(aClass);
        allClass.removeAll(uniqueBClass);
        System.out.println("B반 전용 동아리 제외한 동아리 : "+ allClass);
    }
}
