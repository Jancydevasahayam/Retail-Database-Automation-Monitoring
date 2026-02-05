package scheduler;
import service.BackupService;
import service.MonitoringService;
import java.util.Timer;
import java.util.TimerTask;
public class JobScheduler {
    public void start() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                try {
                    new BackupService().backupDB();
                    new MonitoringService().detectSlowQueries();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 86400000);
    }
}