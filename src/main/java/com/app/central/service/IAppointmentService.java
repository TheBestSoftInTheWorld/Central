package com.app.central.service;

import com.app.central.model.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Long> saveAppointments(List<Appointment> appointments);

    Long saveAppointment(Appointment appointment);
}
