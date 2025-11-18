package baseNoStates.Visitors;

import baseNoStates.AreaTypes.Partition;
import baseNoStates.AreaTypes.Space;
import baseNoStates.Door;

import java.util.ArrayList;
import java.util.List;

public class GetDoorsGivingAccess implements AreaVisitor {
    private final List<Door> doors = new ArrayList<>();
    @Override
    public void visitSpace(Space space) {
        doors.addAll(space.getDoorsGivingAccess());
    }

    @Override
    public void visitPartition(Partition partition) {
    }

    public List<Door> getDoorsGivingAccess() {
        return doors;
    }
}
