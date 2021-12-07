package com.techelevator.controller;

import com.techelevator.dao.DoctorAvailabilityDao;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CalendarController {
    private DoctorAvailabilityDao doctorAvailabilityDao;

    public CalendarController(DoctorAvailabilityDao doctorAvailabilityDao) {
        this.doctorAvailabilityDao = doctorAvailabilityDao;
    }
}