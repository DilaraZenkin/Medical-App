package com.techelevator.controller;

import com.techelevator.dao.AvailabilityDao;
import com.techelevator.model.DoctorAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AvailabilityController {

    @Autowired
    private AvailabilityDao availabilityDao;

    public AvailabilityController(AvailabilityDao availabilityDao) {
        this.availabilityDao = availabilityDao;
    }

    @RequestMapping(path = "/availabilities/{doctorId}", method = RequestMethod.GET)
    public List<DoctorAvailability> allDoctorAvailabilities(@PathVariable Long doctorId) {
        return 
    }
}
