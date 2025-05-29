import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나눗셈을 할 수식을 입력해주세요 (예시 : 5 / 2) : ");
        String input = sc.nextLine();

        try {
            double result = divideNums(input);
            System.out.println("나눗셈 결과 : " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
            System.out.println("연산을 종료합니다.");
        }

    }

    public static double divideNums(String line) throws IllegalArgumentException, ArithmeticException{
        String[] parts = line.split(" ");
        if(parts.length != 3 || !parts[1].equals("/")){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        try {
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[2]);

            if(num2 == 0){
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }

            double result = (double) num1 / (double) num2;
            return result;
        }catch (NumberFormatException e){
            throw new NumberFormatException("잘못된 입력입니다.");
        }
    }
}
