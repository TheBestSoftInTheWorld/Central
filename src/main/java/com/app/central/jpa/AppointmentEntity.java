package com.app.central.jpa;

import com.app.central.model.StateEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APPOINTMENT")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public long id;
    @Column(name = "EXTERNALID")
    public long externalId;
    @Column(name = "COMPANYID")
    public long companyId;
    @Column(name = "APPOINTMENTTIME")
    Date appointmentTime;
    @Column(name = "PERSONID")
    long personId;
    Date modified;
    String reason;
    @Enumerated(EnumType.STRING)
    StateEnum state;

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

    public long getExternalId() {
        return externalId;
    }

    public void setExternalId(long externalId) {
        this.externalId = externalId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
}
