package baseNoStates.DoorStates;

import baseNoStates.Clock;
import baseNoStates.Door;
import baseNoStates.DoorState;
import baseNoStates.Main;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.Observable;
import java.util.Observer;

public class DoorShortlyUnlocked extends DoorState implements Observer {
    private LocalDateTime start;

    public DoorShortlyUnlocked(Door door) {
        super(door);
        stateName = "unlocked_shortly";
        start = LocalDateTime.now();
        Main.clock.addObserver(this);
    }

    private void loadNewState () {
        if (door.isClosed()) {
            door.setState(new DoorLocked(door));
        }
        else {
            door.setState(new DoorPropped(door));
        }
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

    @Override
    public void update(Observable o, Object arg) {
        check10s(start,(LocalDateTime) arg);
    }

    private void check10s(LocalDateTime start, LocalDateTime arg) {
        if (start.plusSeconds(10).isBefore(arg))
        {
            Main.clock.deleteObserver(this);
            loadNewState();
            System.out.println("A acabat");
        }

    }
}
