package baseNoStates.AreaTypes;

import baseNoStates.Area;
import baseNoStates.Visitors.AreaVisitor;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Partition extends Area {
  private static final Logger logger = LoggerFactory.getLogger(Partition.class);

  private final List<Area> areas = new ArrayList<>();

  public Partition(String areaId, Partition father) {
    super(areaId, father);
    logger.debug("Partition {} created", areaId);
  }

  public List<Area> getAreas() {
    return areas;
  }

  @Override
  public void acceptVisitor(AreaVisitor visitor) {
    logger.debug("Partition {} accepting visitor {} (will propagate to {} child areas)",
        areaId, visitor.getClass().getSimpleName(), areas.size());
    visitor.visitPartition(this);
  }

  public void addArea(Area area) {
    areas.add(area);
    logger.debug("Area {} added to partition {} (total: {} areas)",
        area.getId(), areaId, areas.size());
  }
}
