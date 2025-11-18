package baseNoStates.DoorStates;

import baseNoStates.Door;
import baseNoStates.DoorState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the state of a door being unlocked.
 * Allows actions like closing, opening, and locking the door.
 */

public class DoorUnlocked extends DoorState {
    private static final Logger logger = LoggerFactory.getLogger(DoorUnlocked.class);
    
    public DoorUnlocked(Door door){
        super(door);
        stateName = "unlocked";
    }

    @Override
    public void lock() {
        if (door.isClosed()) {
            logger.info("Door {} changing state: UNLOCKED -> LOCKED", door.getId());
            door.setState(new DoorLocked(door));
        }
        else {
            logger.warn("Door {} - Invalid action: trying to lock an open door", door.getId());
        }
    }

    @Override
    public void unlock() {
        logger.warn("Door {} - Invalid action: trying to unlock an already unlocked door", door.getId());
    }

    @Override
    public void open() {
        if (door.isClosed()) {
            logger.info("Door {} opening (state: UNLOCKED)", door.getId());
            door.open();
        }
        else {
            logger.warn("Door {} - Invalid action: trying to open an already open door", door.getId());
        }
    }

    @Override
    public void close() {
        if (door.isClosed()) {
            logger.warn("Door {} - Invalid action: trying to close a door that is already closed", door.getId());
        }
        else {
            logger.info("Door {} closing (state: UNLOCKED)", door.getId());
            door.close();
        }
    }

    @Override
    public void unlock_shortly() {
        logger.warn("Door {} - Invalid action: trying to unlock_shortly from unlocked state", door.getId());
    }
}