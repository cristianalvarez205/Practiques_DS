package baseNoStates.AreaTypes;


import baseNoStates.Area;
import baseNoStates.Door;
import baseNoStates.Visitors.AreaVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Space extends Area {
  private static final Logger logger = LoggerFactory.getLogger(Space.class);

  private final List<Door> doors;
  public Space(List<Door> doors, String areaId, Partition father) {
    super(areaId, father);
    this.doors = new ArrayList<>(doors);
    logger.debug("Space {} created with {} doors", areaId, doors.size());
  }

  @Override
  public void acceptVisitor(AreaVisitor visitor) {
    logger.debug("Space {} accepting visitor {}", areaId, visitor.getClass().getSimpleName());
    visitor.visitSpace(this);
  }

  /**
   * Returns the list of doors that provide access to this space.
   */
  public List<Door> getDoorsGivingAccess() {
    return doors;
  }
}