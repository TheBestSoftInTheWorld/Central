package com.app.central.service;

import com.app.central.model.Appointment;

import java.util.List;

public interface IAppointmentService {
    void saveAppointments(List<Appointment> appointments);

    void saveAppointment(Appointment appointment);
}
