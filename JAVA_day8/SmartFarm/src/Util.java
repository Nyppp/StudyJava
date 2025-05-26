//요구사항9, 10 와일드카드 메서드 1,2
public class Util <P extends Plant>{
    //온실에 급수 함수
    public static <P extends Plant> void waterAll(Greenhouse<? extends P> greenhouse){
        for (P plant : greenhouse.getPlants()){
            plant.grow();
        }
    }

    public static <P extends Plant> void transferPlants(Greenhouse<P> src, Greenhouse<? super P> dest){
        while(src.getPlants().isEmpty() != true){
            dest.add(src.getPlants().remove(0));
        }

        if(src.getPlants().isEmpty()){
            System.out.println(dest.getHouseName() + " 온실 식물 : " + dest.getPlants().toString());
            System.out.println(src.getHouseName() + " 온실 비어 있음? " + src.getPlants().isEmpty());
        }
    }
}
