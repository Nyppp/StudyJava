class Shape {
    public void draw(){
        System.out.println("도형을 그립니다.");
    }
}

class Circle extends Shape{
    @Override
    public void draw(){
        super.draw();
        System.out.println("원을 그립니다.");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();

        circle.draw();
    }
}
