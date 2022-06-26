package com.app.central.service;

import com.app.central.dao.IAppointmentDAO;
import com.app.central.jpa.AppointmentEntity;
import com.app.central.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    IAppointmentDAO iAppointmentDAO;

    @Override
    public List<Long> saveAppointments(List<Appointment> appointments) {
        List<Long> ids = new ArrayList<>();
        appointments.stream().forEach(appointment -> ids.add(saveAppointment(appointment)));
        return ids;
    }

    @Override
    public Long saveAppointment(Appointment appointment) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setId(appointment.getId());
        appointmentEntity.setAppointmentTime(appointment.getAppointmentTime());
        appointmentEntity.setPersonId(appointment.getPersonId());
        appointmentEntity.setModified(appointment.getModified());
        appointmentEntity.setReason(appointment.getReason());
        appointmentEntity.setState(appointment.getState());
        appointmentEntity.setRemoteAppointmentId(appointment.getRemoteAppointmentId());
        appointmentEntity.setCompanyId(appointment.getCompanyId());
        return iAppointmentDAO.saveAppointment(appointmentEntity);
    }
    @Override
    public void removeAppointment(long companyId, long remoteAppointmentId){
        Optional<AppointmentEntity> appointmentEntity =iAppointmentDAO.findAppointment(companyId, remoteAppointmentId);
        if(appointmentEntity.isPresent()){
            iAppointmentDAO.removeAppointment(appointmentEntity.get());
        }
    }
}
