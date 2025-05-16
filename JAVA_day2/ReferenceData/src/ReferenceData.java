public class ReferenceData {
    public static void main(String[] args) {
        int number = 100;
        Integer numberBox = number;
        System.out.println("number 언박스 : "+ number);
        System.out.println("number 박스 : "+numberBox);

        //wrpper class > class에 대한 여러 함수 존재 *원시타입은 없음
        System.out.println("numberBox class : " + numberBox.getClass().getName());
        System.out.println(numberBox.valueOf("456"));
        System.out.println(numberBox.toString() + "글자임");
    }
}
