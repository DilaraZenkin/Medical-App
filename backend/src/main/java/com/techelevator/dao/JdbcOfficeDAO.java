package com.techelevator.dao;

import com.techelevator.model.Office;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.PreparedStatement;
import java.util.List;

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
    public long create(String officeAddress, String officePhonenumber, String officeOpen, String officeClose, long hourlyCost) {
        boolean officeCreated = false;
        // create office
        String insertOffice = "insert into offices(address,) values(?,?,?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String id_column = "office_id";
        officeCreated = jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(insertOffice, new String[]{id_column});
                    ps.setString(1, officeAddress);
                    ps.setString(2, officePhonenumber);
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
    public boolean updateOffice(Office office) {

        String sql = "UPDATE offices SET office_address=?, office_phone_number=?, office_open=?, office_close=? WHERE office_id=?";
        boolean officeUpdated = jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, office.getOfficeAddress());
            ps.setString(2, office.getOfficePhoneNumber());
            ps.setString(3, office.getOfficeOpen());
            ps.setString(3, office.getOfficeClose());
            ps.setLong(5, office.getOfficeId());
            return ps;
        }) == 1;

        return officeUpdated;
    }


    private Office mapRowToOffice(SqlRowSet rs) {
        Office office = new Office();
        office.setOfficeId(rs.getLong("office_id"));
        office.setOfficeAddress(rs.getString("address"));
        office.setOfficePhoneNumber(rs.getString("phonenumber"));
        office.setOfficeOpen(rs.getString("officeOpen"));
        office.setOfficeClose(rs.getString("officeClose"));
        office.setHourlyCost(rs.getLong("hourlyCost"));
        // office.setActivated(true);
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