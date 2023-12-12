DROP DATABASE IF EXISTS CARS;
CREATE DATABASE CARS;
USE CARS;
DROP TABLE IF EXISTS ACCIDENT_JS15;
DROP TABLE IF EXISTS DRIVER_JS15;
DROP TABLE IF EXISTS CAR_JS15;
DROP TABLE IF EXISTS PARTICIPATED_JS15;
-- ACCIDENT(REPORT_NUMBER, LOCATION, DATE)
CREATE TABLE ACCIDENT_JS15
(
REPORT_NUMBER VARCHAR (50),
LOCATION VARCHAR (50),
PRIMARY KEY (REPORT_NUMBER)
);
-- PERSON(DRIVER_ID, ADDRESS, NAME)
CREATE TABLE PERSON_JS15
(
DRIVER_ID VARCHAR (50),
ADDRESS VARCHAR (50),
NAME VARCHAR (50),
PRIMARY KEY (DRIVER_ID)
);
-- CAR(LICENSE_ID, MODEL, YEAR)
CREATE TABLE CAR_JS15
(
LICENSE_ID VARCHAR (50),
MODEL VARCHAR (50),
YEAR INT,
DRIVER_ID VARCHAR (50) NOT NULL,
PRIMARY KEY (LICENSE_ID),
FOREIGN KEY (DRIVER_ID) REFERENCES PERSON_JS15 (DRIVER_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
-- PARTICIPATED (N-N CAR AND ACCIDENT)
CREATE TABLE PARTICIPATED_JS15
(
LICENSE_ID VARCHAR (50),
REPORT_NUMBER VARCHAR (50),
PRIMARY KEY (LICENSE_ID,REPORT_NUMBER),
FOREIGN KEY (LICENSE_ID) REFERENCES CAR_JS15 (LICENSE_ID),
FOREIGN KEY (REPORT_NUMBER) REFERENCES ACCIDENT_JS15 (REPORT_NUMBER)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
-- POLICY (POLICY_ID)
CREATE TABLE POLICY_JS15
(
POLICY_ID VARCHAR (50),
LICENSE_ID VARCHAR (50) NOT NULL UNIQUE,
PRIMARY KEY (POLICY_ID),
FOREIGN KEY (LICENSE_ID ) REFERENCES CAR_JS15 (LICENSE_ID)
);