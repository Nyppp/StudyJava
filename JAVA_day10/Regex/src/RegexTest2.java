import java.util.regex.*;
public class RegexTest2 {
    public static void main(String[] args) {
        String[] inputs = {"Java 8", "Java11", "I love Java"};
        //2.조건: “Java”로 시작하고 그 뒤에는 공백 하나 또는 숫자가 올 수 있도록 매칭 코드를 작성하세요.
        Pattern p = Pattern.compile("^Java(\\s|\\d)+");
        for (int i = 0; i < inputs.length; i++) {
            String s = inputs[i];
            System.out.printf("%s → %s%n", s, p.matcher(s).matches() ? "O" : "X");
        }
    }
}