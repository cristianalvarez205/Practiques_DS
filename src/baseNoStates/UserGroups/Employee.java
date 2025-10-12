package baseNoStates.UserGroups;

import baseNoStates.Actions;
import baseNoStates.UserGroup;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;

public class Employee extends UserGroup {
    // employees :
    // Sep. 1 this year to Mar. 1 next year
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    @Override
    public boolean canSendRequests(LocalDateTime now) {
        // Comprovem Sep. 1 this year to Mar. 1 next year
        int year = now.getYear();
        LocalDateTime start = LocalDateTime.of(year, Month.SEPTEMBER, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(year+1, Month.MARCH, 1, 0, 0);
        if (!isInRange(now,start,end))
            return false;

        // Comprovem week days
        DayOfWeek day = now.getDayOfWeek();

        if(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)
            return false;

        // Comprovem 9-17h
        int hour = now.getHour();
        return hour >= 9 && hour <= 17;
    }

    @Override
    public boolean canBeInSpace(Object fromSpace) {
        return (fromSpace != "parking");
    }

    @Override
    public boolean canDoAction(String action) {
        return (Objects.equals(action, Actions.UNLOCK_SHORTLY) ||
                Objects.equals(action, Actions.OPEN) ||
                Objects.equals(action, Actions.CLOSE));
    }
}
