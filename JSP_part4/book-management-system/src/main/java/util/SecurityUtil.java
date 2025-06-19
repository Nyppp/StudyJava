package util;

import java.util.regex.Pattern;

public class SecurityUtil {
    private static final Pattern HTML_TAG_PATTERN = Pattern.compile("<[^>]*>");
    private static final Pattern SCRIPT_PATTERN = Pattern.compile("(?i)<script[^>]*>.*?</script>");

    // XSS 방지 - HTML 태그 제거 및 이스케이프
    public static String escapeHtml(String input) {
        if (input == null) return null;

        return input.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;")
                .replace("/", "&#x2F;");
    }

    // 스크립트 태그 제거
    public static String removeScripts(String input) {
        if (input == null) return null;
        return SCRIPT_PATTERN.matcher(input).replaceAll("");
    }

    // 안전한 문자열 처리
    public static String sanitizeInput(String input) {
        if (input == null) return null;

        // 스크립트 제거
        input = removeScripts(input);

        // HTML 이스케이프
        input = escapeHtml(input);

        // 앞뒤 공백 제거
        input = input.trim();

        return input;
    }
}