package com.techelevator.dao;

import com.techelevator.model.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcAppointmentDao implements AppointmentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Appointment getAppointmentByAppointmentId(Long appointmentId) {
        String sql = "SELECT * FROM appointments WHERE appointment_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentId);
        if (results.next()) {
            return mapRowToAppointment(results);
        } else {
            throw new RuntimeException("Appointment with the Id of " + appointmentId + " was not found.");
        }
    }

    @Override
    public List<Appointment> getAppointmentListByPatientId(Long patientId) {
        return null;
    }

    @Override
    public List<Appointment> getPatientPastAppointments(Long patientId) {
        return null;
    }

    @Override
    public List<Appointment> getUpcomingPatientAppointments(Long patientId) {
        return null;
    }

    @Override
    public List<Appointment> getAllAppointmentsByDoctorId(Long doctorId) {
        return null;
    }

    @Override
    public List<Appointment> getUpcomingAppointmentsForDoctor(Long doctorId) {
        return null;
    }

    @Override
    public Appointment addNewAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return null;
    }

    private Appointment mapRowToAppointment(SqlRowSet rs) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(rs.getLong("appointment_id"));
        appointment.setOfficeId(rs.getLong("office_id"));
        appointment.setPatientId(rs.getLong("patient_id"));
        appointment.setDoctorId(rs.getLong("doctor_id"));
        appointment.setDayOfAppointment(rs.getDate("appointment_date").toLocalDate());
        appointment.setStartTime(rs.getTime("start_time").toLocalTime());
        appointment.setEndTime(rs.getTime("end_time").toLocalTime());
        return appointment;
    }
}
