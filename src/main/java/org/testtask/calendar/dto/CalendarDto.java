package org.testtask.calendar.dto;

import java.util.List;

public class CalendarDto {

    private int year;
    private List<MonthDto> months;

    public CalendarDto(int year, List<MonthDto> months) {
        this.year = year;
        this.months = months;
    }

    public int getYear() {
        return year;
    }

    public List<MonthDto> getMonths() {
        return months;
    }
}
