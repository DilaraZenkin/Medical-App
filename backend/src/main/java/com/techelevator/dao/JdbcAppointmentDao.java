package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentDTO;
import com.techelevator.model.Doctor;
import com.techelevator.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAppointmentDao implements AppointmentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public AppointmentDTO getAppointmentByAppointmentId(Long appointmentId) {
        String sql = "SELECT * FROM appointments WHERE appointment_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentId);
        if (results.next()) {
            return mapRowToAppointmentDTO(results);
        } else {
            throw new RuntimeException("Appointment with the Id of " + appointmentId + " was not found.");
        }
    }

    @Override
    public List<Appointment> getAppointmentListByPatientId(Long patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE patient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        while (results.next()) {
            Appointment appointment = mapRowToAppointment(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public List<Appointment> getPatientPastAppointments(Long patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE patient_id = ? AND appointment_date < CURRENT_TIMESTAMP;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        while (results.next()) {
            Appointment appointment = mapRowToAppointment(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public List<Appointment> getUpcomingPatientAppointments(Long patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE patient_id = ? AND appointment_date >= CURRENT_TIMESTAMP;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        while (results.next()) {
            Appointment appointment = mapRowToAppointment(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public List<AppointmentDTO> getAllAppointmentsByDoctorId(Long doctorId) {
        List<AppointmentDTO> appointments = new ArrayList<>();
        String sql = "SELECT appointment_id, appointment_date, start_time, p.patient_id, first_name, last_name, d.doctor_id, doctor_last, office_address \n" +
                "FROM appointments a JOIN patients p ON a.doctor_id = p.doctor_id JOIN doctors d ON a.doctor_id = d.doctor_id \n" +
                "JOIN offices o ON a.office_id = o.office_id WHERE a.doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()) {
            AppointmentDTO appointment = mapRowToAppointmentDTO(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public List<Appointment> getUpcomingAppointmentsForDoctor(Long doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE doctor_id = ? AND appointment_date >= CURRENT_TIMESTAMP;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()) {
            Appointment appointment = mapRowToAppointment(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public AppointmentDTO addNewAppointment(Appointment appointment) {

        String sql = "INSERT INTO appointments (office_id, patient_id, doctor_id, appointment_date, start_time, end_time)\n" +
                "VALUES (?, ?, ?, ?, ?, ?) returning appointment_id;";

        Long appointmentId = jdbcTemplate.queryForObject(sql, Long.class, appointment.getOfficeId(), appointment.getPatientId(), appointment.getDoctorId(), appointment.getDayOfAppointment(), appointment.getStartTime(), appointment.getEndTime());
        return getAppointmentByAppointmentId(appointmentId);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
       String sql = "UPDATE appointments SET office_id = ?, patient_id = ?, doctor_id = ?, appointment_date = ?, start_time = ?, end_time = ?\n" +
               "WHERE appointment_id = ?;";
       jdbcTemplate.update(sql, appointment.getOfficeId(), appointment.getPatientId(), appointment.getDoctorId(), appointment.getDayOfAppointment(), appointment.getStartTime(), appointment.getEndTime(), appointment.getAppointmentId());
       return appointment;
    }

    @Override
    public AppointmentDTO formatTest(Long appointmentId) {
        String sql = "SELECT p.first_name AS patient_first, p.last_name AS patient_last, o.office_address, a.appointment_date, a.start_time, d.first_name AS doctor_first, d.last_name AS doctor_last FROM appointments a\n" +
                "JOIN patients p USING (patient_id) JOIN offices o USING (office_id) JOIN doctors d ON d.doctor_id = a.doctor_id WHERE a.appointment_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentId);
        if (results.next()) {
            return mapRowToAppointmentDTO(results);
        } else {
            throw new RuntimeException("Appointment with the Id of " + appointmentId + " was not found.");
        }
    }

    @Override
    public String cancelAppointment(Long appointmentId) {
        String sql = "DELETE from appointments WHERE appointment_id = ?;";
        jdbcTemplate.update(sql, appointmentId);
        return "success";
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

    private AppointmentDTO mapRowToAppointmentDTO(SqlRowSet rs) {
        AppointmentDTO test = new AppointmentDTO();
        Patient patient = new Patient();
        Doctor doctor = new Doctor();

        test.setAppointmentId(rs.getLong("appointment_id"));
        test.setAppointmentDate(rs.getDate("appointment_date").toLocalDate());
        test.setStartTime(rs.getTime("start_time").toLocalTime());
        patient.setPatientId(rs.getLong("patient_id"));
       // patient.setFirstName(rs.getString("first_name"));
       // patient.setLastName(rs.getString("last_name"));
       // test.setPatient(patient);
        doctor.setDoctorId(rs.getLong("doctor_id"));
     //   doctor.setLastName(rs.getString("doctor_last"));
     //  test.setDoctor(doctor);
      //  test.setAddress(rs.getString("office_address"));
        return test;
    }
}
