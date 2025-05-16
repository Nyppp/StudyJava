public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

//        System.out.println("덧셈: " + (a+b));
//        System.out.println("뺄셈: " +(a-b));
//        System.out.println("곱셈: " + (a*b));
//        System.out.println("나눗셈: " + (a/b));
//        System.out.println("나머지 연산: " + (a%b));

        a++;
        System.out.println(a);
        a--;
        System.out.println(a);
        int c = a++;
        int d = ++a;
        System.out.println(a);
        System.out.println(c);
        System.out.println(d);
    }
}
