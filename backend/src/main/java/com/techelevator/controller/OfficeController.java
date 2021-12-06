package com.techelevator.controller;


import com.techelevator.dao.OfficeDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OfficeController {

    @Autowired
    private OfficeDAO officeDao;

    public OfficeController(OfficeDAO officeDao) {
        this.officeDao = officeDao;
    }


}
