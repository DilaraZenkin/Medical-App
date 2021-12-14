package com.techelevator.controller;

import com.techelevator.dao.DoctorAvailabilityDao;
import com.techelevator.model.DoctorAvailability;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CalendarController {
    private DoctorAvailabilityDao doctorAvailabilityDao;

    public CalendarController(DoctorAvailabilityDao doctorAvailabilityDao) {
        this.doctorAvailabilityDao = doctorAvailabilityDao;
    }

    @RequestMapping(path = "/availability/{availabilityId}", method = RequestMethod.GET)
    public DoctorAvailability getSingleAvailability(@PathVariable Long availabilityId) {
        return doctorAvailabilityDao.getDoctorAvailability(availabilityId);
    }
}