public interface Printer {
    default void printTimes(String message, int times){
        for (int i = 0; i < times; i++) {
            System.out.println(message);
        }
    }
}
