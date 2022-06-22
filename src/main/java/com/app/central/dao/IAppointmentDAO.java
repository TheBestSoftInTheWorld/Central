package com.app.central.dao;

import com.app.central.jpa.AppointmentEntity;

import java.util.Optional;

public interface IAppointmentDAO {
    void saveAppointment(AppointmentEntity entity);

    Optional<AppointmentEntity> findAppointment(long companyId, long remoteAppointmentId);
}
