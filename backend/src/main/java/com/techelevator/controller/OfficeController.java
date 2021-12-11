package com.techelevator.controller;

import com.techelevator.dao.OfficeDAO;
import com.techelevator.model.Office;
import com.techelevator.model.OfficeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class OfficeController {
    //TODO: controller methods to POST/PUT to create/update office. Use dao here
    @Autowired
    private OfficeDAO officeDao;

    public OfficeController(OfficeDAO officeDao) {
        this.officeDao = officeDao;

    }

    @RequestMapping(path = "/offices/{id}", method = RequestMethod.GET)
    public Office get(@PathVariable int id) {
        return officeDao.getOfficeById((long) id);
    }

    @RequestMapping(path = "/offices/(id)", method = RequestMethod.PUT)
    public Office updateOffice(@Valid @RequestBody OfficeDTO officeDTO,
                               @PathVariable long officeId) {
        Office officeToUpdate = new Office(officeDTO, officeId);
        officeDao.updateOffice(officeToUpdate);
        return officeDao.getOfficeById(officeId);
    }

    @RequestMapping(path = "/offices/create", method = RequestMethod.POST)
    public Office addNewOffice(@RequestBody Office office) {
        return officeDao.addNewOffice(office);
    }

    @RequestMapping(path = "/offices/specific/{doctorId}", method = RequestMethod.GET)
    public Office getOfficeByDoctorId(@PathVariable Long doctorId) {
        return officeDao.getOfficeByDoctorId(doctorId);
    }

    @RequestMapping(path = "/offices", method = RequestMethod.GET)
    public List<Office> findAllOffices() {
        return officeDao.findAllOffices();
    }
}
