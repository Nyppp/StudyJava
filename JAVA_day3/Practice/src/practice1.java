import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int line1 = sc.nextInt();
        int line2 = sc.nextInt();
        int line3 = sc.nextInt();

        if(line1+line2 <= line3 || line2+line3 <= line1 || line1+line3 <= line2){
            System.out.println("삼각형 아님");
            return;
        }

        if(line1 == line2 && line1 == line3){
            System.out.println("정삼각형");
        } else if( line1 == line2 || line2 == line3 || line1 == line3){
            System.out.println("이등변삼각형");
        } else{
            System.out.println("삼각형");
        }

    }
}
