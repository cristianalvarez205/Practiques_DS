package baseNoStates;

import baseNoStates.UserGroups.Admin;
import baseNoStates.UserGroups.Employee;
import baseNoStates.UserGroups.Guest;
import baseNoStates.UserGroups.Manager;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DirectoryUserGroups {
  private static final Logger logger = LoggerFactory.getLogger(DirectoryUserGroups.class);
  
  private static final List<UserGroup> groups = new ArrayList<>();

  public static void makeUserGroups() {

    logger.debug("Creating user groups and users...");
    
    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    Guest guest = new Guest();
    guest.addUser(new User("Bernat", "12345", guest));
    guest.addUser(new User("Blai", "77532", guest));
    groups.add(guest);
    logger.debug("Guest group created with 2 users");

    Employee employees = new Employee();
    employees.addUser(new User("Ernest", "74984", employees));
    employees.addUser(new User("Eulalia", "43295", employees));
    groups.add(employees);
    logger.debug("Employee group created with 2 users");


    Manager managers = new Manager();
    managers.addUser(new User("Manel", "95783", managers));
    managers.addUser(new User("Marta", "05827", managers));
    groups.add(managers);
    logger.debug("Manager group created with 2 users");

    Admin admins = new Admin();
    admins.addUser(new User("Ana", "11343", admins));
    groups.add(admins);
    logger.debug("Admin group created with 1 user");
    
    logger.info("All user groups created successfully: {} groups, total users loaded",
        groups.size());
  }

  public static User findUserByCredential(String credential) {
    logger.debug("Searching for user with credential: {}", credential);
    for (UserGroup group : groups) {
      User user = group.getUser(credential);
      if (user != null) {
        logger.debug("User found: {} in group {}", user, group.getClass().getSimpleName());
        return user;
      }
    }
    logger.warn("User with credential {} not found", credential);
    return null;
  }
}
