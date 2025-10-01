package baseNoStates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Area {
    private Door[] doors;
    private Area[] areas;
    private String areaId;

    Area(Door[] doors, Area[] areas, String areaId) {
        this.doors = doors;
        this.areas = areas;
        this.areaId = areaId;
    }

    public Door[] getDoorsGivingAccess() {
        Set<Door> allDoors = getDoorsGivingAccessRecursive();
        // Convertim el Set a Array (Door[0] per adaptar el tamany del Set al array)
        return allDoors.toArray(new Door[0]);
    }

    public Set<Door> getDoorsGivingAccessRecursive() {
        // Fem servir Set per previnir "doors" duplicades
        Set<Door> allDoors = new HashSet<>(Arrays.asList(doors));
        for (Area a : areas)
        {
            // Ajuntem els dos Sets
            allDoors.addAll(a.getDoorsGivingAccessRecursive());
        }
        return allDoors;
    }

    public Object getId() {
        return areaId;
    }
}
