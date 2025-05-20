import java.util.Scanner;

public class upgradePractice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("미로찾기 ( 지정한 순서로 문을 열경우 통과, 실패시 처음으로)");
        System.out.print("미로찾기 단계를 입력해주세요(n회 입력 > n회만큼 문을 통과) : ");
        int stageCount = sc.nextInt();
        int doorCount = 3;
        int currentStage = 1;
        int count = 0;

        int[] targetDoor = new int[stageCount];
        for(int i = 0 ; i < stageCount; i++){
            targetDoor[i] = (int)(Math.random()*doorCount)+1;
        }

        while(stageCount >= currentStage){
            System.out.println("현재 스테이지 : " +currentStage);
            System.out.print("1~3번 문 중에서, 어느 문을 들어가시겠습니까? : ");
            int selectedDoor = sc.nextInt();

            count++;

            if(selectedDoor == targetDoor[currentStage-1]){
                if(currentStage == stageCount){
                    System.out.println("모든 미로를 통과했습니다 축하합니다! (" + count+"회 시도하셨습니다.)");
                    break;
                }else {
                    System.out.println(currentStage + "스테이지를 통과하셨습니다. 다음 스테이지로 진행합니다.");
                }
                currentStage++;
            }else{
                System.out.println("미로 찾기에 실패했습니다. 처음으로 돌아갑니다");
                currentStage = 1;
            }
        }
    }
}
