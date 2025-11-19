package baseNoStates;

import baseNoStates.AreaTypes.Partition;
import baseNoStates.AreaTypes.Space;
import baseNoStates.Visitors.AreaVisitor;
import baseNoStates.Visitors.FindAreaById;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class DirectoryAreas {
  private static final Logger logger = LoggerFactory.getLogger(DirectoryAreas.class);

  private static Area root = null;
  private static AreaVisitor visitor;

  public static void makeAreas() {
    Door d1 = DirectoryDoors.findDoorById("D1");
    Door d2 = DirectoryDoors.findDoorById("D2");
    Door d3 = DirectoryDoors.findDoorById("D3");
    Door d4 = DirectoryDoors.findDoorById("D4");
    Door d5 = DirectoryDoors.findDoorById("D5");
    Door d6 = DirectoryDoors.findDoorById("D6");
    Door d7 = DirectoryDoors.findDoorById("D7");
    Door d8 = DirectoryDoors.findDoorById("D8");
    Door d9 = DirectoryDoors.findDoorById("D9");

    Partition building = new Partition("building", null);
    root = building;
    Partition basement = new Partition("basement", building);
    Partition ground_floor = new Partition("ground_floor", building);
    Partition floor1 = new Partition("floor1", building);

    Space exterior = new Space(new ArrayList<Door>(), "exterior", null);
    Space parking = new Space(new ArrayList<Door>(Arrays.asList(d1, d2)), "parking", basement);
    Space stairs = new Space(new ArrayList<Door>(), "stairs", building);
    Space hall = new Space(new ArrayList<Door>(Arrays.asList(d3, d4)), "hall", ground_floor);
    Space room1 = new Space(new ArrayList<Door>(Arrays.asList(d5)), "room1", ground_floor);
    Space room2 = new Space(new ArrayList<Door>(Arrays.asList(d6)), "room2", ground_floor);
    Space corridor = new Space(new ArrayList<Door>(Arrays.asList(d7)), "corridor", floor1);
    Space room3 = new Space(new ArrayList<Door>(Arrays.asList(d8)), "room3", floor1);
    Space IT = new Space(new ArrayList<Door>(Arrays.asList(d9)), "IT", floor1);
  }

  public static Area findAreaById(String id) {
    logger.debug("Searching for area with id: {}", id);
    visitor = new FindAreaById(id);
    root.acceptVisitor(visitor);
    return ((FindAreaById)visitor).getTargetArea();
  }
}