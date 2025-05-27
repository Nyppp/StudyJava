import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Practice2 {
    public static void main(String[] args) {
        Map<String, Integer> menuList = new HashMap<>();
        int needToOrderCount = 5;

        menuList.put("Americano", 10);
        menuList.put("Latte", 5);
        menuList.put("Espresso", 8);
        menuList.put("Mocha", 0);
        menuList.put("Vanilla Latte", 3);
        menuList.put("Cold Brew", 2);
        menuList.put("Caramel Macchiato", 0);
        
        
        //재고 0개 출력
        Set<String> noCountSet = new HashSet<>();
        for (String str : menuList.keySet()){
            if(menuList.get(str) == 0){
                noCountSet.add(str);
            }
        }
        System.out.println("[재고가 없는 메뉴 : " + noCountSet.size() + "개]");
        System.out.println(noCountSet + "\n");

        //전체 메뉴 이름 출력
        System.out.println("[전체 메뉴 리스트 (재고 "+needToOrderCount+"개 이하 메뉴 - 주의 필요)]");
        for (String str : menuList.keySet()){
            if(menuList.get(str) < needToOrderCount){
                str += " (주의 필요)";
            }
            System.out.println(str);
        }
        System.out.println();
        
        //재고 평균 계산 + 낮은 메뉴 출력
        System.out.println("[재고 평균 및 평균 미만 재고 메뉴 리스트]");
        int avg = 0;
        int sum = 0;
        for (int count : menuList.values()){
            sum += count;
        }
        avg = sum / menuList.size();

        System.out.println("재고 평균 : "+ avg);
        for (String str : menuList.keySet()){
            if(menuList.get(str) < avg){
                System.out.println(str);
            }
        }
        System.out.println();

        //메뉴명에 Latte가 들어간 메뉴 갯수
        int latteCount = 0;
        for (String str : menuList.keySet()){
            if(str.indexOf("Latte") >= 0){
                latteCount++;
            }
        }

        System.out.println("[라떼 매뉴 갯수 : "+ latteCount +"개]");

    }
}
