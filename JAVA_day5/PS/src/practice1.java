import java.util.Scanner;

public class practice1 {
    public static void dragonBattle(int[] dragons, int playerDamage){
        for (int i = 0; i < dragons.length; i++) {
            if(dragons[i] >= playerDamage){
                System.out.println("패배했습니다... "+(i+1)+"번째 드래곤에게 졌습니다.");
                return;
            }else{
                playerDamage += dragons[i] / 2;
            }
        }

        System.out.println("축하합니다! 마을이 구원되었습니다. 최종 공격력 : "+ playerDamage);
    }

    public static void main(String[] args) {
        int[] dragons = {5,10,3};

        Scanner sc = new Scanner(System.in);
        System.out.print("플레이어 데미지를 입력해주세요 : ");
        int myDamage = sc.nextInt();
        dragonBattle(dragons, myDamage);
    }
}
