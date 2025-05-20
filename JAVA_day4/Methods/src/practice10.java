import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class practice10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("들어온 시간을 입력해주세요(HH mm) : ");
        String enterTime = sc.nextLine();

        System.out.print("나간 시간을 입력해주세요(HH mm) : ");
        String outTime = sc.nextLine();

        System.out.println("총 이용 시간(m) : "+getTimeDistance(enterTime, outTime));
    }

    public static int getTimeDistance(String enter, String out){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH mm");
        LocalTime enterLocalTime = LocalTime.parse(enter, timeFormatter);
        LocalTime outLocalTime = LocalTime.parse(out, timeFormatter);

        int hourDistance = outLocalTime.getHour() - enterLocalTime.getHour();
        int minuteDistance = outLocalTime.getMinute() - enterLocalTime.getMinute();

        return hourDistance*60 + minuteDistance;
    }
}
