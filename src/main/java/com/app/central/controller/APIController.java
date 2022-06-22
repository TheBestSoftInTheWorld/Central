package com.app.central.controller;

import com.app.central.model.Appointment;
import com.app.central.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("api/")
public class APIController {
    @Autowired
    private IAppointmentService iAppointmentService;

    @RequestMapping(method = RequestMethod.POST, value = "saveAppointments")
    @ResponseBody
    public ResponseEntity saveAppointments(@RequestBody List<Appointment> appointments) {
        try {
            iAppointmentService.saveAppointments(appointments);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
