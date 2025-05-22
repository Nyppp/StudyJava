public class Rectangle {
    private int width;
    private int height;

    //생성자 체이닝 방식
    //오버로딩 된 여러 생성자가 있을 때, 파라미터를 모두 쓰는 생성자에서만 정의 코드를 넣고
    //그 외 오버로딩 (파라미터를 모두 쓰지않는) 함수에는 this() 를 통해 생성자 > 다른 생성자를 체이닝
    public Rectangle(){
        this(0,0);
    }

    public Rectangle(int width, int height){
        this.height = height;
        this.width = width;
    }

    public void print(){
        System.out.println("너비 : "+width);
        System.out.println("높이 : "+height);
    }
}
