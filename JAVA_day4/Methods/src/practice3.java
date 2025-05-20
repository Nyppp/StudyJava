import java.io.IOException;
import java.util.Scanner;

public class practice3 {
    public static boolean isPalindrome(String str){
        String strLower = str.toLowerCase().replaceAll("[.,: ?]", "");
        for(int i = 0; i < strLower.length(); i++){
            int reverseIdx = strLower.length()-1-i;
            if(strLower.charAt(i)!= strLower.charAt(reverseIdx)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력해주세요: ");
        String str = sc.nextLine();

        System.out.println(str + "는 팰린드롬인가? :" +isPalindrome(str));
    }
}