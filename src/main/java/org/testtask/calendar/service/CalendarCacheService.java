package org.testtask.calendar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.testtask.calendar.dto.DayDto;
import org.testtask.calendar.dto.MonthDto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarCacheService {

    private static final Logger log = LoggerFactory.getLogger(CalendarCacheService.class);

    @Cacheable(cacheNames = "calendars", key = "#root.target.getCacheKey(#year)")
    public List<MonthDto> getMonths(int year) {
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

        log.info("getCalendar: year={}, months={}", year, months);

        return months;
    }

    public String getCacheKey(int year) {
        boolean isLeap = Year.isLeap(year);
        DayOfWeek startDay = LocalDate.of(year, 1, 1).getDayOfWeek();
        return isLeap + "_" + startDay.getValue();
    }

}
