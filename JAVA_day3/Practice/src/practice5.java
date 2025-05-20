import java.util.Scanner;

public class practice5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("1~10 사이 숫자를 입력해주세요 : ");
        int num = sc.nextInt();
        int sum = 0;

        for(int i = 1; i <= 10; i++){
            if(i == num){
                continue;
            }

            sum += i;
        }

        System.out.println(num+"을 제외한 1~10의 합 : " + sum);
    }
}
