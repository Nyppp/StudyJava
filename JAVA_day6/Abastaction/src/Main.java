public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new SportsCar();
        myCar.accelerate();
        myCar.brake();

        SportsCar mySprotsCar = new SportsCar();
        mySprotsCar.brake();
        mySprotsCar.accelerate();
    }
}
