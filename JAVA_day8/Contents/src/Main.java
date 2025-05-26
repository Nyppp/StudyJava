public class Main {
    public static void main(String[] args) {
        ContentCreator contentCreator = new ContentCreator("예린", 29);

        System.out.println("직급 : " + contentCreator.getSeniority());
        System.out.println("편집 점수 : " + String.format("%.2f",contentCreator.evaluateEditingScore(120, 80) ));
        System.out.println("음성 품질 점수 : " + contentCreator.voiceQualityScore(100,3));

    }
}
