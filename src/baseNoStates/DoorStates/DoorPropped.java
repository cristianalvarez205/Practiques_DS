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

    DoorPropped(Door door){
        super(door);
        stateName = "propped";
    }

    @Override
    public void lock() {
        System.out.println(INVALID_ACTION_MESSAGE);
    }

    @Override
    public void unlock() {
        System.out.println(INVALID_ACTION_MESSAGE);
    }

    @Override
    public void open() {
        System.out.println(INVALID_ACTION_MESSAGE);
    }

    @Override
    public void close() {
        door.setState(new DoorLocked(door));
        door.close();
    }

    @Override
    public void unlock_shortly() {
        System.out.println(INVALID_ACTION_MESSAGE);
    }
}
