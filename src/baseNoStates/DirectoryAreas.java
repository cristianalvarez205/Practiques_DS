package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryAreas {
    private static ArrayList<Area> allAreas = new ArrayList<>();

    // Inicialització de totes les areas de l'edifici
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

        Area exterior = new Area(new Door[]{d1,d3},new Area[]{},"exterior");
        Area parking = new Area(new Door[]{d1,d2},new Area[]{},"parking");
        Area stairs = new Area(new Door[]{d2,d4,d7},new Area[]{},"stairs");
        Area hall = new Area(new Door[]{d4,d3,d5,d6},new Area[]{},"hall");
        Area room1 = new Area(new Door[]{d5},new Area[]{},"room1");
        Area room2 = new Area(new Door[]{d6},new Area[]{},"room2");
        Area corridor = new Area(new Door[]{d7,d8,d9},new Area[]{},"corridor");
        Area room3 = new Area(new Door[]{d8},new Area[]{},"room3");
        Area IT = new Area(new Door[]{d9},new Area[]{},"IT");

        Area basement = new Area(new Door[]{},new Area[]{parking},"basement");
        Area ground_floor = new Area(new Door[]{},new Area[]{room1,room2,hall},"ground_floor");
        Area floor1 = new Area(new Door[]{},new Area[]{room3,corridor,IT},"floor1");

        Area building = new Area(new Door[]{},new Area[]{basement,ground_floor,floor1,stairs,exterior},"building");
        allAreas = new ArrayList<>(Arrays.asList(exterior,parking,stairs,hall,room1,room2,corridor,room3,IT,basement,ground_floor,floor1,building));
    }

    public static Area findAreaById(String id) {
        for (Area area : allAreas) {
            if (area.getId().equals(id)) {
                return area;
            }
        }
        System.out.println("area with id " + id + " not found");
        return null; // otherwise we get a Java error
    }
}
