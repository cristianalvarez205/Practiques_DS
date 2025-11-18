package baseNoStates.AreaTypes;


import baseNoStates.Area;
import baseNoStates.Door;
import baseNoStates.Visitors.AreaVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Space extends Area {
    private final List<Door> doors;
    public Space(List<Door> doors,String areaId, Partition father) {
        super(areaId,father);
        this.doors = new ArrayList<>(doors);
    }

    @Override
    public void acceptVisitor(AreaVisitor visitor) {
        visitor.visitSpace(this);
    }

    /**
     * Returns the list of doors that provide access to this space.
     */
    public List<Door> getDoorsGivingAccess() {
        return doors;
    }
}