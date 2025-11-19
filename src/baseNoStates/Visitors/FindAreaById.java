package baseNoStates.Visitors;

import baseNoStates.Area;
import baseNoStates.AreaTypes.Partition;
import baseNoStates.AreaTypes.Space;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindAreaById implements AreaVisitor {
  private static final Logger logger = LoggerFactory.getLogger(FindAreaById.class);
  private String targetId;
  private Area targetArea = null;

  public FindAreaById(String targetId) {
    this.targetId = targetId;
    logger.debug("Created FindAreaById visitor for target: {}", targetId);
  }

  @Override
  public void visitSpace(Space space) {
    logger.debug("Visiting space: {}", space.getId());
    if (targetId.equals(space.getId())) {
      targetArea = space;
      logger.info("Found target area (Space): {}", targetId);
    }
  }

  @Override
  public void visitPartition(Partition partition) {
    logger.debug("Visiting partition: {}", partition.getId());
    if (targetId.equals(partition.getId())) {
      targetArea = partition;
      logger.info("Found target area (Partition): {}", targetId);
    }
  }

  public Area getTargetArea() {
    return targetArea;
  }
}
