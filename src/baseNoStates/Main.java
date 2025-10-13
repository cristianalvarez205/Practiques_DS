package baseNoStates;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

public class Main {
    public static Clock clock = new Clock(1);
    public static void main(String[] args) {
        clock.start();
        DirectoryDoors.makeDoors();
        DirectoryUserGroups.makeUserGroups();
        DirectoryAreas.makeAreas();
        new WebServer();
        clock.stop();
    }
}
