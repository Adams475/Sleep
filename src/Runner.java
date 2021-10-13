import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Runner {

    public int timeToShutdown;
    private Calendar calendar;
    private boolean notTime;
    public int minutes;

    public Runner() {
        this.timeToShutdown = -1;
        this.calendar = Calendar.getInstance();
        this.notTime = true;
    }

    public void run() {

        while (notTime) {
            calendar.setTime(new Date());
            int current_time = calendar.get(Calendar.HOUR_OF_DAY);
            int minutes2 = calendar.get(Calendar.MINUTE);
            if ((timeToShutdown != -1) && (current_time - timeToShutdown == 0) && (minutes2 - this.minutes == 0)) {
                notTime = false;
            }
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Shutting down");
        shutdown();

    }

    private void shutdown() {
            Runtime runtime = Runtime.getRuntime();
        try {
            Process proc = runtime.exec("shutdown -s -t 0");
            System.exit(0);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args) throws IOException {
        Runner runner = new Runner();
        Sleep_Interface si = new Sleep_Interface(runner);
        si.setup();
    }

}
