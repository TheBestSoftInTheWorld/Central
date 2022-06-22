DROP TABLE IF EXISTS APPOINTMENT;

CREATE TABLE APPOINTMENT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  REMONTEAPPOINTMENTID INT,
  COMPANYID INT,
  appointmentTime DATE,
  personId INTEGER NOT NULL,
  modified DATE,
  reason VARCHAR(250),
  state VARCHAR(250),
   CONSTRAINT UC_COMPANY UNIQUE (REMONTEAPPOINTMENTID,COMPANYID)
);


