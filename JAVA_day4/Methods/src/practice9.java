import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

public class practice9 {
    public static void main(String[] args) {
        String times = "오전 8:30,오전 10:50,오후 11:50,오후 1:30,오전 1:30,오후 12:00,오후 5:20,오전 12:00";

        System.out.println(sortTimes(times));
    }

    public static String sortTimes(String times){
        String[] csvTimeArr = times.split(",");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("a h:mm");
        LocalTime[] localTimes = new LocalTime[csvTimeArr.length];

        for (int i = 0; i < localTimes.length; i++) {
            localTimes[i] = LocalTime.parse(csvTimeArr[i] , timeFormatter);
        }

        Arrays.sort(localTimes);
        String[] result = new String[csvTimeArr.length];
        for (int i = 0; i < localTimes.length; i++) {
            String tmp;
            String merdiem = "오전";

            if(localTimes[i].getHour() >= 12){
                localTimes[i] = localTimes[i].minusHours(12);
                merdiem = "오후";
            }
            if(localTimes[i].getHour() == 0){
                localTimes[i] = localTimes[i].plusHours(12);
            }

            tmp = merdiem + " " + localTimes[i].toString();
            result[i] = tmp;
        }


        return Arrays.toString(result);
    }
}
