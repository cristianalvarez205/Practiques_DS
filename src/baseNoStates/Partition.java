package baseNoStates;

import java.util.ArrayList;

public class Partition extends Area {
    ArrayList<Area> areas = new ArrayList<>();

    Partition(String areaId, Partition father) {
        super(areaId);
        if (father != null)
            father.addArea(this);
    }

    public void addArea(Area p) {
        areas.add(p);
    }

    @Override
    public ArrayList<Door> getDoorsGivingAccess() {
        ArrayList<Door> doors = new ArrayList<>();
        for (Area a : areas)
        {
            doors.addAll(a.getDoorsGivingAccess());
        }
        return doors;
    }
}
