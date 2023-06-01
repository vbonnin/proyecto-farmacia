CREATE DATABASE IF NOT EXISTS farmacia;

USE hospital;

CREATE TABLE doctor (
    mail VARCHAR(50) PRIMARY KEY,
    pass VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    last_log DATE,
    session INT(10)
);

CREATE TABLE patient (
    mail VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE medicine (
    id INT(10) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    tmax DECIMAL(5,2) NOT NULL,
    tmin DECIMAL(5,2) NOT NULL
);

CREATE TABLE xip (
    id INT(10) PRIMARY KEY,
    doctor_mail VARCHAR(50),
    id_medicine INT(10),
    id_patient VARCHAR(50),
    date DATE NOT NULL,
    FOREIGN KEY (doctor_mail) REFERENCES doctor(mail),
    FOREIGN KEY (id_medicine) REFERENCES medicine(id),
    FOREIGN KEY (id_patient) REFERENCES patient(mail)
);