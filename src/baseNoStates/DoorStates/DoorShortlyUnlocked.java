package baseNoStates.DoorStates;

import baseNoStates.Door;
import baseNoStates.DoorState;

public class DoorShortlyUnlocked extends DoorState {
    public DoorShortlyUnlocked(Door door){
        super(door);
        stateName = "unlocked_shortly";
    }

    private void loadNewState () {
        if (!door.isClosed()) {
            door.setState(new DoorLocked(door));
        }
        else {
            door.setState(new DoorPropped(door));
        }
    }

    private boolean timeExpired() {
        return true;
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
        if (door.isClosed())
            door.open();
        else
            System.out.println("Estas intentant obrir una porta oberta");
    }

    @Override
    public void close() {
        if (door.isClosed())
            System.out.println("Estas intentant tancar una porta tancada");
        else
            door.close();
    }

    @Override
    public void unlock_shortly() {
        System.out.println("Acció no vàlida en aquest estat");
    }
}
