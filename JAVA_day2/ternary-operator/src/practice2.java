public class practice2 {
    public static void main(String[] args) {
        int myNum = 10;

        boolean isEven = (myNum % 2 == 0) ? true : false;

        if(isEven){
            System.out.println("짝수");
        }else{
            System.out.println("홀수");
        }
    }
}
