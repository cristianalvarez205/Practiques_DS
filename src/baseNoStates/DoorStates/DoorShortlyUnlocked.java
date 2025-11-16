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

/**
 * Represents a state where the door is unlocked for a short time.
 * After 10 seconds, it will automatically change to either locked or propped.
 */

public class DoorShortlyUnlocked extends DoorState implements Observer {
    private LocalDateTime start;

    public DoorShortlyUnlocked(Door door) {
        super(door);
        stateName = "unlocked_shortly";
        start = LocalDateTime.now();
        Clock.getInstance().addObserver(this);
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
        System.out.println(INVALID_ACTION_MESSAGE);
    }

    @Override
    public void unlock() {
        System.out.println(INVALID_ACTION_MESSAGE);
    }

    @Override
    public void open() {
        if (door.isClosed())
            door.open();
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

    @Override
    public void update(Observable observable, Object arg) {
        check10s(start,(LocalDateTime) arg);
    }

    private void check10s(LocalDateTime start, LocalDateTime currentTime) {
        if (start.plusSeconds(10).isBefore(currentTime))
        {
            Clock.getInstance().deleteObserver(this);
            loadNewState();
            System.out.println("The short unlock period has ended.");
        }

    }
}
