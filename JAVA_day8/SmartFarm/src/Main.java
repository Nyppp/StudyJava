public class Main {
    //요구사항 11 테스트 시나리오 수행
    public static void main(String[] args) {
        //온실 객체 생성
        Greenhouse<Plant> mixHouse = new Greenhouse("혼합");
        Greenhouse<Vegatable> vegatableHouse = new Greenhouse("채소");
        Greenhouse<Fruit> fruitHouse = new Greenhouse("과일");

        //채소, 과일 객체 생성 후 각 용도에 맞는 온실에 추가
        Vegatable lettuce = new Vegatable("상추");
        Vegatable spinach = new Vegatable("시금치");
        Fruit strawberry = new Fruit("딸기");
        Fruit blueberry = new Fruit("블루베리");

        vegatableHouse.add(lettuce);
        vegatableHouse.add(spinach);
        fruitHouse.add(strawberry);
        fruitHouse.add(blueberry);

        //온,습도 조절
        Greenhouse.ClimateController.regulate();
        System.out.println();

        //급수
        Util.waterAll(vegatableHouse);
        System.out.println();
        Util.waterAll(fruitHouse);
        System.out.println();

        //작물 이동
        Util.transferPlants(vegatableHouse, mixHouse);
        Util.transferPlants(fruitHouse, mixHouse);
    }
}
