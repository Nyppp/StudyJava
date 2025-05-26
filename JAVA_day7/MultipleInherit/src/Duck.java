public class Duck implements Flyer, Swimmer{
    @Override
    public void fly(){
        System.out.println("Duck is flying");
    }

    @Override
    public void swim(){
        System.out.println("Duck is swimming");
    }

    @Override
    public void hello() {
        Flyer.super.hello();
        Swimmer.super.hello();
    }
}
