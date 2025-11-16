package baseNoStates;

import java.util.ArrayList;
import java.util.List;

public class Space extends Area {
    private final List<Door> doors;
    Space(List<Door> doors,String areaId, Partition father) {
        super(areaId);
        this.doors = new ArrayList<>(doors);

        if (father != null) {
            father.addArea(this);
        }
    }

    @Override
    public List<Door> getAccessibleDoors() {
        return doors;
    }
}