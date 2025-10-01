package baseNoStates;

public class DoorShortlyUnlocked extends DoorState {
    public DoorShortlyUnlocked(Door door){
        super(door);
        stateName = "unlocked_shortly";
    }

    @Override
    public boolean changeState(String action) {
        switch (action){
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
            case Actions.UNLOCK:
                if (door.isClosed())
                    door.setState(new DoorUnlocked(door));
                else
                    System.out.println("Estas intentant desbloquejar una porta oberta");
                break;
            default:
                return false;
        }
        return true;
    }
}
