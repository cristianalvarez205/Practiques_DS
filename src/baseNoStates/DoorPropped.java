package baseNoStates;

public class DoorPropped extends DoorState {
    DoorPropped(Door door){
        super(door);
        stateName = "propped";
    }

    public boolean changeState(String action) {
        switch (action) {
            case Actions.CLOSE:
                door.setState(new DoorLocked(door));
                door.close();
                break;
            default:
                return false;
        }
        return true;
    }
}
