import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();

        //리스트에 요소 추가
        elements.add("Notebook");
        elements.add("Pen");
        elements.add("Pencil");
        elements.add("Eraser");

        //노트북 이후에 마커 추가
        elements.add(elements.indexOf("Notebook")+1, "Marker");

        //요소 제거
        elements.remove("Eraser");

        //펜 요소 교체
        elements.set(elements.indexOf("Pen"), "Fountain Pen");

        //pencil이 있는지 여부
        System.out.println("장바구니에 Pencil이 포함되어 있나요? " + elements.contains("Pencil"));
        
        //모든 요소 출력
        System.out.println("최종 장바구니 품목: ");
        for (String element : elements) {
            System.out.println(element);
        }
    }
}
