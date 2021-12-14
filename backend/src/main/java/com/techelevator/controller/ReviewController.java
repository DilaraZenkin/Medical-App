package com.techelevator.controller;

import com.techelevator.dao.ReviewDAO;
import com.techelevator.model.Office;
import com.techelevator.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(path = "/reviews/office/{officeId}", method = RequestMethod.GET)
    public List<Review> reviewsByOffice(@PathVariable Long officeId) {
        return reviewDao.getReviewByOfficeId(officeId);
    }

    @RequestMapping(path = "/reviews/doctor/{doctorId}", method = RequestMethod.GET)
    public List<Review> reviewsByDoctor(@PathVariable Long doctorId) {
        return reviewDao.getReviewsByDoctorId(doctorId);
    }

    @RequestMapping(path = "/reviews/patient/{patientId}", method = RequestMethod.GET)
    public List<Review> reviewsByPatient(@PathVariable Long patientId) {
        return reviewDao.getReviewsByPatientId(patientId);
    }

    @RequestMapping(path = "/reviews/new", method = RequestMethod.POST)
    public Review addNewReview(@RequestBody Review review) {
        return reviewDao.addNewReview(review);
    }

    @RequestMapping(path = "reviews/doctor/respond", method = RequestMethod.PUT)
    public Review respondToReview(@RequestBody Review review) {
        return reviewDao.respondToReview(review);
    }
}