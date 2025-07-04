package org.testtask.calendar.dto;

import java.io.Serializable;
import java.util.List;

public class MonthDto implements Serializable {

    public int monthNumber;
    public String monthName;
    public List<DayDto> days;

    public MonthDto(int monthNumber, String monthName, List<DayDto> days) {
        this.monthNumber = monthNumber;
        this.monthName = monthName;
        this.days = days;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getMonthName() {
        return monthName;
    }

    public List<DayDto> getDays() {
        return days;
    }


}
