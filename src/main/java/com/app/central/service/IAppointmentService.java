package com.app.central.service;

import com.app.central.model.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Long> persistAppointments(List<Appointment> appointmens);
    long persistAppointment(Appointment appointmen);
}
