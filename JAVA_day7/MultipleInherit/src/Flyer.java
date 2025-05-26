public interface Flyer {
    public void fly();
    default void hello(){
        System.out.println("hello from flyer");
    }
}
