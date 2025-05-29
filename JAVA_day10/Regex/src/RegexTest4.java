import java.util.regex.*;
public class RegexTest4 {
    public static void main(String[] args) {
        String input = "Wow! This_is_fun! Ok!";
        // 여기에 패턴을 작성하세요
        Pattern p = Pattern.compile("\\w+!");
        Matcher m = p.matcher(input);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}