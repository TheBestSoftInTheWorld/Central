package com.app.central;

import com.app.central.model.Appointment;
import com.app.central.service.IAppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SaveAppointmentsTest {
    final String API_PERSIST = "http://localhost:8081/api/saveAppointments";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private IAppointmentService iAppointmentService;

    @Test
    public void saveAppointments() throws Exception {
        List<Appointment> appointmentListForSave = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Appointment>> entity = new HttpEntity<List<Appointment>>(appointmentListForSave, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(API_PERSIST, HttpMethod.POST, entity, String.class);
        assertThat(result.getStatusCode().equals(HttpStatus.OK));
    }
    @Test
    public void saveAppointmentsService() throws Exception {
        List<Appointment> appointmentListForSave = new ArrayList<>();
        List<Long> result=iAppointmentService.saveAppointments(appointmentListForSave);
        assertThat(result.size()==0);
    }
}
