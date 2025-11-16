package baseNoStates;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Observable {

    private static Clock instance;

    private LocalDateTime date;
    private final Timer timer;
    private final int period; // seconds

    private Clock(int period) {
        this.period = period;
        timer = new Timer();
    }

    public static synchronized Clock getInstance() {
      if (instance == null) {
        instance = new Clock(1); // valor per defecte
      }
      return instance;
    }

    public void start() {
        TimerTask repeatedTask = new TimerTask() {
            @Override
            public void run() {
                // Instance of anonymous class
                date = LocalDateTime.now();
                System.out.println("run() executed at " + date);
                setChanged();
                notifyObservers(date);
            }
        };
        timer.scheduleAtFixedRate(repeatedTask, 0, 1000L * period);
    }

    public void stop() {
      timer.cancel();
    }

    public int getPeriod() {
      return period;
    }

    public LocalDateTime getDate() {
      return date;
    }
}