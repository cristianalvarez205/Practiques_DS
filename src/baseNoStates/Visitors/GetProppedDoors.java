package baseNoStates.Visitors;

import baseNoStates.AreaTypes.Partition;
import baseNoStates.AreaTypes.Space;

public class GetProppedDoors implements AreaVisitor {
    @Override
    public void visitSpace(Space space) {}

    @Override
    public void visitPartition(Partition partition) {}
}
