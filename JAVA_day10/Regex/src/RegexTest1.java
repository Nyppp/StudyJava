import java.util.regex.*;
public class RegexTest1 {
    public static void main(String[] args) {
        String[] inputs = {"abcd", "가나다라", "abc", "abcde"};
        //1. 임의의 문자 4개로 이루어진 문자열만 매칭되도록 코드를 작성하세요.
        Pattern p = Pattern.compile("(^.{4}$)");
        for (int i = 0; i < inputs.length; i++) {
            String s = inputs[i];
            System.out.printf("%s → %s%n", s, p.matcher(s).matches() ? "O" : "X");
        }
    }
}