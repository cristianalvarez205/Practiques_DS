package baseNoStates;

/**
* This class is used to handle all the actions that modifies states for each door
* An exemple of state could be: locked, unlocked, propped, shortly unlocked. See all in package DoorStates
* We used the STATE pattern
**/

public abstract class DoorState {
    protected static final String INVALID_ACTION_MESSAGE = "Invalid action in this state.";
    protected Door door;
    protected String stateName;
    public DoorState(Door d) {
      door = d;
    }

    public String getStateName() {
        return stateName;
    }

    public abstract void lock();

    public abstract void unlock();

    public abstract void open();

    public abstract void close();

    public abstract void unlock_shortly();

}
