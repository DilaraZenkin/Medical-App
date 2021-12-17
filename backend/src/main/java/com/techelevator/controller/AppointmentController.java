package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class AppointmentController {

    @Autowired
    private AppointmentDao appointmentDao;

    public AppointmentController(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @RequestMapping(path = "/appointments/{appointmentId}", method = RequestMethod.GET)
    public AppointmentDTO getSpecificAppointment(@PathVariable Long appointmentId) {
        return appointmentDao.getAppointmentByAppointmentId(appointmentId);
    }

    @RequestMapping(path = "/appointments/patient/{patientId}", method = RequestMethod.GET)
    public List<Appointment> getPatientsFullAppointmentList(@PathVariable Long patientId) {
        return appointmentDao.getAppointmentListByPatientId(patientId);
    }

    @RequestMapping(path = "/appointments/patient/{patientId}/past", method = RequestMethod.GET)
    public List<Appointment> getPatientPastAppointments(@PathVariable Long patientId) {
        return appointmentDao.getPatientPastAppointments(patientId);
    }

    @RequestMapping(path = "/appointments/patient/{patientId}/active", method = RequestMethod.GET)
    public List<Appointment> getUpcomingPatientAppointments(@PathVariable Long patientId) {
        return appointmentDao.getUpcomingPatientAppointments(patientId);
    }

    @RequestMapping(path = "/appointments/doctor/{doctorId}", method = RequestMethod.GET)
    public List<AppointmentDTO> getDoctorFullAppointmentList(@PathVariable Long doctorId) {
        return appointmentDao.getAllAppointmentsByDoctorId(doctorId);
    }

    @RequestMapping(path = "/appointments/doctor/{doctorId}/active", method = RequestMethod.GET)
    public List<Appointment> getUpcomingDoctorAppointments(@PathVariable Long doctorId) {
        return appointmentDao.getUpcomingAppointmentsForDoctor(doctorId);
    }
    @RequestMapping(path = "/appointments/add", method = RequestMethod.POST)
    public boolean addNewAppointment(@Valid @RequestBody Appointment appointment) {
        return appointmentDao.addNewAppointment(appointment);
    }
    @RequestMapping(path = "/appointments/{appointmentId}", method = RequestMethod.DELETE)
    public String cancelAppointment(@PathVariable Long appointmentId) {
        return appointmentDao.cancelAppointment(appointmentId);
    }

    @RequestMapping(path = "/appointments/edit/", method = RequestMethod.PUT)
    public Appointment updateAppointment(@RequestBody Appointment appointment) {
        return appointmentDao.updateAppointment(appointment);
    }



    @RequestMapping(path = "/appointments/test/{appointmentId}", method = RequestMethod.GET)
    public AppointmentDTO testFormat(@PathVariable Long appointmentId) {
        return appointmentDao.formatTest(appointmentId);
    }

    @RequestMapping(path = "/appointments/delete/{appointmentId}", method = RequestMethod.DELETE)
    public boolean deleteAppointment(@PathVariable Long appointmentId) {
        return appointmentDao.deleteAppointment(appointmentId);
    }

}
