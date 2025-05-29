import java.util.regex.*;
public class RegexTest3 {
    public static void main(String[] args) {
        String input = "<div>Content</div>";
        // 최소 매칭 (non-greedy)
        Pattern p = Pattern.compile("<.*?>");
        Matcher m = p.matcher(input);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}