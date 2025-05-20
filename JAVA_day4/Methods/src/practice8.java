import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class practice8 {
    public static String getNextDepartures(String csvTimes, String currentTime){
        String[] csvTimeArr = csvTimes.split(",");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter abletimeFormatter = DateTimeFormatter.ofPattern("HH시 mm분");
        LocalTime currentTimeParse = LocalTime.parse(currentTime, timeFormatter);
        List<String> ableTimes = new ArrayList<>();

        for (int i = 0; i < csvTimeArr.length; i++) {
            LocalTime departTime = LocalTime.parse(csvTimeArr[i], timeFormatter);

            if(departTime.isAfter(currentTimeParse) && ableTimes.size() < 3){
                String abletime = departTime.format(abletimeFormatter);
                ableTimes.add(abletime);
            }
        }
        if(ableTimes.size() == 0){
            return "오늘 버스 운행이 종료되었습니다.";
        }

        return ableTimes.toString();

    }

    public static void main(String[] args) {
        String times = "07:30,08:45,10:15,12:00,15:30,18:45";

        System.out.println(getNextDepartures(times, "10:20"));
        System.out.println(getNextDepartures(times, "07:20"));
        System.out.println(getNextDepartures(times, "18:50"));
    }
}
