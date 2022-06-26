package com.app.central;

import com.app.central.model.Appointment;
import com.app.central.model.StateEnum;
import com.app.central.service.IAppointmentService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentServiceTest {
    Logger logger = LoggerFactory.getLogger(AppointmentAPITest.class);

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private IAppointmentService iAppointmentService;

    @Test
    public void saveAppointmentsServiceEmptyList() throws Exception {
        List<Appointment> appointmentListForSave = new ArrayList<>();
        List<Long> result = iAppointmentService.saveAppointments(appointmentListForSave);
        assertTrue(result.size() == 0);
    }


    @Test
    public void saveAppointmentsService() throws Exception {
        List<Appointment> appointmentListForSave = new ArrayList<>();
        Appointment appointment1 = new Appointment(1, 10, new Date(), 1, new Date(), "meet", StateEnum.APPROVED);
        Appointment appointment2 = new Appointment(2, 10, new Date(), 3, new Date(), "meet", StateEnum.APPROVED);
        appointmentListForSave.add(appointment1);
        appointmentListForSave.add(appointment2);
        List<Long> result = iAppointmentService.saveAppointments(appointmentListForSave);
        assertTrue(result.size() == 2);
    }

     @Test
    public void saveAppointmentsServiceTwoThread() throws Exception {
        List<Appointment> appointmentListForSave = new ArrayList<>();
        Appointment appointment1 = new Appointment(1, 10, new Date(), 1, new Date(), "meet", StateEnum.APPROVED);
        Appointment appointment2 = new Appointment(2, 10, new Date(), 3, new Date(), "meet", StateEnum.APPROVED);
        appointmentListForSave.add(appointment1);
        appointmentListForSave.add(appointment2);
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(2);

            Future<Boolean> result1 = Executors.newSingleThreadExecutor().submit(() -> {
                logger.info("Executing Task1 inside : " + Thread.currentThread().getName());
                List<Long> result = iAppointmentService.saveAppointments(appointmentListForSave);
                logger.info("size of List for Task1: " + result.size());
                assertTrue(result.size() == 2);
                return true;
            });
            Future<Boolean> result2 = Executors.newSingleThreadExecutor().submit(() -> {
                logger.info("Executing Task2 inside : " + Thread.currentThread().getName());
                List<Long> result = iAppointmentService.saveAppointments(appointmentListForSave);
                logger.info("size of List for Task2: " + result.size());
                assertTrue(result.size() == 2);
                return true;
            });
            assertTrue(result1.get());
            assertTrue(result2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    @Test
    public void saveAppointmentsServiceTwoThreadVer2() throws Exception {
        List<Appointment> appointmentListForSave = new ArrayList<>();
        Appointment appointment1 = new Appointment(1, 10, new Date(), 1, new Date(), "meet", StateEnum.APPROVED);
        Appointment appointment2 = new Appointment(2, 10, new Date(), 3, new Date(), "meet", StateEnum.APPROVED);
        appointmentListForSave.add(appointment1);
        appointmentListForSave.add(appointment2);
        boolean exception = false;
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(2);

            Future<Boolean> result1 = Executors.newSingleThreadExecutor().submit(() -> {
                logger.info("Executing Task1 inside : " + Thread.currentThread().getName());
                List<Long> result = iAppointmentService.saveAppointments(appointmentListForSave);
                logger.info("size of List for Task1: " + result.size());
                assertTrue(result.size() == 2);
                return true;
            });
            Future<Boolean> result2 = Executors.newSingleThreadExecutor().submit(() -> {
                logger.info("Executing Task2 inside : " + Thread.currentThread().getName());
                List<Long> result = iAppointmentService.saveAppointments(appointmentListForSave);
                logger.info("size of List for Task2: " + result.size());
                assertTrue(result.size() == 2);
                return true;
            });
        } catch (Exception e) {
            exception=true;
            e.printStackTrace();
        }

        assertFalse(exception);

    }
}
