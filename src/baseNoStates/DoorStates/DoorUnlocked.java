package baseNoStates.DoorStates;

import baseNoStates.Door;
import baseNoStates.DoorState;

/**
 * Represents the state of a door being unlocked.
 * Allows actions like closing, opening, and locking the door.
 */

public class DoorUnlocked extends DoorState {
    public DoorUnlocked(Door door){
        super(door);
        stateName = "unlocked";
    }

    @Override
    public void lock() {
        if (door.isClosed())
            door.setState(new DoorLocked(door));
        else
            System.out.println("You are trying to lock an open door.");
    }

    @Override
    public void unlock() {
        System.out.println(INVALID_ACTION_MESSAGE);
    }

    @Override
    public void open() {
        if (door.isClosed()) {
            System.out.println("Opening door");
            door.open();
        }
        else
            System.out.println("You are trying to open an already open door.");
    }

    @Override
    public void close() {
        if (door.isClosed())
            System.out.println("You are trying to close a door that is already closed.");
        else
            door.close();
    }

    @Override
    public void unlock_shortly() {
        System.out.println(INVALID_ACTION_MESSAGE);
    }
}