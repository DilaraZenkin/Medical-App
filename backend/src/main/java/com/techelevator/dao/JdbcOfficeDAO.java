package com.techelevator.dao;

import com.techelevator.model.Office;
import com.techelevator.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOfficeDAO implements OfficeDAO {
    //TODO: method to insert office into office database table
    //TODO: method to update office database table
    //TODO: method to find office in office table
    private JdbcTemplate jdbcTemplate;

    public JdbcOfficeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public int findIdByOfficeAddress(String address) {
        return jdbcTemplate.queryForObject("select office_id from offices where address = ?", int.class, address);
    }

    //TODO: rename columns to what's in the table
    @Override
    public Office getOfficeById(Long officeId) {
        String sql = "SELECT * from offices WHERE office_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        if (results.next()) return mapRowToOffice(results);
        else {
            throw new RuntimeException("officeId " + officeId + " was not found.");
        }
    }

    @Override
    public long create(String officeAddress, String officePhoneNumber, String officeOpen, String officeClose, long hourlyCost) {
        boolean officeCreated = false;
        // create office
        String insertOffice = "insert into offices(office_id, office_address, office_phone_number, office_open, office_close, hourly_cost)" +
                           "values(?,?,?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String id_column = "office_id";
        officeCreated = jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(insertOffice, new String[]{id_column});
                    ps.setString(1, officeAddress);
                    ps.setString(2, officePhoneNumber);
                    ps.setString(3, officeOpen);
                    ps.setString(4, officeClose);
                    ps.setLong(5, hourlyCost);
                    return ps;
                }
                , keyHolder) == 1;
        int newOfficeId = (int) keyHolder.getKeys().get(id_column);

        return newOfficeId;
    }

    @Override
    public Office addNewOffice(Office office) {
        String sql = "INSERT INTO offices (office_id, office_name, office_address, office_phone_number, office_open, office_close, hourly_cost)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, office.getOfficeId(), office.getOfficeAddress(), office.getOfficePhoneNumber(), office.getOfficeOpen(), office.getOfficeClose(), office.getHourlyCost());
        return office;
    }

    @Override
    public Office updateOffice(Office office) {

        String sql = "UPDATE offices SET office_name = ?, office_address=?, office_phone_number=?, office_open=?, office_close=?, hourly_cost=? WHERE office_id=?";
        jdbcTemplate.update(sql, office.getOfficeName(), office.getOfficeAddress(), office.getOfficePhoneNumber(), office.getOfficeOpen(), office.getOfficeClose(), office.getHourlyCost(), office.getOfficeId());
        return office;
    }

    @Override
    public List<Office> findAllOffices() {
        List<Office> offices = new ArrayList<>();
        String sql = "select * from offices";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Office office = mapRowToOffice(results);
            offices.add(office);
        }
        return offices;
    }

    @Override
    public Office getOfficeByDoctorId(Long doctorId) {
        String sql = "SELECT o.office_id, o.office_name, o.office_address, o.office_phone_number, o.office_open, \n" +
                "o.office_close, o.hourly_cost FROM offices o JOIN doctors USING (office_id) WHERE doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        if (results.next()) {
            return mapRowToOffice(results);
        }
        else {
            throw new RuntimeException("Could not retrieve office information.");
        }
    }

    private Office mapRowToOffice(SqlRowSet rs) {
        Office office = new Office();
        office.setOfficeId(rs.getLong("office_id"));
        office.setOfficeName(rs.getString("office_name"));
        office.setOfficeAddress(rs.getString("office_address"));
        office.setOfficePhoneNumber(rs.getString("office_phone_number"));
        office.setOfficeOpen(rs.getTime("office_open").toLocalTime());
        office.setOfficeClose(rs.getTime("office_close").toLocalTime());
        office.setHourlyCost(rs.getLong("hourly_cost"));
        return office;
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
