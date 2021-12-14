package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorAvailability;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAvailabilityDao implements AvailabilityDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAvailabilityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DoctorAvailability> getAvailabilityForDoctor(Long doctorId) {
        List<DoctorAvailability> availabilities = new ArrayList<>();
        String sql = "SELECT da.availability_id, da.day_of_week, da.start_time, da.end_time, da.available, d.doctor_id, " +
                "d.doctor_last, d.office_id from doctor_availabilities da join doctors d using (doctor_id) WHERE da.doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()) {
            DoctorAvailability availability = mapRowToDoctorAvailability(results);
            availabilities.add(availability);
        }
        return availabilities;
    }

    @Override
    public DoctorAvailability setAvailableHours(Long doctorId) {
        return null;
    }

    @Override
    public DoctorAvailability updateAvailability(Long doctorId) {
        return null;
    }

    public DoctorAvailability mapRowToDoctorAvailability(SqlRowSet rs) {
        DoctorAvailability availability = new DoctorAvailability();
        Doctor doctor = new Doctor();
        availability.setAvailabilityId(rs.getLong("availability_id"));
        availability.setDayOfWeek(rs.getDate("day_of_week").toLocalDate());
        availability.setStartTime(rs.getTime("start_time").toLocalTime());
        availability.setEndTime(rs.getTime("end_time").toLocalTime());
        doctor.setDoctorId(rs.getLong("doctor_id"));
        doctor.setLastName(rs.getString("doctor_last"));
        doctor.setOfficeId(rs.getLong("office_id"));
        availability.setDoctor(doctor);
        return availability;
    }
}
