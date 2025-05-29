import java.util.regex.Pattern;

public class Practice {
    public static void main(String[] args) {
        String[] inputs = {"01012345678", "010123", "01112345678", "023335555","0101234567"};
        //1. 임의의 문자 4개로 이루어진 문자열만 매칭되도록 코드를 작성하세요.
        Pattern p = Pattern.compile("^010(\\d{7}|\\d{8})$");
        for (int i = 0; i < inputs.length; i++) {
            String s = inputs[i];
            System.out.printf("%s → %s%n", s, p.matcher(s).matches() ? "O" : "X");
        }
    }
}
