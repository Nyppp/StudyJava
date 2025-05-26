import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<Integer> boxInteger = new Box<>(10);
        Box<Float> boxFloat = new Box<>(10.0f);
        Box<Double> boxDouble = new Box<>(10.0d);

        List<Box<? extends Number>> boxList = new ArrayList<>();

        boxList.add(boxInteger);
        boxList.add(boxFloat);
        boxList.add(boxDouble);

        System.out.println("총 합계 : " + Util.calculationTotal(boxList));
    }
}
