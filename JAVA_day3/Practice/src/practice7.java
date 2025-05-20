import java.util.ArrayList;
import java.util.Scanner;

public class practice7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        int selectMenu = 0;
        boolean isEnd = false;

        while(!isEnd){
            System.out.println("=== 메뉴 ===");
            System.out.println("1. 성적 추가");
            System.out.println("2. 성적 조회");
            System.out.println("3. 통계 출력");
            System.out.println("4. 종료");
            selectMenu = sc.nextInt();

            switch (selectMenu){
                case 1:
                    System.out.print("추가할 점수를 입력해주세요 : ");
                    int grade = sc.nextInt();
                    grades.add(grade);
                    break;
                case 2:
                    if(grades.isEmpty()){
                        System.out.println("조회 할 성적이 없습니다.");
                        break;
                    }

                    System.out.println("현재 성적 리스트");
                    for (int i = 0; i < grades.size() ; i++) {
                        System.out.print(grades.get(i) + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    if(grades.isEmpty()){
                        System.out.println("조회 할 성적이 없습니다.");
                        break;
                    }

                    int maxValue = Integer.MIN_VALUE;
                    int minValue = Integer.MAX_VALUE;
                    double avg = 1.0d;
                    int sum = 0;

                    for (int i = 0; i < grades.size() ; i++) {
                        sum += grades.get(i);

                        if(maxValue < grades.get(i)){
                            maxValue = grades.get(i);
                        }

                        if(minValue > grades.get(i)){
                            minValue = grades.get(i);
                        }
                    }

                    avg = (double)sum / (double)grades.size();

                    System.out.println("성적 갯수 : " + grades.size());
                    System.out.println("가장 높은 점수 : "+ maxValue);
                    System.out.println("가장 낮은 점수 : "+ minValue);
                    System.out.println("총점 : "+ sum);
                    System.out.println("평균 : "+ avg);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    isEnd = true;
                    break;
                default:
                    System.out.println("유효한 입력이 아닙니다.");
                    break;
            }
        }
    }
}
