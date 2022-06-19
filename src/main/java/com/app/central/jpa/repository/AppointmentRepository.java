package com.app.central.jpa.repository;

import com.app.central.jpa.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository  extends JpaRepository<AppointmentEntity, Long> {
}
