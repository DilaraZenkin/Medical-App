package com.techelevator.controller;

import com.techelevator.dao.DoctorAvailabilityDAO;
import com.techelevator.dao.DoctorDAO;
import com.techelevator.dao.PatientDAO;
import com.techelevator.model.DoctorAvailability;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CalendarController {
    private DoctorAvailabilityDAO doctorAvailabilityDao;

    public CalendarController(DoctorAvailabilityDAO doctorAvailabilityDao) {
        this.doctorAvailabilityDao = doctorAvailabilityDao;
    }
}