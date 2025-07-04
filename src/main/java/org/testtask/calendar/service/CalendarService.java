package org.testtask.calendar.service;

import org.springframework.stereotype.Service;
import org.testtask.calendar.dto.CalendarDto;
import org.testtask.calendar.dto.DayDto;
import org.testtask.calendar.dto.MonthDto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarService {

    public CalendarDto getCalendar(int year) {

        List<MonthDto> months = new ArrayList<>();
        for (Month month : Month.values()) {
            List<DayDto> days = new ArrayList<>();
            int daysInMonth = month.length(Year.isLeap(year));
            for (int day = 1; day <= daysInMonth; day++) {
                LocalDate localDate = LocalDate.of(year, month, day);
                DayOfWeek dayOfWeek = localDate.getDayOfWeek();
                days.add(new DayDto(day, dayOfWeek.name()));
            }
            months.add(new MonthDto(month.getValue(),month.name(),days));
        }

        return new CalendarDto(year,months);
    }
}
