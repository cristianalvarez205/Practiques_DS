package baseNoStates.Visitors;

import baseNoStates.AreaTypes.Partition;
import baseNoStates.AreaTypes.Space;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetProppedDoors implements AreaVisitor {
  private static final Logger logger = LoggerFactory.getLogger(GetProppedDoors.class);

  @Override
  public void visitSpace(Space space) {
    logger.debug("Visiting space: {} (GetProppedDoors)", space.getId());
  }

  @Override
  public void visitPartition(Partition partition) {
    logger.debug("Visiting partition: {} (GetProppedDoors)", partition.getId());
  }
}
