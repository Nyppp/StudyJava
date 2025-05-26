public class MultiDevice implements Calculator, Printer{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int multiply(int a, int b) {
        return a*b;
    }

    @Override
    public void printTimes(String message, int times) {
        Printer.super.printTimes(message, times);
    }
}
