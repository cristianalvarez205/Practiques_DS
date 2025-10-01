package baseNoStates;

public class DoorLocked extends DoorState {
    public DoorLocked(Door door){
        super(door);
        stateName = "locked";
    }

    @Override
    public boolean changeState(String action) {
        switch (action) {
            case Actions.UNLOCK:
                door.setState(new DoorUnlocked(door));
                break;
            case Actions.UNLOCK_SHORTLY:

                door.setState(new DoorShortlyUnlocked(door));
                break;
            default:
                return false;
        }
        return true;
    }
}
