public class Computer {
    private static String manufacturer = "Dell";
    private String model;

    public Computer(String model){
        this.model = model;
    }

    static class Specs{
        void printManufacturer(){
            System.out.println("Manufacturer : " + manufacturer);
        }

        void printModel(){
            //정적 내부클래스는 외부 클래스의 인스턴스 멤버 접근 불가능
            //System.out.println("Model : " + model);
        }
    }

    public void showSpecs(){
        Specs specs = new Specs();
        specs.printManufacturer();
    }
}
