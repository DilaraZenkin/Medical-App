package com.techelevator.dao;

import com.techelevator.model.DoctorAvailability;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface DoctorAvailabilityDAO {
    DoctorAvailability getDoctorAvailability(long doctorAvailabilityId);
}
