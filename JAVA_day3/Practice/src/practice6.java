import java.util.Scanner;

public class practice6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("홀수/짝수/3의 배수 옵션을 하나 골라주세요 : ");
        String numberType = sc.nextLine().trim();

        if(numberType.equals("홀수")){
            System.out.println("홀수만 출력");
            for (int i = 1; i <= 50; i++) {
                if(i % 2 == 0){
                    continue;
                }
                System.out.print(i + " ");
            }
        }else if(numberType.equals("짝수")){
            System.out.println("짝수만 출력");
            for (int i = 1; i <= 50; i++) {
                if(i%2 == 1){
                    continue;
                }
                System.out.print(i + " ");
            }
        }else if(numberType.equals("3의 배수")){
            System.out.println("3의 배수만 출력");
            for (int i = 1; i <= 50; i++) {
                if(i%3 != 0){
                    continue;
                }
                System.out.print(i + " ");
            }
        }else{
            System.out.println("유효한 입력이 아닙니다.");
        }

    }
}
