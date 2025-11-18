package baseNoStates.DoorStates;

import baseNoStates.Door;
import baseNoStates.DoorState;
import org.slf4j.Logger;

/**
 * Represents a locked state of a door.
 * Prevents any action that could alter the door state except unlocking.
 */

public class DoorLocked extends DoorState {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(DoorLocked.class);

    public DoorLocked(Door door){
        super(door);
        stateName = "locked";
    }

    @Override
    public void lock() {
        logger.warn("Door {} - Invalid action: trying to lock an already locked door", door.getId());
    }

    @Override
    public void unlock() {
        logger.info("Door {} changing state: LOCKED -> UNLOCKED", door.getId());
        door.setState(new DoorUnlocked(door));
    }

    @Override
    public void open() {
        logger.warn("Door {} - Invalid action: trying to open a locked door", door.getId());
    }

    @Override
    public void close() {
        logger.warn("Door {} - Invalid action: trying to close a locked door", door.getId());
    }

    @Override
    public void unlock_shortly() {
        logger.info("Door {} changing state: LOCKED -> UNLOCKED_SHORTLY", door.getId());
        door.setState(new DoorShortlyUnlocked(door));
    }
}
