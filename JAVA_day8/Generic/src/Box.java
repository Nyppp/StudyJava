//제너릭 클래스 정의 > 다이아몬드 연산자<> 포함하여 선언한다
public class Box<T> {
    private T item;

    public T get(){
        return this.item;
    }

    public void set(T item){
        this.item = item;
    }

}
