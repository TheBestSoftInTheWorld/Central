package com.app.central.service;

import com.app.central.dao.IAppointmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    IAppointmentDAO iAppointmentDAO;
}
