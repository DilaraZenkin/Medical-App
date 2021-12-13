package com.techelevator.controller;

import com.techelevator.dao.PatientDAO;
import com.techelevator.model.Patient;
import com.techelevator.model.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/patients/{patientId}", method = RequestMethod.GET)
    public PatientDTO getPatientByPatientId(@PathVariable Long patientId) {
        return patientDao.getPatientByPatientId(patientId);
    }

    @RequestMapping(path = "/patients/doctor/{doctorId}", method = RequestMethod.GET)
    public List<Patient> getAllPatientsByDoctorId(@PathVariable Long doctorId) {
        return patientDao.getPatientListByDoctorId(doctorId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/patients/register", method = RequestMethod.POST)
    public Patient addPatient(@RequestBody Patient patient) {
        return patientDao.register(patient);
    }

    @RequestMapping(path = "/patients/update", method = RequestMethod.PUT)
    public PatientDTO updatePatientInformation(@RequestBody PatientDTO patient) {
        return patientDao.updatePatientInformation(patient);
    }
}

