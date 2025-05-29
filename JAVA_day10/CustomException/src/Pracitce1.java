import java.io.*;
import java.util.Scanner;

public class Pracitce1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("관람 할 영화 제목을 입력하세요 : ");
        String title = sc.nextLine();
        System.out.print("나이를 입력해주세요 : ");
        int age = sc.nextInt();

        try {
            checkMovieAccess(title,age);
            System.out.println(title + " 관람 가능합니다.");
        } catch (AgeRestrictionException e) {
            System.out.println(e);
        }finally {
            sc.close();
        }
    }
    public static void checkMovieAccess(String title, int age) throws AgeRestrictionException{
        if(title.equals("Joker") || title.equals("Deadpool")){
            if(age < 18){
                throw new AgeRestrictionException(title);
            }
        }
    }
}


class AgeRestrictionException extends Exception {
    public AgeRestrictionException(String title) {
        super("18세 미만 관람 불가: " + title);
    }
}