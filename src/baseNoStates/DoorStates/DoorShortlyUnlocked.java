package baseNoStates.DoorStates;

import baseNoStates.Clock;
import baseNoStates.Door;
import baseNoStates.DoorState;
import baseNoStates.Main;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.Observable;
import java.util.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a state where the door is unlocked for a short time.
 * After 10 seconds, it will automatically change to either locked or propped.
 */

public class DoorShortlyUnlocked extends DoorState implements Observer {
  private static final Logger logger = LoggerFactory.getLogger(DoorShortlyUnlocked.class);

  private LocalDateTime start;

  public DoorShortlyUnlocked(Door door) {
    super(door);
    stateName = "unlocked_shortly";
    start = LocalDateTime.now();
    Clock.getInstance().addObserver(this);
    logger.info("Door {} entered UNLOCKED_SHORTLY state (10 seconds timer started)",
        door.getId());
  }

  private void loadNewState() {
    if (door.isClosed()) {
      logger.info("Door {} changing state: UNLOCKED_SHORTLY -> LOCKED (timer expired)",
          door.getId());
      door.setState(new DoorLocked(door));
    } else {
      logger.info("Door {} changing state: UNLOCKED_SHORTLY -> PROPPED (timer expired, door open)",
          door.getId());
      door.setState(new DoorPropped(door));
    }
  }

  @Override
  public void lock() {
    logger.warn("Door {} - Invalid action: trying to lock from unlocked_shortly state",
        door.getId());
  }

  @Override
  public void unlock() {
    logger.warn("Door {} - Invalid action: trying to unlock from unlocked_shortly state",
        door.getId());
  }

  @Override
  public void open() {
    if (door.isClosed()) {
      logger.info("Door {} opening (state: UNLOCKED_SHORTLY)", door.getId());
      door.open();
    } else {
      logger.warn("Door {} - Invalid action: trying to open an already open door",
          door.getId());
    }
  }

  @Override
  public void close() {
    if (door.isClosed()) {
      logger.warn("Door {} - Invalid action: trying to close a door that is already closed",
          door.getId());
    } else {
      logger.info("Door {} closing (state: UNLOCKED_SHORTLY)", door.getId());
      door.close();
    }
  }

  @Override
  public void unlock_shortly() {
    logger.warn("Door {} - Invalid action: trying to unlock_shortly from unlocked_shortly state",
        door.getId());
  }

  @Override
  public void update(Observable observable, Object arg) {
    check10s(start, (LocalDateTime) arg);
  }

  private void check10s(LocalDateTime start, LocalDateTime currentTime) {
    if (start.plusSeconds(10).isBefore(currentTime)) {
      Clock.getInstance().deleteObserver(this);
      loadNewState();
      logger.info("Door {} - Short unlock period (10s) has ended", door.getId());
    }

  }
}
