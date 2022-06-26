package com.app.central;

import com.app.central.controller.APIController;
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

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentAPITest {
    Logger logger = LoggerFactory.getLogger(AppointmentAPITest.class);
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private IAppointmentService iAppointmentService;


    @Test
    public void saveAppointmentsEmptyList() throws Exception {
        List<Appointment> appointmentListForSave = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Appointment>> entity = new HttpEntity<List<Appointment>>(appointmentListForSave, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:" + port + "/api/saveAppointments", HttpMethod.POST, entity, String.class);
        assertTrue(result.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    public void saveAppointments() throws Exception {
        List<Appointment> appointmentListForSave = new ArrayList<>();
        Appointment appointment1 = new Appointment(1, 10, new Date(), 1, new Date(), "meet", StateEnum.APPROVED);
        Appointment appointment2 = new Appointment(2, 10, new Date(), 3, new Date(), "meet", StateEnum.APPROVED);
        appointmentListForSave.add(appointment1);
        appointmentListForSave.add(appointment2);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Appointment>> entity = new HttpEntity<List<Appointment>>(appointmentListForSave, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:" + port + "/api/saveAppointments", HttpMethod.POST, entity, String.class);
        assertTrue(result.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    public void saveAppointmentsWithException() throws Exception {
        boolean exception=false;
       try {
           HttpHeaders headers = new HttpHeaders();
           headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
           HttpEntity entity = new HttpEntity<>(headers);
           RestTemplate restTemplate = new RestTemplate();
           ResponseEntity<String> result = restTemplate.exchange("http://localhost:" + port + "/api/saveAppointments", HttpMethod.POST, entity, String.class);
           assertTrue(result.getStatusCode().equals(HttpStatus.OK));
       }catch(Exception e){
           exception=true;
           e.printStackTrace();
       }
        assertTrue(exception);
    }
}
