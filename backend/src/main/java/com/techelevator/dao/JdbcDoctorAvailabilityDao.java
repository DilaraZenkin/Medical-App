package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorAvailability;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcDoctorAvailabilityDao implements DoctorAvailabilityDao {
    private JdbcTemplate jdbcTemplate;
    public void JdbcDoctorAvailabilityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DoctorAvailability getDoctorAvailability(Long doctorAvailabilityId) {
        DoctorAvailability availability = null;
        String sql = "SELECT da.* d.* FROM doctor_availabilities da JOIN doctors d USING (doctor_id)\n" +
                "WHERE doctor_availability_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorAvailabilityId);
        if (results.next()) {
            return mapRowToDoctorAvailability(results);
        } else {
            throw new RuntimeException("Something went wrong.");
        }
    }

    @Override
    public DoctorAvailability getAvailabilityByDoctorId(Long doctorId) {
        return null;
    }

    private DoctorAvailability mapRowToDoctorAvailability(SqlRowSet results) {
        Doctor doctor = new Doctor();
        DoctorAvailability availability = new DoctorAvailability();
        availability.setDoctorAvailabilityId(results.getLong("doctor_availability_id"));
        availability.setDayOfWeek(results.getDate("day_of_week").toLocalDate());
        availability.setStartTime(results.getTime("start_time").toLocalTime());
        availability.setEndTime(results.getTime("end_time").toLocalTime());
        availability.setAvailable(results.getBoolean("available"));
        doctor.setDoctorId(results.getLong("doctor_id"));
        doctor.setFirstName(results.getString("doctor_first"));
        doctor.setLastName(results.getString("doctor_last"));
        doctor.setDateOfBirth(results.getDate("date_of_birth").toLocalDate());
        doctor.setOfficeId(results.getLong("office_id"));
        return availability;
    }
}
