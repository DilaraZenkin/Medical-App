package com.techelevator.controller;

import com.techelevator.dao.PatientDAO;
import com.techelevator.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientDAO patientDao;

    public PatientController(PatientDAO patientDao) {
        this.patientDao = patientDao;
    }

    @RequestMapping(path = "/patients", method = RequestMethod.GET)
    public List<Patient> findAllPatients() {
        return patientDao.findAllPatients();
    }
}
