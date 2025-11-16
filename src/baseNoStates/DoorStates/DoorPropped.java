package baseNoStates.DoorStates;

import baseNoStates.Actions;
import baseNoStates.Door;
import baseNoStates.DoorState;

/**
 * Represents the 'propped' state of a door.
 * The door is slightly open but can be locked by closing it completely.
 */

public class DoorPropped extends DoorState {

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
