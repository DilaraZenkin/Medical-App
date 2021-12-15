package com.techelevator.dao;

import com.techelevator.model.Office;
import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Review getReviewById(Long reviewId) {
        String sql = "SELECT r.*, p.first_name, p.last_name, d.doctor_last, o.office_address FROM reviews r JOIN patients p ON r.patient_id = p.patient_id \n" +
                "JOIN doctors d ON r.doctor_id = d.doctor_id JOIN offices o ON r.office_id = o.office_id WHERE review_id=?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reviewId);
        if (results.next()) {
            return mapRowToReview(results);
        }
        else {
            throw new RuntimeException("review " + reviewId + " was not found.");
        }
    }

    @Override
    public List<Review> getReviewByOfficeId(Long officeId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT r.*, p.first_name, p.last_name, d.doctor_last, o.office_address FROM reviews r JOIN patients p ON r.patient_id = p.patient_id \n" +
                "JOIN doctors d ON r.doctor_id = d.doctor_id JOIN offices o ON r.office_id = o.office_id WHERE r.office_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        while (results.next()) {
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }
    @Override
    public List<Review> getReviewsByDoctorId(Long doctorId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT r.*, p.first_name, p.last_name, d.doctor_last, o.office_address FROM reviews r JOIN patients p ON r.patient_id = p.patient_id \n" +
                "JOIN doctors d ON r.doctor_id = d.doctor_id JOIN offices o ON r.office_id = o.office_id WHERE r.doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()) {
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByPatientId(Long patientId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT r.*, p.first_name, p.last_name, d.doctor_last, o.office_address FROM reviews r JOIN patients p ON r.patient_id = p.patient_id \n" +
                "JOIN doctors d ON r.doctor_id = d.doctor_id JOIN offices o ON r.office_id = o.office_id WHERE r.patient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        while (results.next()) {
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public Review addNewReview(Review review) {
        String sql = "INSERT INTO reviews (review_id, title, score, patient_id, doctor_id, office_id, review_body)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, review.getReviewId(), review.getTitle(), review.getScore(), review.getPatientId(),review.getDoctorId(), review.getOfficeId(), review.getReviewBody());
        return review;
    }

    @Override
    public Review respondToReview(Review review) {
        String sql = "UPDATE reviews SET response = ? WHERE doctor_id = ?";
        jdbcTemplate.update(sql, review.getResponse(), review.getDoctorId());
        return getReviewById(review.getReviewId());
    }

    private Review mapRowToReview(SqlRowSet rs) {
        Review review = new Review();
        review.setReviewId(rs.getLong("review_id"));
        review.setTitle(rs.getString("title"));
        review.setScore(rs.getInt("score"));
        review.setPatientId(rs.getLong("patient_id"));
        review.setPatientFirst(rs.getString("first_name"));
        review.setPatientLast(rs.getString("last_name"));
        review.setDoctorId(rs.getLong("doctor_id"));
        review.setDoctorLast(rs.getString("doctor_last"));
        review.setOfficeId(rs.getLong("office_id"));
        review.setOfficeAddress(rs.getString("office_address"));
        review.setReviewBody(rs.getString("review_body"));
        review.setResponse(rs.getString("response"));
        return review;
    }


}
