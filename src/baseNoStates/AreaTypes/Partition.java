package baseNoStates.AreaTypes;

import baseNoStates.Area;
import baseNoStates.Door;
import baseNoStates.Visitors.AreaVisitor;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Partition extends Area {
    private final List<Area> areas = new ArrayList<>();

    public Partition(String areaId,Partition father) {
        super(areaId,father);
    }

    @Override
    public void acceptVisitor(AreaVisitor visitor) {
        visitor.visitPartition(this);
        for (Area area : areas) {
            area.acceptVisitor(visitor);
        }
    }

    public void addArea(Area area) {
        areas.add(area);
    }
}
