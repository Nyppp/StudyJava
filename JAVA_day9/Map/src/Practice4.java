import java.util.*;

public class Practice4 {
    public static void main(String[] args) {
        Map<String, String> moneySenderMap = new HashMap<>();

        moneySenderMap.put("김철수", "100000");
        moneySenderMap.put("박영희", "50000");
        moneySenderMap.put("이민수", "0");
        moneySenderMap.put("홍길동", "150000");
        moneySenderMap.put("김영수", "100000");
        moneySenderMap.put("최수민", "(금액 없음)");
        moneySenderMap.put("김민정", "80000");
        moneySenderMap.put("이민수", "20000");

        //1. 모든 사람의 이름 중복없이 출력
        Set<String> senders = new HashSet<>();
        senders.addAll(moneySenderMap.keySet());
        System.out.println("[지인 목록]");
        System.out.println(senders);
        System.out.println();

        //2. 축의금 기록이 있는 사람들의 총액 모두 합산
        int sum = 0;
        for(String name : moneySenderMap.keySet()){
            if(moneySenderMap.get(name) == "(금액 없음)"){
                continue;
            }else{
                sum += Integer.parseInt(moneySenderMap.get(name));
            }
        }
        System.out.println("[축의금 합계 : " + sum + "원]\n");

        //3. 축의금 10만원 이상 낸 사람 출력
        System.out.println("[축의금 vip 리스트(10만원 이상)]");
        for (Map.Entry<String,String> entry : moneySenderMap.entrySet()){
            if(entry.getValue() == "(금액 없음)"){
                continue;
            }

            if(Integer.parseInt(entry.getValue()) >= 100000){
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
        System.out.println();
        
        //4. 이름에 "김" 이 포함된 사람 수
        int nameCount = 0;
        for (String str : senders){
            if(str.indexOf("김")>= 0){
                nameCount++;
            }
        }
        System.out.println("[이름에 \"김\"이 포함된 사람 수 : "+nameCount+"명]\n");

        //5. 축의금 금액이 없거나 0인 사람 출력
        System.out.println("[축의금 0원 혹은 보내지 않은 사람 목록]");
        for (String str : moneySenderMap.keySet()){
            if(moneySenderMap.get(str) == "(금액 없음)" || moneySenderMap.get(str) == "0"){
                System.out.println(str);
            }
        }
    }
}
