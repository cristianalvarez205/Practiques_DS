package baseNoStates;

import baseNoStates.UserGroups.Admin;
import baseNoStates.UserGroups.Employee;
import baseNoStates.UserGroups.Guest;
import baseNoStates.UserGroups.Manager;

import java.util.ArrayList;

public final class DirectoryUserGroups {
  private static final ArrayList<UserGroup> groups = new ArrayList<>();

  public static void makeUserGroups() {
    //TODO: make user groups according to the specifications in the comments, because
    // now all are the same

    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    Guest guest = new Guest();
    guest.addUser(new User("Bernat", "12345",guest));
    guest.addUser(new User("Blai", "77532",guest));
    groups.add(guest);

    Employee employees = new Employee();
    employees.addUser(new User("Ernest", "74984",employees));
    employees.addUser(new User("Eulalia", "43295",employees));
    groups.add(employees);


    Manager managers = new Manager();
    managers.addUser(new User("Manel", "95783",managers));
    managers.addUser(new User("Marta", "05827",managers));
    groups.add(managers);

    Admin admins = new Admin();
    admins.addUser(new User("Ana", "11343",admins));
    groups.add(admins);
  }

  public static User findUserByCredential(String credential) {
    for (UserGroup group : groups) {
      User user = group.getUser(credential);
      if (user != null) {
        return user;
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null; // otherwise we get a Java error
  }

}
