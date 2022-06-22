package com.app.central.model;

import java.util.Date;

public class Appointment {
    public long id;
    public long remoteAppointmentId;
    public long companyId;
    public Date appointmentTime;
    public long personId;
    public Date modified;
    public String reason;
    public StateEnum state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public long getRemoteAppointmentId() {
        return remoteAppointmentId;
    }

    public void setRemoteAppointmentId(long remoteAppointmentId) {
        this.remoteAppointmentId = remoteAppointmentId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
}
