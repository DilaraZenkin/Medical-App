package com.techelevator.model;

import java.time.LocalTime;

public class Review {
    private long reviewId;
    private String title;
    private int score;
    private long patientId;
    private String patientFirst;
    private String patientLast;
    private long doctorId;
    private String doctorLast;
    private long officeId;
    private String officeAddress;
    private String reviewBody;
    private String response;

    public Review() {
    }

    public Review(long reviewId, String title, int score, long patientId, String patientFirst, String patientLast, long doctorId, String doctorLast, long officeId, String officeAddress, String reviewBody, String response) {
        this.reviewId = reviewId;
        this.title = title;
        this.score = score;
        this.patientId = patientId;
        this.patientFirst = patientFirst;
        this.patientLast = patientLast;
        this.doctorId = doctorId;
        this.doctorLast = doctorLast;
        this.officeId = officeId;
        this.officeAddress = officeAddress;
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

    public String getPatientFirst() {
        return patientFirst;
    }

    public void setPatientFirst(String patientFirst) {
        this.patientFirst = patientFirst;
    }

    public String getPatientLast() {
        return patientLast;
    }

    public void setPatientLast(String patientLast) {
        this.patientLast = patientLast;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorLast() {
        return doctorLast;
    }

    public void setDoctorLast(String doctorLast) {
        this.doctorLast = doctorLast;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
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

