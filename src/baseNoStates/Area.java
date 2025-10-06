package baseNoStates;

import java.util.ArrayList;

public abstract class Area {
    private final String areaId;

    Area(String areaId) {
        this.areaId = areaId;
    }

    public abstract ArrayList<Door> getDoorsGivingAccess();

    public Object getId() {
        return areaId;
    }
}
