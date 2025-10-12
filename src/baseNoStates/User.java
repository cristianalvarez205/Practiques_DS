package baseNoStates;

import java.time.LocalDateTime;

public class User {
  private final String name;
  private final String credential;
  private final UserGroup group;

  public User(String name, String credential, UserGroup group) {
    this.name = name;
    this.credential = credential;
    this.group = group;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }

    public boolean authorize(LocalDateTime now, Door door, String action) {
        return (group.canSendRequests(now) &&
        group.canBeInSpace(door.getFromSpace()) &&
        group.canBeInSpace(door.getToSpace()) &&
        group.canDoAction(action));
    }
}