import java.util.Scanner;

public class upgradePractice5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== 오르미 RPG에 오신 것을 환영합니다. ====");
        System.out.println("==== 플레이어 이름을 입력해주세요. ====");
        System.out.print("플레이어 이름 : ");
        String playerName = sc.nextLine();

        Player player = new Player(playerName);
        Monster monster = new Monster();

        int patternCount = 4;
        int turnCount = 1;

        while(monster.Hp > 0 || player.Hp > 0){
            int behaviourMonster = (int)(Math.random()*patternCount)+1;
            boolean isSkip = false;

            System.out.print(player.name +" 의 턴, 행동을 골라주세요 (1 공격 / 2 방어 / 3 힐 / 4 강타 / 5 도움말) : ");
            int behaviourPlayer = sc.nextInt();
            switch (behaviourPlayer){
                case 1: {
                    System.out.println(playerName + "는(은) 기본 공격을 시전했다!");
                    if (behaviourMonster == 2) {
                        System.out.println("몬스터는 가드를 시전하여 공격을 막았다!");
                        break;
                    }
                    int damage = (int) (Math.random() * 3) + 3;
                    monster.Hp -= damage;
                    System.out.println(damage + "의 데미지를 주었다!, 몬스터 HP : " + monster.Hp);
                    break;
                }
                case 2:
                    System.out.println(playerName + "는(은) 방어를 시전했다!");
                    break;
                case 3:{
                    if(player.Mp < 10){
                        System.out.println("마나가 부족해서 힐 스킬을 사용할 수 없습니다.");
                        isSkip = true;
                        break;
                    }
                    int heal = (int) (Math.random() * 3) + 3;
                    player.Hp += heal;
                    player.Mp -= 10;
                    System.out.println(playerName + "는(은) 힐을 시전했다! 플레이어 HP : " + player.Hp);
                    break;
                }
                case 4: {
                    if(player.Mp < 20){
                        System.out.println("마나가 부족해서 강타 스킬을 사용할 수 없습니다.");
                        isSkip = true;
                        break;
                    }
                    int damage = (int) (Math.random() * 6) + 5;
                    monster.Hp -= damage;
                    player.Mp -= 20;
                    System.out.println(playerName + "는(은) 강타를 시전했다! 몬스터 HP : " + monster.Hp);
                    break;
                }
                case 5:
                    printGameInfo(player, monster);
                    isSkip = true;
                    break;
            }

            if(isSkip){
                continue;
            }

            System.out.println("몬스터의 턴!");
            switch (behaviourMonster){
                case 1: {
                    System.out.println("몬스터는 기본 공격을 시전했다!");
                    if (behaviourPlayer == 2) {
                        System.out.println(player.name+"는(은) 가드를 시전하여 공격을 막았다!");
                        break;
                    }
                    int damage = (int) (Math.random() * 3) + 3;
                    player.Hp -= damage;
                    System.out.println(damage + "의 데미지를 받았다!, 플레이어 HP : " + player.Hp);
                    break;
                }
                case 2:
                    System.out.println("몬스터는 방어를 사용했다!");
                    break;
                case 3:{
                    if(monster.Mp < 10){
                        System.out.println("스킬을 시도했지만 몬스터는 마나가 없다! (몬스터는 턴을 날렸다!)");
                        break;
                    }
                    int heal = (int) (Math.random() * 3) + 3;
                    monster.Hp += heal;
                    monster.Mp -= 10;
                    System.out.println("몬스터는(은) 힐을 시전했다! 몬스터 HP : " + monster.Hp);
                    break;
                }
                case 4: {
                    if (monster.Mp < 20) {
                        System.out.println("스킬을 시도했지만 몬스터는 마나가 없다! (몬스터는 턴을 날렸다!)");
                        break;
                    }
                    int damage = (int) (Math.random() * 6) + 5;
                    player.Hp -= damage;
                    monster.Mp -= 20;
                    System.out.println("몬스터는(은) 강타를 시전했다! 플레이어 HP : " + player.Hp);
                    break;
                }
            }
            System.out.println("====" + turnCount + "턴 종료====");
            System.out.println();

            turnCount++;

            if(player.Hp <= 0){
                System.out.println(player.name + "는(은) 몬스터에게 패배하였다!");
                System.out.println("사용한 턴 수 : " + turnCount);
            }

            if(monster.Hp <= 0){
                System.out.println(player.name + "는(은) 몬스터에게 승리하였다!");
                System.out.println("사용한 턴 수 : " + turnCount);
            }
        }


    }
    public static void printGameInfo(Player player, Monster monster){
        System.out.println("====플레이어 현재 상태====");
        System.out.println("HP : " + player.Hp + "|MP : " + player.Mp);
        System.out.println("====몬스터 현재 상태====");
        System.out.println("HP : " + monster.Hp + "|MP : "+ monster.Mp);
        System.out.println("====스킬 설명====");
        System.out.println("공격 : 3~5의 무작위 데미지를 줍니다");
        System.out.println("방어 : 몬스터의 공격을 1턴 막습니다");
        System.out.println("힐 : mp 10을 소모하여 체력 3~5를 회복합니다.");
        System.out.println("강타 : mp 20을 소모하여 5~10의 무작위 데미지를 줍니다.(방어 무시)");
    }

    public static class Player{
        String name;
        int Hp = 100;
        int Mp = 100;

        Player(String playerName){
            name = playerName;
        }

        Player(){
            name = "anonymous";
        }
    }

    public static class Monster{
        int Hp = 100;
        int Mp = 100;
    }
}


