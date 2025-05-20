import java.util.Scanner;

public class practice4 {
    public static void main(String[] args) {
        //숫자야구 게임
        Scanner sc = new Scanner(System.in);
        int numCount = 3;
        boolean isHomeRun = false;
        int count = 0;
        int[] answer = new int[numCount];

        for(int i = 0; i < numCount; i++){
            answer[i] = (int)(Math.random()*9);
            for(int j = 0; j < i; j++){
                while(answer[i] == answer[j]){
                    answer[i] = (int)(Math.random()*9);
                }
            }
        }

        while(!isHomeRun){
            int[] hit = new int[numCount];
            System.out.print("숫자야구 게임, 3자리 숫자를 입력해 랜덤 숫자를 맞춰보세요(공백 구분) : ");
            for (int i = 0; i < numCount; i++) {
                hit[i] = sc.nextInt();
            }

            int ball = 0;
            int strike = 0;

            count++;

            for(int i = 0; i < numCount; i++){
                if(hit[i] == answer[i]){
                    strike++;
                }else{
                    for(int j = 0 ; j < numCount; j++){
                        if(hit[i] == answer[j]){
                            ball++;
                        }
                    }
                }
            }

            if(strike == 3){
                System.out.println("축하합니다! "+count+"번 만에 맞추셨습니다.");
                isHomeRun = true;
            }else{
                System.out.println(strike+"S " + ball+"B");
            }
        }
    }
}
