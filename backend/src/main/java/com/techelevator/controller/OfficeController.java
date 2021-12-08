package com.techelevator.controller;

import com.techelevator.dao.OfficeDAO;
import com.techelevator.model.Office;
import com.techelevator.model.OfficeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class OfficeController {
    //TODO: controller methods to POST/PUT to create/update office. Use dao here
    @Autowired
    private OfficeDAO officeDao;

    public OfficeController(OfficeDAO officeDao) {
        this.officeDao = officeDao;

    }

    @RequestMapping(path = "/office/{id}", method = RequestMethod.GET)
    public Office get(@PathVariable int id) {
        return officeDao.getOfficeById((long) id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/office", method = RequestMethod.POST)
    public Office addOffice(@Valid @RequestBody OfficeDTO officeDTO)
            throws RuntimeException {
        long officeId = officeDao.create(officeDTO.getAddress(), officeDTO.getOfficePhoneNumber(), officeDTO.getOfficeOpen(), officeDTO.getOfficeClose(), officeDTO.getHourlyCost());
        return officeDao.getOfficeById(officeId);
    }

    @RequestMapping(path = "/office/(id)", method = RequestMethod.PUT)
    public Office updateOffice(@Valid @RequestBody OfficeDTO officeDTO,
                               @PathVariable long officeId) {
        Office officeToUpdate = new Office(officeDTO, officeId);
        officeDao.updateOffice(officeToUpdate);
        return officeDao.getOfficeById(officeId);
    }

}
