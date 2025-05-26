public class Car {
    private String model;

    public Car(String model){
        this.model = model;
    }

    class Engine {
        void start(){
            System.out.println(model + " 엔진 가동");
        }
    }

    public void startCar(){
        Engine engine = new Engine();
        engine.start();
    }
}
