public class Main {
    public static void main(String[] args) {
        //언체크드 예외 : 컴파일 시점에서 오류를 강제하지 않는 예외처리
        //주로 런타임 에러들이 여기에 해당함
        
        //NullPointerException
        try{
            //null 레퍼런스에 대한 접근 시도 > 발생
            String str = null;
            System.out.println(str.length());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        //ArrayIndexOutOfBoundsException
        try{
            //배열 인덱스를 초과하여 접근할 때 발생
            int[] nums = {1,2,3};
            System.out.println(nums[5]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        //ArithmeticException
        try {
            //수학적 계산에 의한 오류 > 0으로 나누기 등
            int result = 10 / 0;
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }

        //IllegalAccessException
        try {
            //매개변수에 허용되지 않은 값이 들어올 때 처리
            setAge(-1);
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }
    }

    public static void setAge(int age) throws IllegalAccessException{
        if(age < 0){
            throw new IllegalAccessException("나이는 음수일 수 없습니다.");
        }
    }
}
