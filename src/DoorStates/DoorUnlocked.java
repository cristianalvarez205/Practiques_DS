package DoorStates;

import baseNoStates.Door;
import baseNoStates.DoorState;

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
            System.out.println("Estas intentant bloquejar una porta oberta");
    }

    @Override
    public void unlock() {
        System.out.println("Acció no vàlida en aquest estat");
    }

    @Override
    public void open() {
        if (door.isClosed()) {
            System.out.println("Abriendo puerta");
            door.open();
        }
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