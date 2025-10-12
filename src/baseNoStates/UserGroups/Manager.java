package baseNoStates.UserGroups;

import baseNoStates.UserGroup;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class Manager extends UserGroup {
    // managers :
    // Sep. 1 this year to Mar. 1 next year
    // week days + saturday, 8-20h
    // all actions
    // all spaces

    @Override
    public boolean canSendRequests(LocalDateTime now) {
        // Comprovem Sep. 1 this year to Mar. 1 next year
        int year = now.getYear();
        LocalDateTime start = LocalDateTime.of(year, Month.SEPTEMBER, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(year + 1, Month.MARCH, 1, 0, 0);
        if (!isInRange(now, start, end))
            return false;

        // Comprovem week days + saturday, 8-20h
        DayOfWeek day = now.getDayOfWeek();

        if (day == DayOfWeek.SUNDAY)
            return false;

        int hour = now.getHour();
        return hour < 8 || hour > 20;
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
