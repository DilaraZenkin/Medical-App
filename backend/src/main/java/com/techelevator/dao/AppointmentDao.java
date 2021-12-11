package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.TestAppointment;

import java.util.List;

public interface AppointmentDao {

    Appointment getAppointmentByAppointmentId(Long appointmentId);

    List<Appointment> getAppointmentListByPatientId(Long patientId);

    List<Appointment> getPatientPastAppointments(Long patientId);

    List<Appointment> getUpcomingPatientAppointments(Long patientId);

    List<Appointment> getAllAppointmentsByDoctorId(Long doctorId);

    List<Appointment> getUpcomingAppointmentsForDoctor(Long doctorId);

    Appointment addNewAppointment(Appointment appointment);

    Appointment updateAppointment(Appointment appointment);

    TestAppointment formatTest(Long appointmentId);
}
