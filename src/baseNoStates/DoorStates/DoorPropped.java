package baseNoStates.DoorStates;

import baseNoStates.Actions;
import baseNoStates.Door;
import baseNoStates.DoorState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the 'propped' state of a door.
 * The door is slightly open but can be locked by closing it completely.
 */

public class DoorPropped extends DoorState {
  private static final Logger logger = LoggerFactory.getLogger(DoorPropped.class);

  DoorPropped(Door door) {
    super(door);
    stateName = "propped";
    logger.warn("Door {} has entered PROPPED state", door.getId());
  }

  @Override
  public void lock() {
    logger.warn("Door {} - Invalid action: trying to lock from propped state",
        door.getId());
  }

  @Override
  public void unlock() {
    logger.warn("Door {} - Invalid action: trying to unlock from propped state",
        door.getId());
  }

  @Override
  public void open() {
    logger.warn("Door {} - Invalid action: trying to open from propped state",
        door.getId());
  }

  @Override
  public void close() {
    logger.info("Door {} changing state: PROPPED -> LOCKED", door.getId());
    door.setState(new DoorLocked(door));
    door.close();
  }

  @Override
  public void unlock_shortly() {
    logger.warn("Door {} - Invalid action: trying to unlock_shortly from propped state",
        door.getId());
  }
}
