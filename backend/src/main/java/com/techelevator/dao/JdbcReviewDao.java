package com.techelevator.dao;

import com.techelevator.model.Office;
import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcReviewDao implements ReviewDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Review getReviewById(Long reviewId) {
        String sql = "SELECT * from reviews WHERE review_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reviewId);
        if (results.next()) return mapRowToReview(results);
        else {
            throw new RuntimeException("review " + reviewId + " was not found.");
        }
    }


    @Override
    public Review getReviewByOfficeId(Long officeId) {
        String sql = "SELECT * from reviews WHERE office_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        if (results.next()) return mapRowToReview(results);
        else {
            throw new RuntimeException("review " + officeId + " was not found.");
        }
    }

    @Override
    public Review addNewReview(Review review) {
        String sql = "INSERT INTO reviews (review_id, title, score, patient_id, doctor_id, office_id, review_body, response)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, review.getReviewId(), review.getTitle(), review.getScore(), review.getPatientId(),review.getDoctorId(), review.getOfficeId(), review.getReviewBody(), review.getResponse());
        return review;
    }


    private Review mapRowToReview(SqlRowSet rs) {
        Review review = new Review();
        review.setReviewId(rs.getLong("review_id"));
        review.setTitle(rs.getString("title"));
        review.setScore(rs.getInt("score"));
        review.setPatientId(rs.getLong("patient_id"));
        review.setDoctorId(rs.getLong("doctor_id"));
        review.setOfficeId(rs.getLong("office_id"));
        review.setReviewBody(rs.getString("review_body"));
        review.setResponse(rs.getString("response"));


        return review;
    }


}
