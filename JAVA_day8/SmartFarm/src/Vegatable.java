//요구사항4. 구체 서브클래스
public class Vegatable extends Plant{
    public Vegatable(String name){
        super(name);
    }

    //요구사항5 grow 오버라이드
    @Override
    public void grow() {
        System.out.println(this.getName() + "(채소)에 물을 주었습니다.");
    }


}
