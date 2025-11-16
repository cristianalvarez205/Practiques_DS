package baseNoStates.DoorStates;

import baseNoStates.Door;
import baseNoStates.DoorState;

/**
 * Represents a locked state of a door.
 * Prevents any action that could alter the door state except unlocking.
 */

public class DoorLocked extends DoorState {

    public DoorLocked(Door door){
        super(door);
        stateName = "locked";
    }

    @Override
    public void lock() {
        System.out.println(INVALID_ACTION_MESSAGE);
    }

    @Override
    public void unlock() {
        door.setState(new DoorUnlocked(door));
    }

    @Override
    public void open() {
        System.out.println(INVALID_ACTION_MESSAGE);
    }

    @Override
    public void close() {
        System.out.println(INVALID_ACTION_MESSAGE);
    }

    @Override
    public void unlock_shortly() {
        door.setState(new DoorShortlyUnlocked(door));
    }
}
