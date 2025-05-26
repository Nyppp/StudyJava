public class Main {
    public static void main(String[] args) {
        AClass scopeTest = new AClass();
        AClass anotherTest = new AClass();

        scopeTest.printVar();
        scopeTest.instanceMethod();
        scopeTest.printVar();
        System.out.println("---------------------");
        anotherTest.printVar();

    }
}
