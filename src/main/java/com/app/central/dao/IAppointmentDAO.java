package com.app.central.dao;

import com.app.central.jpa.AppointmentEntity;

public interface IAppointmentDAO {
    void persistAppointment(AppointmentEntity entity);
}
