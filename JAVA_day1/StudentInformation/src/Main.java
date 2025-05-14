public class Main {
    public static void main(String[] args) {
        // 정수형 변수
        int age = 25;
        // 실수형 변수
        double height = 175.5;
        // 문자형 변수
        char gender = 'M';
        // 논리형 변수
        boolean isStudent = true;
        // 문자열 변수 (참조형)
        String name = "John";
        // 변수 값 출력
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height + "cm");
        System.out.println("Gender: " + gender);
        System.out.println("Is Student: " + isStudent);

        // 변수 값 변경
        name = "Noh Yunpyo";
        age = 27;
        height = 170.0;

        // 변경된 값 출력
        System.out.println("\n---After Change---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height + "cm");
        System.out.println("Is Student: " + isStudent);
    }
}
