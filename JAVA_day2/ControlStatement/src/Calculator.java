import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("두 정수를 입력해주세요(두 정수는 공백으로 구분하며, 0 0을 입력하면 프로그램 종료) : ");
            if(!sc.hasNextInt()){
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                break;
            }
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            if(num1 == 0 && num2 == 0){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.print("연산자 기호를 입력해주세요(사칙연산) : ");
            char operator = sc.next().charAt(0);

            switch (operator){
                case '+':
                    System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                    break;
                case '-':
                    System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                    break;
                case '*':
                    System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                    break;
                case '/':
                    if(num2 == 0 ){
                        System.out.println("0으로는 나눗셈이 불가합니다.");
                        break;
                    }
                    System.out.println(num1 + " / " + num2 + " = " + ((double)num1 / (double)num2));
                    break;
                default:
                    System.out.println("잘못된 기호 입니다.");
                    break;
            }
        }
    }
}
