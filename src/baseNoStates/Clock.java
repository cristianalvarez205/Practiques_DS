package baseNoStates;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class implements a SINGLETON pattern with lazy initialization
 **/

public class Clock extends Observable {
  private static final Logger logger = LoggerFactory.getLogger(Clock.class);

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
      instance = new Clock(1); // default period (seconds)
      logger.debug("Clock singleton instance created with period {} seconds", instance.period);
    }
    return instance;
  }

  /**
   * Starts a timer that executes a periodic task.
   * The task updates the current date/time, prints it to the console,
   * and notifies all observers with the new date.
   * The timer starts immediately and repeats every "period" seconds.
   **/

  public void start() {
    logger.info("Clock started with period of {} seconds", period);
    TimerTask repeatedTask = new TimerTask() {
      @Override
      //modify the abstract function of the class TimerTask for our instance repeatedTask
      public void run() {
        date = LocalDateTime.now();
        logger.debug("Clock tick at {}, notifying observers", date);
        setChanged();
        notifyObservers(date);
      }
    };
    //at some point this function calls run()
    timer.scheduleAtFixedRate(repeatedTask, 0, 1000L * period);
  }

  public void stop() {
    logger.info("Clock stopped");
    timer.cancel();
  }

  public int getPeriod() {
    return period;
  }

  public LocalDateTime getDate() {
    return date;
  }
}