public abstract class Car implements Vehicle {
    @Override
    public void brake(){
        System.out.println("브레이크 작동");
    }

//    @Override
//    public void accelerate(){
//        System.out.println("자동차 가속");
//    }

    //클래스 내에서도 함수 추상화 가능 > 추상 클래스
    //추상 메서드 < > 일반 메서드 같은 시그니처로 존재할 수 없음, 오버로딩하여 구분 필요
    public abstract void accelerate();
    public abstract void start();
    public abstract void stop();
}
