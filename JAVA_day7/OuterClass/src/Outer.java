public class Outer {
    private int outerValue = 10;
    class Inner {
        void printOuter() {
            System.out.println("outerValue = " + outerValue);
        }
    }
    public void createInner(){
        Inner inner = new Inner();
        outerValue = 20;
        inner.printOuter();
    }
}