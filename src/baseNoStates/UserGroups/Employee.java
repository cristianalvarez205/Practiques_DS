package baseNoStates.UserGroups;

import baseNoStates.Actions;
import baseNoStates.UserGroup;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;

/**
 * Employee user group with restricted permissions.
 * Employees can only send requests during specific times, and have restricted access to spaces.
 * Sep. 1 this year to Mar. 1 next year
 * Week days 9-17h
 * Just shortly unlock
 * Ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
 */

public class Employee extends UserGroup {
    private static final LocalDateTime START_DATE = LocalDateTime.of(LocalDateTime.now().getYear(), Month.SEPTEMBER, 1, 0, 0);
    private static final LocalDateTime END_DATE = LocalDateTime.of(LocalDateTime.now().getYear() + 1, Month.MARCH, 1, 0, 0);
    private static final int WORK_START_HOUR = 9;
    private static final int WORK_END_HOUR = 17;
    private static final String PARKING = "parking";

    @Override
    public boolean canSendRequests(LocalDateTime now) {
        // We check Sep. 1 this year to Mar. 1 next year
        if (!isInRange(now, START_DATE, END_DATE)) {
            return false;
        }
        // We check week days
        DayOfWeek day = now.getDayOfWeek();

        if(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            return false;
        }
        // We check 9-17h
        int hour = now.getHour();
        return hour >= WORK_START_HOUR && hour <= WORK_END_HOUR;
    }

    @Override
    public boolean canBeInSpace(Object fromSpace) {
        return (fromSpace != PARKING);
    }

    @Override
    public boolean canDoAction(String action) {
        return Objects.equals(action, Actions.UNLOCK_SHORTLY) ||
               Objects.equals(action, Actions.OPEN) ||
               Objects.equals(action, Actions.CLOSE);
    }
}
