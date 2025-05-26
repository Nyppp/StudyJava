import java.util.ArrayList;
import java.util.List;

//요구사항6 제너릭 서브클래스
public class Greenhouse <T extends Plant>{
    private String houseName; //온실 용도를 알기 위해 스트링 추가
    
    //요구사항7 필드에 리스트 객체 및 add, getplant 메서드 추가
    private List<T> plants;

    public Greenhouse(String name){
        this.houseName = name;
        plants = new ArrayList<>();
    }

    public void add(T plant){
        this.plants.add(plant);
    }

    public String getHouseName(){
        return this.houseName;
    }

    public List<T> getPlants(){
        return this.plants;
    }

    //요구사항8. 내부 중첩 클래스 선언
    public static class ClimateController{
        static void regulate(){
            System.out.println("온실 온/습도 조절");
        }
    }
}