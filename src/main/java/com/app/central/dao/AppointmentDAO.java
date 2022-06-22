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

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class AppointmentDAO implements IAppointmentDAO {
    Logger logger = LoggerFactory.getLogger(AppointmentDAO.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void saveAppointment(AppointmentEntity entity) {

        try {
            Optional<AppointmentEntity> ae = findAppointment(entity.getCompanyId(), entity.getRemoteAppointmentId());

            if (ae.isPresent()) {
                entity.setId(ae.get().getId());
                String changes = null;
                if (!entity.getAppointmentTime().equals(ae.get().getAppointmentTime())) {
                    changes = "changed meeting time from " + entity.getAppointmentTime() + " to " + ae.get().getAppointmentTime();
                }
                if (!entity.getReason().equals(ae.get().getReason())) {
                    String tmp = "changed reason from " + entity.getReason() + " to " + ae.get().getReason();
                    if (changes == null) {
                        changes = tmp;
                    } else {
                        changes = changes + ", " + tmp;
                    }

                }
                if (!entity.getState().equals(ae.get().getState())) {
                    String tmp = "changed state from " + entity.getState() + " to " + ae.get().getState();
                    if (changes == null) {
                        changes = tmp;
                    } else {
                        changes = changes + ", " + tmp;
                    }
                }
                if (changes == null) {
                    changes = "Appointment " + ae.get().getRemoteAppointmentId() + " has the same data";
                } else {
                    changes = "Appointment " + ae.get().getRemoteAppointmentId() + " " + changes + ".";
                }

                logger.info(changes);
                appointmentRepository.save(entity);
            } else {
                appointmentRepository.save(entity);
                logger.info("Create new appointment " + entity.getRemoteAppointmentId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<AppointmentEntity> findAppointment(long companyId, long remoteAppointmentId) {
        Optional<AppointmentEntity> appointmentEntity = Optional.ofNullable(null);
        try {
            String query = "select * " +
                    "from APPOINTMENT " +
                    "where  COMPANYID =:companyId " +
                    "and REMONTEAPPOINTMENTID = :remoteAppointmentId";

            AppointmentEntity entity = (AppointmentEntity) entityManager.createNativeQuery(query, AppointmentEntity.class)
                    .setParameter("companyId", companyId)
                    .setParameter("remoteAppointmentId", remoteAppointmentId)
                    .getSingleResult();
            appointmentEntity = Optional.ofNullable(entity);
        } catch (Exception e) {

        }
        return appointmentEntity;
    }
}
