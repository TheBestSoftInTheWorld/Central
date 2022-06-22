package com.app.central.service;

import com.app.central.dao.IAppointmentDAO;
import com.app.central.jpa.AppointmentEntity;
import com.app.central.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    IAppointmentDAO iAppointmentDAO;


    @Override
    public void saveAppointments(List<Appointment> appointments) {
        appointments.stream().forEach(appointment -> saveAppointment(appointment));
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setId(appointment.getId());
        appointmentEntity.setAppointmentTime(appointment.getAppointmentTime());
        appointmentEntity.setPersonId(appointment.getPersonId());
        appointmentEntity.setModified(appointment.getModified());
        appointmentEntity.setReason(appointment.getReason());
        appointmentEntity.setState(appointment.getState());
        appointmentEntity.setRemoteAppointmentId(appointment.getRemoteAppointmentId());
        appointmentEntity.setCompanyId(appointment.getCompanyId());
        iAppointmentDAO.saveAppointment(appointmentEntity);
    }
}
