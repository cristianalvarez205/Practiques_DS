package baseNoStates;

import java.util.List;

public abstract class Area {
    private final String areaId;

    Area(String areaId) {
        this.areaId = areaId;
    }

  /**
   * Returns the list of doors that provide access to this area.
   */
    public abstract List<Door> getAccessibleDoors();

    public String getId() {
      return areaId;
    }
}