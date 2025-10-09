package baseNoStates;

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
}
