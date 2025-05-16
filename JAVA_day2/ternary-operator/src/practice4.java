import java.util.Scanner;
import java.util.Random;

public class practice4 {
    public static void main(String[] args) {
        int requireLevel = 20;
        int requireCoin = 500;
        int skipLevel = 30;

        Scanner sc = new Scanner(System.in);
        System.out.println("레벨과 코인, vip 여부를 입력해주세요");
        int playerLevel = sc.nextInt();
        int playerCoin = sc.nextInt();

        boolean isVip = sc.nextBoolean();
        boolean isAble = (playerLevel >= requireLevel)? true : false;

        int weaponLevel = 1;


        if(isAble){
            reinforceWeapon(isVip, playerLevel, playerCoin, weaponLevel);
        }else{
            System.out.println("강화 조건에 맞지 않습니다.");
        }
    }
    
    public static void reinforceWeapon(boolean isVip,int playerLevel, int playerCoin, int weaponLevel){
        Random random = new Random();

        int successRate = isVip? (10 + playerLevel*2) : playerLevel*2;
        playerCoin = ((playerLevel >= 30)? ((isVip)? playerCoin : (playerCoin-300)) : playerCoin-300);

        boolean isSuccess = false;
        int roll = random.nextInt(100) + 1;

        isSuccess = (successRate >= roll)? true : false;

        if(isSuccess){
            System.out.println("강화 성공!");
            System.out.println("플레이어 레벨 : " + (weaponLevel+1));
            System.out.println("플레이어 코인 : " + playerCoin);
        }else{
            System.out.println("강화 실패");
        }
    }
}
