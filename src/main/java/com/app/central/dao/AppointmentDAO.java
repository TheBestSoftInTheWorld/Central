package com.app.central.dao;

import com.app.central.jpa.AppointmentEntity;

import com.app.central.jpa.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@Repository
public class AppointmentDAO implements IAppointmentDAO {
    Logger logger = LoggerFactory.getLogger(AppointmentDAO.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public long saveAppointments(AppointmentEntity entity) {

        try {
            if (entity.getId() == 0) {
                logger.info("Create new appointment");
            } else {
                logger.info("Update appointment id=" + entity.getId());
            }
            appointmentRepository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity.getId();
    }
}
