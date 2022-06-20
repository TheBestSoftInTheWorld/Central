package com.app.central.service;

import com.app.central.dao.IAppointmentDAO;
import com.app.central.jpa.AppointmentEntity;
import com.app.central.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    IAppointmentDAO iAppointmentDAO;


    @Override
    public List<Long> saveAppointments(List<Appointment> appointments) {
        List<Long> ids = new ArrayList<>();
        appointments.stream().forEach(tmp -> ids.add(saveAppointments(tmp)));
        return ids;
    }

    @Override
    public long saveAppointments(Appointment appointment) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setId(appointment.getId());
        appointmentEntity.setAppointmentTime(appointment.getAppointmentTime());
        appointmentEntity.setPersonId(appointment.getPersonId());
        appointmentEntity.setModified(appointment.getModified());
        appointmentEntity.setReason(appointment.getReason());
        appointmentEntity.setState(appointment.getState());
        return iAppointmentDAO.saveAppointments(appointmentEntity);
    }
}
