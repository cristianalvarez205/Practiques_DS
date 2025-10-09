package baseNoStates.DoorStates;

import baseNoStates.Door;
import baseNoStates.DoorState;

public class DoorLocked extends DoorState {
    public DoorLocked(Door door){
        super(door);
        stateName = "locked";
    }

    @Override
    public void lock() {
        System.out.println("Acció no vàlida en aquest estat");
    }

    @Override
    public void unlock() {
        door.setState(new DoorUnlocked(door));
    }

    @Override
    public void open() {
        System.out.println("Acció no vàlida en aquest estat");
    }

    @Override
    public void close() {
        System.out.println("Acció no vàlida en aquest estat");
    }

    @Override
    public void unlock_shortly() {
        door.setState(new DoorShortlyUnlocked(door));
    }
}
