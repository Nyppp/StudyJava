import java.util.*;

public class Practice1 {
    public static void main(String[] args) {
        double lowestTemp = Double.MAX_VALUE;
        String lowestAnimalName = new String();
        int count38dgree = 0;

        Map<String, Double> animals = new HashMap<>();

        animals.put("Milo", 39.2d);
        animals.put("Bella", 38.0d);
        animals.put("Charlie", 37.5d);
        animals.put("Luna", 38.0d);
        animals.put("Max", 40.1d);
        animals.put("Coco", 39.8d);

        System.out.println("[고열 반려동물]");
        for (Map.Entry<String, Double> entry : animals.entrySet()){
            if(entry.getValue() >= 39.0d){
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            if(entry.getValue() < lowestTemp){
                lowestTemp = entry.getValue();
                lowestAnimalName = entry.getKey();
            }

            if(entry.getValue() == 38.0d){
                count38dgree++;
            }
        }

        System.out.println();
        System.out.println("[최저 체온 동물]");
        System.out.println(lowestAnimalName + " : " + animals.get(lowestAnimalName));

        System.out.println();
        System.out.println("[38.0도인 동물 수]");
        System.out.println(count38dgree +"마리");

    }
}
