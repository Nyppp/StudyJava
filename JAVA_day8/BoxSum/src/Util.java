import java.util.List;

public class Util {
    public static double calculationTotal(List<Box<? extends Number>> boxes){
        double total = 0.0d;

        for(Box<? extends Number> box : boxes){
            total += box.getElement().doubleValue();
        }

        return total;
    }
}
