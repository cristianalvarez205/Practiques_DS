package baseNoStates.DoorStates;

import baseNoStates.Actions;
import baseNoStates.Door;
import baseNoStates.DoorState;

public class DoorPropped extends DoorState {
    DoorPropped(Door door){
        super(door);
        stateName = "propped";
    }

    @Override
    public void lock() {
        System.out.println("Acció no vàlida en aquest estat");
    }

    @Override
    public void unlock() {
        System.out.println("Acció no vàlida en aquest estat");
    }

    @Override
    public void open() {
        System.out.println("Acció no vàlida en aquest estat");
    }

    @Override
    public void close() {
        door.setState(new DoorLocked(door));
        door.close();
    }

    @Override
    public void unlock_shortly() {
        System.out.println("Acció no vàlida en aquest estat");
    }
}
