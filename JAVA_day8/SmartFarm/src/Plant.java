//요구사항2. Plant 추상 클래스 선언
//요구사항3. Growable 구현
public abstract class Plant implements Growable {
    private final String name;

    public Plant(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    //식물 객체 출력을 위해 toString 오버라이딩
    @Override
    public String toString(){
        return this.getName();
    }

    @Override
    public void grow() {
        System.out.println(this.getName() + "(식물)에 물을 주었습니다.");
    }
}
