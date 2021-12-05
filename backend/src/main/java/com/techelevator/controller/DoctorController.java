package com.techelevator.controller;

import com.techelevator.dao.DoctorDAO;
import com.techelevator.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
