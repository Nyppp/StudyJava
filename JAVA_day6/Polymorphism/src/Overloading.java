class MathUtil{
    //메소드 오버로딩
    //함수 명은 같지만 리턴 타입이나 매개변수(시그니처)를 달리 하여 같은 이름의 메서드를 여러개 생성하는 방법
    int add(int a, int b){
        return a+b;
    }

    double add(double a, double b){
        return a+b;
    }

    int add(int a, int b, int c){
        return a+b+c;
    }
}

public class Overloading{
    public static void main(String[] args) {
        MathUtil math = new MathUtil();
        System.out.println(math.add(2,3));
        System.out.println(math.add(2.5,3.1));
        System.out.println(math.add(2,3,10));
    }
}