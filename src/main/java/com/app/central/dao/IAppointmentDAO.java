package com.app.central.dao;

import com.app.central.jpa.AppointmentEntity;

import java.util.Optional;

public interface IAppointmentDAO {
    Long saveAppointment(AppointmentEntity entity);

    Optional<AppointmentEntity> findAppointment(long companyId, long remoteAppointmentId);
}
