import java.util.Timer;
import java.util.TimerTask;

public class TaskRunner {
    public void runTask(){
        //익명 내부 클래스로 TimerTask 구현
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task executed!");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 1000);
    }
}