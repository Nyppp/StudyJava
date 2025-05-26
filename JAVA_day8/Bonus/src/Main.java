public class Main {
    public static void main(String[] args) {
        Employee manager = new Manager("노윤표", 5000, 2000);

        System.out.println(manager.getSalary());
    }
}
