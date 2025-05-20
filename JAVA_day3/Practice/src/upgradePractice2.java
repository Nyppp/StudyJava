import java.util.Scanner;

public class upgradePractice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 두개를 입력 받아서 그 사이의 합 구하기");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int sum = 0;
        for (int i = num1; i <= num2 ; i++) {
            sum += i;
        }

        System.out.println(num1+"과"+num2+"사이의 합 : " + sum);
    }
}
