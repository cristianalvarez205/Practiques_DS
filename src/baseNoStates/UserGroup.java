package baseNoStates;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public abstract class UserGroup {
    Map<String,User> users = new HashMap<>();

    protected UserGroup() {
    }

    public void addUser(User user) {
        users.put(user.getCredential(), user);
    }

    public User getUser(String credential) {
        return users.get(credential);
    }

    public abstract boolean canSendRequests(LocalDateTime now);

    protected boolean isInRange(LocalDateTime dateTime,LocalDateTime start, LocalDateTime end) {
        return dateTime.isAfter(start) && dateTime.isBefore(end);
    }

    public abstract boolean canBeInSpace(Object fromSpace);

    public abstract boolean canDoAction(String action);
}
