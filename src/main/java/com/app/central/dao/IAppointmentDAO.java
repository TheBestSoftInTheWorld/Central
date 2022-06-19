package com.app.central.dao;

import com.app.central.jpa.AppointmentEntity;

public interface IAppointmentDAO {
    long persistAppointment(AppointmentEntity entity);
}
