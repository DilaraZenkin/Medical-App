package com.techelevator.model;

import java.time.LocalTime;

public class Review extends Office {
    private long reviewId;
    private String title;
    private int score;
    private long patientId;
    private long doctorId;
    private long officeId;
    private String reviewBody;
    private String response;

    public Review () {

    }

    public Review(ReviewDTO dto, long reviewId) {
        this.reviewId = reviewId;
        this.title = dto.getTitle();
        this.score = dto.getScore();
        this.patientId = dto.getPatientId();
        this.doctorId = dto.getDoctorId();
        this.officeId = dto.getOfficeId();
        this.reviewBody = dto.getReviewBody();
        this.response = dto.getResponse();

    }

    public Review(Long reviewId,String title, int score, Long patientId,Long doctorId,Long officeId,String reviewBody, String response){
        this.reviewId = reviewId;
        this.title = title;
        this.score = score;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.officeId = officeId;
        this.reviewBody = reviewBody;
        this.response = response;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

