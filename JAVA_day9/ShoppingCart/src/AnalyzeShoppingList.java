import java.util.*;

public class AnalyzeShoppingList {
    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();
        List<String> uniqueElements = new ArrayList<>();
        int max = 0;
        String maxKey = new String();

        //요소 추가
        elements.add("apple");
        elements.add("banana");
        elements.add("apple");
        elements.add("orange");
        elements.add("banana");
        elements.add("grape");
        elements.add("apple");

        //중복 제거
        for (String element : elements){
            if(uniqueElements.contains(element) == false){
                uniqueElements.add(element);
            }
        }

        //요소 갯수 체크 + 최대값 키 탐색
        for (String element : elements){
            int count = 0;

            for (String innerElement : elements){
                if(innerElement == element){
                    count++;
                }
            }

            if(max < count) {
                max = count;
                maxKey = element;
            }
        }


        System.out.println("총 구매 건수: " + elements.size());
        System.out.println("구매한 과일 종류: " + uniqueElements);
        System.out.println("가장 많이 구매한 항목: " + maxKey +  " (" + max + "회)");
    }
}
