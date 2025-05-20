import java.util.Scanner;

public class practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = (int)(Math.random()*100)+1;

        int guess = -1;
        int count = 0;

        while(guess != target){
            System.out.print("숫자를 맞춰보세요 (1~100) 자연수 : ");
            guess = sc.nextInt();

            count++;

            if(guess == target){
                System.out.println(count + "번 만에 맞추셨습니다.");
            }else if( guess > target){
                System.out.println("DOWN");
            }else{
                System.out.println("UP");
            }
        }
    }
}
