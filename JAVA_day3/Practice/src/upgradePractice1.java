import java.util.Scanner;

public class upgradePractice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1~100 중 3의 배수이면서 7의 배수가 아닌 값 찾기");
        for(int i = 1; i <= 100; i++){
            if(i % 3 == 0 && i % 7 != 0){
                System.out.print(i + " ");
            }
        }
    }
}
