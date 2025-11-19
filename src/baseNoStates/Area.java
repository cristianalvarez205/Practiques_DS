package baseNoStates;

import baseNoStates.AreaTypes.Partition;
import baseNoStates.Visitors.AreaVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * We use this abstract class to represent a COMPOSITE patters
 * class partition is the container class
 * others that extends this class are leafs
 **/
public abstract class Area {
  private static final Logger logger = LoggerFactory.getLogger(Area.class);

  protected final String areaId;

  public Area(String areaId, Partition father) {
    this.areaId = areaId;
    if (father != null) {
      father.addArea(this);
      logger.debug("Area {} added to partition {}", areaId, father.getId());
    } else {
      logger.debug("Root area {} created", areaId);
    }
  }

  public abstract  void acceptVisitor(AreaVisitor visitor);

  public String getId() {
    return areaId;
  }
}