public class practice1 {

    public static int getLength(String s){
        return s.length();
    }


    //메소드 오버라이딩 > 같은 이름의 함수를 재정의 (함수 시그니처가 다름)
    public static int sum(int a, int b){
        System.out.println("1번째 함수입니다.");
        return a+b;
    }
    public static double sum(double a, double b){
        System.out.println("2번째 함수입니다.");
        return a+b;
    }
    public static int sum(int a, int b, int c){
        System.out.println("3번째 함수입니다.");
        return a+b+c;
    }

    public static void main(String[] args) {
        System.out.println(getLength("Java"));

    }
}
