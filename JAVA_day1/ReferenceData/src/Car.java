public class Car {
    //클래스 생성
    String color;
    int speed;

    //클래스 생성자
    Car(String carColor, int carSpeed){
        color = carColor;
        speed = carSpeed;
    }

    void accelerate(){
        speed += 10;
        System.out.println("가속합니다 현재 속도 : " + speed);
    }
}
