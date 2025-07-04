package org.testtask.calendar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.testtask.calendar.dto.CalendarDto;
import org.testtask.calendar.service.CalendarService;

@RestController
public class CalendarController {

    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/calendar/{year}")
    public CalendarDto getCalendar(@PathVariable int year){
        return calendarService.getCalendar(year);
    }
}
