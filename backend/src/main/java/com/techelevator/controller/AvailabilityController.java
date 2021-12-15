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
        return availabilityDao.getAvailabilityForDoctor(doctorId);
    }

    @RequestMapping(path = "/availabilities/add", method = RequestMethod.POST)
    public boolean addAvailability(@RequestBody DoctorAvailability availability) {
        return availabilityDao.setAvailableHours(availability);
    }

    @RequestMapping(path = "/availabilities/update", method = RequestMethod.PUT)
    public boolean updateAvailabilityStatus(@RequestBody DoctorAvailability availability) {
        return availabilityDao.updateAvailability(availability);
    }
}
