package baseNoStates;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

public class Main {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        clock.start();
        DirectoryDoors.makeDoors();
        DirectoryUserGroups.makeUserGroups();
        DirectoryAreas.makeAreas();
        new WebServer();
        clock.stop();
    }
}