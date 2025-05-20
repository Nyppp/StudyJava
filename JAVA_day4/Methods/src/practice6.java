import java.util.Scanner;

public class practice6 {
    //추상 메서드 사용하는 인터페이스 선언
    @FunctionalInterface
    interface Calculator{
        int calc(int a, int b);
    }

    //전역함수 통해 인터페이스 내부의 함수 사용하겠다 선언
    public static int applyOperation(int a, int b, Calculator op){
        return op.calc(a, b);
    }

    public static void main(String[] args) {
        //위에 선언한 전역함수를 람다식으로 오버라이딩
        Calculator addtion = (a,b) -> a+b;
        Calculator subtraction = (a,b) -> a-b;
        Calculator multiplication = (a,b) -> a*b;
        Calculator division = (a,b) -> {
            if (b != 0) {
                return a/b;
            } else {
                return 0;
            }
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("두 개의 정수를 입력하세요 : ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("덧셈 : " + applyOperation(a, b, addtion));
        System.out.println("뺄셈 : " + applyOperation(a, b, subtraction));
        System.out.println("곱셈 : " + applyOperation(a, b, multiplication));
        System.out.println("나눗셈 : " + applyOperation(a, b, division));

    }
}
