package baseNoStates.Visitors;

import baseNoStates.AreaTypes.Partition;
import baseNoStates.AreaTypes.Space;
import baseNoStates.Door;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetDoorsGivingAccess implements AreaVisitor {
  private static final Logger logger = LoggerFactory.getLogger(GetDoorsGivingAccess.class);
  private final List<Door> doors = new ArrayList<>();

  @Override
  public void visitSpace(Space space) {
    logger.debug("Visiting space: {}", space.getId());
    doors.addAll(space.getDoorsGivingAccess());
    logger.debug("Collected {} doors from space {}",
        space.getDoorsGivingAccess().size(), space.getId());
  }

  @Override
  public void visitPartition(Partition partition) {
    logger.debug("Visiting partition: {}", partition.getId());
  }

  public List<Door> getDoorsGivingAccess() {
    logger.info("Total doors collected: {}", doors.size());
    return doors;
  }
}
