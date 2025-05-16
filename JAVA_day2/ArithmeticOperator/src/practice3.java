import java.util.Scanner;

public class practice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("나이를 입력해주세요: ");
        int age = sc.nextInt();
        System.out.print("포인트를 입력해주세요: ");
        int point = sc.nextInt();

        if(age <= 12 || point >= 5000){
            System.out.println("할인 대상입니다.");
        } else if(age >= 65){
            System.out.println("100% 할인 대상입니다.");
        } else{
            System.out.println("할인 대상이 아닙니다.");
        }

    }
}
