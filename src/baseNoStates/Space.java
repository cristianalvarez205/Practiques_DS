package baseNoStates;

import java.util.ArrayList;

public class Space extends Area {
    ArrayList<Door> doors = new ArrayList<>();
    Space(ArrayList<Door> doors,String areaId, Partition father) {
        super(areaId);
        this.doors = doors;
        if (father != null)
            father.addArea(this);
    }

    @Override
    public ArrayList<Door> getDoorsGivingAccess() {
        return doors;
    }
}
