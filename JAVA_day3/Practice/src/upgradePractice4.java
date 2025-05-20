import java.util.Scanner;

public class upgradePractice4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("도형 넓이 구하기 (원, 삼각형, 사각형을 입력 받아, 길이(반지름,높이,너비)를 입력받고, 그에 따른 넓이 구하기)");
        System.out.print("원 / 삼각형 / 사각형 중, 넓이를 구하고 싶은 것을 입력하세요 : ");
        String shape = sc.nextLine();
        double area = 0;
        switch (shape){
            case "원": {
                System.out.print("반지름을 입력해주세요 : ");
                int radius = sc.nextInt();
                area = radius * radius * Math.PI;
                System.out.println("원의 넓이 " + radius + " * " + radius + " * pi(3.14) = " + area);
                break;
            }
            case "삼각형": {
                System.out.print("높이와 너비를 입력해주세요(공백 구분) : ");
                int height = sc.nextInt();
                int width = sc.nextInt();
                area = (height * width) / 2;
                System.out.println("삼각형의 넓이 " + height + " * " + width + " * 1/2  = " + area);
                break;
            }
            case "사각형": {
                System.out.print("높이와 너비를 입력해주세요(공백 구분) : ");
                int height = sc.nextInt();
                int width = sc.nextInt();
                area = (height * width);
                System.out.println("사각형의 넓이 " + height + " * " + width + " = " + area);
                break;
            }
            default:
                System.out.println("유효한 입력이 아닙니다.");
                break;
        }
    }
}
