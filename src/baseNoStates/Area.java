package baseNoStates;

import baseNoStates.AreaTypes.Partition;
import baseNoStates.Visitors.AreaVisitor;

import java.util.List;

/**
 * We use this abstract class to represent a COMPOSITE patters
 * class partition is the container class
 * others that extends this class are leafs
 **/
public abstract class Area {
    protected final String areaId;

    public Area(String areaId, Partition father) {
        this.areaId = areaId;
        if (father != null) {
            father.addArea(this);
        }
    }

    public abstract  void acceptVisitor(AreaVisitor visitor);

    public String getId() {
      return areaId;
    }
}