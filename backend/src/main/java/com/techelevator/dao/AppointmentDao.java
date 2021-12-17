package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentDTO;

import java.util.List;

public interface AppointmentDao {

    AppointmentDTO getAppointmentByAppointmentId(Long appointmentId);

    List<Appointment> getAppointmentListByPatientId(Long patientId);

    List<Appointment> getPatientPastAppointments(Long patientId);

    List<Appointment> getUpcomingPatientAppointments(Long patientId);

    List<AppointmentDTO> getAllAppointmentsByDoctorId(Long doctorId);

    List<Appointment> getUpcomingAppointmentsForDoctor(Long doctorId);

    AppointmentDTO addNewAppointment(Appointment appointment);

    Appointment updateAppointment(Appointment appointment);

    AppointmentDTO formatTest(Long appointmentId);

    String cancelAppointment(Long appointmentId);
}
