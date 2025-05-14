import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        //배열 선언 후 초기화
//        int[] numbers;
//        //numbers = new int[5];
//        numbers = new int[] {10,20,30,40,50};
//
//        //배열 선언과 동시에 초기화
//        int[] numbers2 = {10,20,30,40,50};
//
//        System.out.println(numbers);
//        System.out.println(numbers2);
//
//        System.out.println(Arrays.toString(numbers));
//
//
//        //다차원 배열
//        int[][] matrix = {
//                {1,2,3},
//                {4,5,6}
//        };
//
//        System.out.println(Arrays.deepToString(matrix));


//        //클래스 사용
//        Car myCar = new Car("blue", 50);
//        myCar.accelerate();
//
//        System.out.println("Car Color : " + myCar.color);
//        System.out.println("Car Speed : " + myCar.speed);

//        Bird bird = new Bird();
//        Airplane airplane = new Airplane();
//
//        bird.fly();
//        airplane.fly();

        Person person = new Person();
        person.printPersonInfo();
        person.fly();
        person.calcAge(3000);

        Person nohPerson = new Person("노윤표", 27, "Male", 980216);
        nohPerson.printPersonInfo();
        nohPerson.fly();
        nohPerson.calcAge(2030);
    }
}
