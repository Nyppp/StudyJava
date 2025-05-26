public interface Swimmer {
    public void swim();
    default void hello(){
        System.out.println("hello from swimmer");
    }
}
