public class AClass {
    private int instanceVar;

    //static 변수 > 모든 인스턴스가 공유함(스코프가 메소드 영역)
    private static int staticVar;

    public void instanceMethod(){
        instanceVar = 10;
        staticVar = 20;
    }

    public static void staticMethod(){
        staticVar = 30;
    }
    
    public void blockScopeTest(){
        //outerVar > 함수 스코프에 선언되었기에 해당 함수 영역이면 어디든 사용 가능
        int outerVar = 1;
        if(true){
            int innerVar = 2;
            System.out.println(outerVar);
            System.out.println(innerVar);
        }
        //innerVar 또한 if 스코프 내에만 선언된 변수기에, 해당 범위 밖에선 사용 불가

        for (int i = 0; i < 10; i++) {
            //i 또한 루프문 내부에서만 사용 가능
            System.out.println(i);
        }
    }

    //매개변수 스코프 > 해당 함수 내에서만
    public void parameterScope(int a, int b, int c){
        System.out.println(a + b + c);
    }

    public void localVariableTest(){
        //로컬 변수는 다른 메서드, 스코프에서 사용 불가능
        int localVar = 5;
        System.out.println(localVar);
    }

    public void printVar(){
        System.out.println("instanceVar: " + instanceVar);
        System.out.println("staticVar: " + staticVar);
    }
}