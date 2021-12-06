package com.techelevator.controller;

import com.techelevator.dao.DoctorDAO;
import com.techelevator.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorDAO doctorDao;

    public DoctorController(DoctorDAO doctorDao) {
        this.doctorDao = doctorDao;
    }

    @RequestMapping(path = "/doctors", method = RequestMethod.GET)
    public List<Doctor> findAllDoctors() {
        return doctorDao.findAllDoctors();
    }

    @RequestMapping(path = "/doctor/{doctorId}", method = RequestMethod.GET)
    public Doctor getDoctorByDoctorId(@PathVariable Long doctorId) {
        return doctorDao.getDoctorByDoctorId(doctorId);
    }

    @RequestMapping(path = "/doctors/{officeId}", method = RequestMethod.GET)
    public List<Doctor> findAllDoctorsAtOffice(@PathVariable Long officeId) {
        return doctorDao.getAllDoctorsAtOffice(officeId);
    }
}
