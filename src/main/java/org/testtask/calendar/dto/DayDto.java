package org.testtask.calendar.dto;

import java.io.Serializable;

public class DayDto implements Serializable {

    private int dayNumber;
    private String dayOfWeek;

    public DayDto(int dayNumber, String dayOfWeek) {
        this.dayNumber = dayNumber;
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
