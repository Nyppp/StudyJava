public class Main {
    public static void main(String[] args) {
        MultiDevice device = new MultiDevice();

        System.out.println("3 + 5 = " + device.add(3,5));
        System.out.println("4 * 6 = " + device.multiply(4,6));
        device.printTimes("연습 중입니다.", 3);
    }
}
