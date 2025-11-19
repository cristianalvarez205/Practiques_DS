package baseNoStates;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
  private static final Logger logger = LoggerFactory.getLogger(User.class);
  
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
    boolean canSendRequests = group.canSendRequests(now);
    boolean canBeInFromSpace = group.canBeInSpace(door.getFromSpace());
    boolean canBeInToSpace = group.canBeInSpace(door.getToSpace());
    boolean canDoAction = group.canDoAction(action);

    boolean authorized = canSendRequests && canBeInFromSpace
        && canBeInToSpace && canDoAction;

    if (authorized) {
      logger.info("Authorization SUCCESS: User {} authorized to {} door {}",
          name, action, door.getId());
    } else {
      logger.warn(
          "Authorization FAILED: User {} cannot {} door {} - Reasons: "
              + "canSendRequests={}, canBeInFromSpace={}, "
              + "canBeInToSpace={}, canDoAction={}",
          name, action, door.getId(), canSendRequests,
          canBeInFromSpace, canBeInToSpace, canDoAction);
    }

    return authorized;
  }
}