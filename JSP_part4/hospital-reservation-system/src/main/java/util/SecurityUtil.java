package util;

public class SecurityUtil {
    public static String maskTelString(String s){
        String[] input = s.split("-");
        input[1] = input[1].replaceAll(".", "*");

        String replacedString = "";
        for (int i = 0; i < input.length; i++) {
            replacedString += input[i] + "-";
        }

        replacedString = replacedString.substring(0, replacedString.length()-1);

        return replacedString;
    }
}
