public class practice2 {

    public static int getSum(int a, int b){
        return a + b;
    }

    public static int getBigger(int a, int b){
        if(a >= b){
            return a;
        }else{
            return b;
        }
    }


    public static void main(String[] args) {
        System.out.println("5477, 32125 두 수의 합 : " + getSum(5477, 32125));

        System.out.println("150과 140중 더 큰 수는 : " + getBigger(150,140));
    }
}
