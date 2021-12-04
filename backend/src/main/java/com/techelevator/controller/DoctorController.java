package com.techelevator.controller;

import com.techelevator.dao.DoctorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DoctorController {

    private DoctorDAO doctorDao;

    @Autowired
    public DoctorController(DoctorDAO doctorDao) {
        this.doctorDao = doctorDao;
    }
}
