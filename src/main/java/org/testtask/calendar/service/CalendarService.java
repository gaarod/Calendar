package org.testtask.calendar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
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

    private final CalendarCacheService calendarCacheService;

    public CalendarService(CalendarCacheService calendarCacheService) {
        this.calendarCacheService = calendarCacheService;
    }

    public CalendarDto getCalendar(int year) {
        List<MonthDto> months = calendarCacheService.getMonths(year);
        return new CalendarDto(year,months);
    }

}
