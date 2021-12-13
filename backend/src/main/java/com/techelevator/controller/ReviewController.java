package com.techelevator.controller;

import com.techelevator.dao.ReviewDAO;
import com.techelevator.model.Office;
import com.techelevator.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReviewController {
    @Autowired
    private ReviewDAO reviewDao;

    public ReviewController(ReviewDAO reviewDao) {
        this.reviewDao = reviewDao;
    }

    @RequestMapping(path = "/reviews/{id}", method = RequestMethod.GET)
    public Review get(@PathVariable int id) {
        return reviewDao.getReviewById((long) id);
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public Review addNewReview(@RequestBody Review review) {
        return reviewDao.addNewReview(review);

    }
}