package baseNoStates;

public abstract class DoorState {
    protected Door door;
    protected String stateName;
    DoorState(Door d) {
        door = d;
    }
    public abstract boolean changeState(String action);

    public String getStateName() {
        return stateName;
    }
}
