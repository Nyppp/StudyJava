public class Main {
    public static void main(String[] args) {
        //inner 클래스 사용법
        Outer outer = new Outer();

        //직접 inner 클래스를 초기화 하여 inner 클래스의 함수를 사용하거나,
        Outer.Inner inner = outer.new Inner();
        inner.printOuter();

        //outer 클래스에서 inner 클래스에 대한 접근 함수를 작성하여 사용
        outer.createInner();

        //응용 예시
        Car car = new Car("KIA");
        Car.Engine engine = car.new Engine();
        engine.start();

        car.startCar();

        Computer.Specs specs1 = new Computer.Specs();
        specs1.printManufacturer();

        Computer computer = new Computer("XPS 15");
        computer.showSpecs();
    }
}