package com.app.central.service;

import com.app.central.dao.IAppointmentDAO;
import com.app.central.jpa.AppointmentEntity;
import com.app.central.model.Appointment;
import com.app.central.model.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    IAppointmentDAO iAppointmentDAO;


    @Override
    public void persistAppointment(Appointment appointment) {
        AppointmentEntity appointmentEntity= new AppointmentEntity();
        appointmentEntity.setId(appointment.getId());
        appointmentEntity.setAppointmentTime(appointment.getAppointmentTime());
        appointmentEntity.setPersonId(appointment.getPersonId());
        appointmentEntity.setModified(appointment.getModified());
        appointmentEntity.setReason(appointment.getReason());
        appointmentEntity.setState(appointment.getState());
        iAppointmentDAO.persistAppointment(appointmentEntity);
    }
}
