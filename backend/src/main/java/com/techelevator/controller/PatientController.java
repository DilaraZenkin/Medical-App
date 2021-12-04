package com.techelevator.controller;

import com.techelevator.dao.PatientDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PatientController {

    private PatientDAO patientDao;

    public PatientController(PatientDAO patientDao) {
        this.patientDao = patientDao;
    }
}
