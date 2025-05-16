public class practice {
    public static void main(String[] args) {
        int myScore = 65;

        boolean isPass = (myScore >= 60) ? true : false;

        if(isPass){
            System.out.println("합격");
        }else{
            System.out.println("불합격");
        }
    }
}
