package com.app.central.service;

import com.app.central.model.Appointment;

import java.util.List;

public interface IAppointmentService {
    void persistAppointments(List<Appointment> appointmens);
    void persistAppointment(Appointment appointmen);
}
