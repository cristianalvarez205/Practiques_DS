package baseNoStates.UserGroups;

import baseNoStates.UserGroup;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Manager user group with extended permissions.
 * Managers can send requests, access all spaces, and perform all actions within a defined time range.
 * Sep. 1 this year to Mar. 1 next year
 * Week days + Saturday, 8-20h
 * All actions
 * All spaces
 */

public class Manager extends UserGroup {

    private static final int year = LocalDateTime.now().getYear();
    private static final LocalDateTime WORK_START_HOUR = LocalDateTime.of(year, Month.SEPTEMBER, 1, 0, 0);;
    private static final LocalDateTime WORK_END_HOUR = LocalDateTime.of(year + 1, Month.MARCH, 1, 0, 0);

    @Override
    public boolean canSendRequests(LocalDateTime now) {
        // We check Sep. 1 this year to Mar. 1 next year
        if (!isInRange(now, WORK_START_HOUR, WORK_END_HOUR)){
            return false;
        }
        
        // We check week days + saturday, 8-20h
        DayOfWeek day = now.getDayOfWeek();

        if (day == DayOfWeek.SUNDAY) {
            return false;
        }

        int hour = now.getHour();

        return hour >= 8 && hour <= 20;
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
