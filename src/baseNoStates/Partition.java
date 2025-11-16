package baseNoStates;

import java.util.List;
import java.util.ArrayList;

public class Partition extends Area {
    private final List<Area> areas = new ArrayList<>();

    Partition(String areaId, Partition father) {
        super(areaId);
        if (father != null) {
            father.addArea(this);
        }
    }

    public void addArea(Area area) {
        areas.add(area);
    }

    @Override
    public List<Door> getAccessibleDoors() {
        List<Door> doors = new ArrayList<>();

        for (Area area : areas) {
            doors.addAll(area.getAccessibleDoors());
        }

        return doors;
    }
}
