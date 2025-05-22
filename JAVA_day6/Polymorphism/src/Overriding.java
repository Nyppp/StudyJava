class Animal{
    void makeSound(){
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Dog extends Animal {
    @Override
    void makeSound(){
        System.out.println("멍멍!");
    }
}

class Cat extends Animal{
    @Override
    void makeSound() {
        System.out.println("야옹!");
    }
}

public class Overriding {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();

        Animal myCat = new Cat();
        myCat.makeSound();
    }
}
