package com.app.central.dao;
import com.app.central.jpa.AppointmentEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class AppointmentDAO implements IAppointmentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persistAppointment(AppointmentEntity entity) {
        entityManager.persist(entity);
    }
}
