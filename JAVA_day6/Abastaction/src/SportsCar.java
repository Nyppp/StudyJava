public class SportsCar extends Car{
    @Override
    public void accelerate(){
        System.out.println("스포츠카 가속");
    }

    //상위 클래스에 선언된 추상 메서드는 자식 클래스에서 반드시 구현해야 함
    @Override
    public void start(){
        System.out.println("출발");
    }

    @Override
    public void stop() {
        System.out.println("정지");
    }
}
