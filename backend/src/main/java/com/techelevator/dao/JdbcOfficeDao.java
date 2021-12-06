package com.techelevator.dao;

import com.techelevator.model.Office;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcOfficeDao implements OfficeDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcOfficeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Office> officeInfoByDoctorFirstName() {
        return null;
    }

    @Override
    public List<Office> officeInfoByDoctorLastName() {
        return null;
    }

    @Override
    public List<Office> officeInfoByDoctorFullName() {
        return null;
    }
}
