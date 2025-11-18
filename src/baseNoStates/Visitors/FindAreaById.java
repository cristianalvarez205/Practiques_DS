package baseNoStates.Visitors;

import baseNoStates.Area;
import baseNoStates.AreaTypes.Partition;
import baseNoStates.AreaTypes.Space;

import java.util.Objects;

public class FindAreaById implements AreaVisitor {
    private String targetId;
    private Area targetArea = null;

    public FindAreaById(String targetId) {
        this.targetId = targetId;
    }
    @Override
    public void visitSpace(Space space) {
        if (targetId.equals(space.getId())) {
            targetArea = space;
        }
    }

    @Override
    public void visitPartition(Partition partition) {
        if (targetId.equals(partition.getId())) {
            targetArea = partition;
        }
    }

    public Area getTargetArea() {
        return targetArea;
    }
}
