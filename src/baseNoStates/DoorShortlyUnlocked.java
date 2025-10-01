package baseNoStates;

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
    public boolean changeState(String action) {
        switch (action) {
            case Actions.OPEN:
                if (door.isClosed())
                    door.open();
                else
                    System.out.println("Estas intentant obrir una porta oberta");
                break;
            case Actions.CLOSE:
                if (door.isClosed())
                    System.out.println("Estas intentant tancar una porta tancada");
                else
                    door.close();
                break;
            default:
                return false;
        }
        return true;
    }
}
