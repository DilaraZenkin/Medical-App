package com.techelevator.dao;

import com.techelevator.model.Office;
import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDAO {
    Review getReviewById(Long reviewId);

    List<Review> getReviewByOfficeId(Long officeId);

    List<Review> getReviewsByDoctorId(Long doctorId);

    List<Review> getReviewsByPatientId(Long patientId);

    Review addNewReview(Review review);

    Review respondToReview(Review review);
}
