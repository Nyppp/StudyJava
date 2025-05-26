public class Animal {
    private String name;

    public Animal(String name){
        this.name = name;
    }

    void eat(int amount){
        System.out.println(amount + "만큼 먹었습니다. 배가 부릅니다.");
    }

    void sleep(int hours){
        System.out.println(hours + "시간 만큼 낮잠을 잤습니다. 개운합니다.");
    }
}
