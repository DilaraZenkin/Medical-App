package com.techelevator.dao;

import com.techelevator.model.DoctorAvailability;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcDoctorAvailabilityDAO implements DoctorAvailabilityDAO {
    private JdbcTemplate jdbcTemplate;
    public void JdbcDoctorAvailabilityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public DoctorAvailability getDoctorAvailability(long doctorAvailabilityId) {

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


    private DoctorAvailability mapRowToDoctorAvailability(SqlRowSet results) {
        DoctorAvailability availability = new DoctorAvailability();
        availability.setDoctorAvailabilityId(results.getLong("doctor_availability_id"));
        availability.setDoctorOfficeId(results.getLong("office_doctor_id"));
        availability.setDayOfWeek(results.getString("day_of_week"));
        availability.setStartTime(results.getString("start_time"));
        availability.setEndTime(results.getString("end_time"));
        availability.setAvailability(results.getString("availability"));

        return availability;
    }
}
