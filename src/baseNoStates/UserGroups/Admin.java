package baseNoStates.UserGroups;

import baseNoStates.UserGroup;

import java.time.LocalDateTime;
import java.time.Month;

public class Admin extends UserGroup {
    // admin :
    // always=Jan. 1 this year to 2100
    // all days of the week
    // all actions
    // all spaces
    @Override
    public boolean canSendRequests(LocalDateTime now) {
        int year = now.getYear();
        LocalDateTime start = LocalDateTime.of(year, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2100, Month.JANUARY, 1, 0, 0);
        return isInRange(now,start,end);
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
