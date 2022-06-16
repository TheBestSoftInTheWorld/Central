DROP TABLE IF EXISTS APPOINTMENT;

CREATE TABLE APPOINTMENT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  appointmentTime DATE,
  personId INTEGER NOT NULL,
  modified DATE,
  reason VARCHAR(250),
  state VARCHAR(250)
);

