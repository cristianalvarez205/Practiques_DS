package baseNoStates;

public class DoorUnlocked extends DoorState {
    DoorUnlocked(Door door){
        super(door);
        stateName = "unlocked";
    }

    @Override
    public boolean changeState(String action) {
        switch (action){
            case Actions.OPEN:
                if (door.isClosed()) {
                    System.out.println("Abriendo puerta");
                    door.open();
                }
                else
                    System.out.println("Estas intentant obrir una porta oberta");
                break;
            case Actions.CLOSE:
                if (door.isClosed())
                    System.out.println("Estas intentant tancar una porta tancada");
                else
                    door.close();
                break;
            case Actions.LOCK:
                if (door.isClosed())
                    door.setState(new DoorLocked(door));
                else
                    System.out.println("Estas intentant bloquejar una porta oberta");
                break;
            default:
                return false;
        }
        return true;
    }
}