package baseNoStates.UserGroups;

import baseNoStates.UserGroup;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Admin user group with unrestricted permissions.
 * Can send requests anytime, be in any space, and perform any action.
 * Always=Jan. 1 this year to 2100
 */

public class Admin extends UserGroup {
    private static final LocalDateTime START_DATE = LocalDateTime.of(LocalDateTime.now().getYear(), Month.JANUARY, 1, 0, 0);
    private static final LocalDateTime END_DATE = LocalDateTime.of(2100, Month.JANUARY, 1, 0, 0);
    
    @Override
    public boolean canSendRequests(LocalDateTime now) {
        return isInRange(now, START_DATE, END_DATE);
    }

    @Override
    public boolean canBeInSpace(Object fromSpace) {
        return true;
    }

    @Override
    public boolean canDoAction(String action) {
        return true;
    }
}
