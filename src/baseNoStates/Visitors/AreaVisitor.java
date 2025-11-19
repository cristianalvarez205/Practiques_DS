package baseNoStates.Visitors;

import baseNoStates.AreaTypes.Partition;
import baseNoStates.AreaTypes.Space;
import baseNoStates.Door;

public interface AreaVisitor {
    public abstract void visitSpace(Space space);
    public abstract void visitPartition(Partition partition);
}
