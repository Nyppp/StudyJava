public class Dog extends Animal{
    private int age;

    public Dog(String name, int age){
        super(name);
        this.age = age;
        System.out.println("자식클래스 생성자 호출");
    }

    @Override
    void eat(int amount) {
        super.eat(amount);
        System.out.println("멍!");
    }
}
