package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    
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