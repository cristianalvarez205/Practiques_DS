package baseNoStates;

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
