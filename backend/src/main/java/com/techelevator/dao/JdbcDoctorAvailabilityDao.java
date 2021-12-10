package com.techelevator.dao;

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
        String sql = "SELECT doctor_availability_id, office_doctor_id, day_of_week, start_time, end_time, availability " +
                "FROM doctor_availability " +
                "WHERE doctor_availability_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorAvailabilityId);
        if (results.next()) {
            availability = mapRowToDoctorAvailability(results);
        }
        return availability;
    }

    @Override
    public DoctorAvailability getAvailabilityByDoctorId(Long doctorId) {
        return null;
    }

    private DoctorAvailability mapRowToDoctorAvailability(SqlRowSet results) {
        DoctorAvailability availability = new DoctorAvailability();
        availability.setDoctorAvailabilityId(results.getLong("doctor_availability_id"));
        availability.setDoctorId(results.getLong("doctor_id"));
        availability.setDayOfWeek(results.getDate("day_of_week").toLocalDate());
        availability.setStartTime(results.getTime("start_time").toLocalTime());
        availability.setEndTime(results.getTime("end_time").toLocalTime());
        availability.setAvailable(results.getBoolean("availability"));

        return availability;
    }
}
