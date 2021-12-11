package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AppointmentController {

    @Autowired
    private AppointmentDao appointmentDao;

    public AppointmentController(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @RequestMapping(path = "/appointments/{appointmentId}", method = RequestMethod.GET)
    public Appointment getSpecificAppointment(@PathVariable Long appointmentId) {
        return appointmentDao.getAppointmentByAppointmentId(appointmentId);
    }

}
