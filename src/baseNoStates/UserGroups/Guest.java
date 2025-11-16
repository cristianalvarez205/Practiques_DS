package baseNoStates.UserGroups;

import baseNoStates.UserGroup;

import java.time.LocalDateTime;

/**
 * Guest user group with no permissions.
 * Guests cannot send requests, be in any space, or perform any action.
 */

public class Guest extends UserGroup {
    @Override
    public boolean canSendRequests(LocalDateTime now) {
        return false;
    }

    @Override
    public boolean canBeInSpace(Object fromSpace) {
        return false;
    }

    @Override
    public boolean canDoAction(String action) {
        return false;
    }
}
