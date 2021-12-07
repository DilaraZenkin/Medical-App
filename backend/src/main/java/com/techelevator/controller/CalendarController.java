package com.techelevator.controller;

import com.techelevator.dao.DoctorAvailabilityDAO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CalendarController {
    private DoctorAvailabilityDAO doctorAvailabilityDao;

    public CalendarController(DoctorAvailabilityDAO doctorAvailabilityDao) {
        this.doctorAvailabilityDao = doctorAvailabilityDao;
    }
}