import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //맵 선언
        Map<String, Integer> scores = new HashMap<>();

        //맵에 원소 추가
        scores.put("Jisoo", 95);
        scores.put("Mina", 88);

        //맵에 대한 반복문 사용법
        for (Map.Entry<String, Integer> entry : scores.entrySet()){
            String name = entry.getKey();
            int score = entry.getValue();
            System.out.println(name + " " + score);
        }
    }
}
