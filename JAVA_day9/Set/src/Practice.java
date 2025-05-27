import java.util.*;

public class Practice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Set<String> set = new LinkedHashSet<>();

        list = Arrays.asList("Jisoo", "Mina", "Jisoo", "Daniel", "Hana", "Mina", "Leo");
        set.addAll(list);

        System.out.println("총 인원: " + set.size());
        System.out.println("Mina 포함 여부: " + set.contains("Mina"));
        System.out.println("참가자 명단:");
        for (String element : set){
            System.out.println(element);
        }
    }
}
