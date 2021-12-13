package com.techelevator.dao;

import com.techelevator.model.Office;
import com.techelevator.model.Review;

public interface ReviewDAO {
    Review getReviewById(Long reviewId);

    Review getReviewByOfficeId(Long officeId);

    Review addNewReview(Review review);
}
