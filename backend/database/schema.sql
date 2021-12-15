BEGIN TRANSACTION;
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS doctor_availabilities;
DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS offices;
DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

SELECT * FROM users u WHERE u.user_id = 6;

SELECT * FROM users;
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('pt1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('pt2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('dr1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('dr2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

CREATE TABLE offices (
        office_id serial PRIMARY KEY,
        office_name varchar (60),
        office_address varchar (500),
        office_phone_number varchar (15),
        office_open time,
        office_close time,
        hourly_cost int
);

INSERT INTO offices (office_id, office_name, office_address, office_phone_number, office_open, office_close, hourly_cost)
VALUES (1, 'St. George Hospital', '769 East Boulevard Wexford PA 16005', '778-996-4345', '10:00 am', '05:00 pm', 120);
INSERT INTO offices (office_id, office_name, office_address, office_phone_number, office_open, office_close, hourly_cost)
VALUES (2, 'Mayo Clinic', '768 East Boulevard Wexford PA 16005', '778-996-4354', '09:00 am', '04:00 pm', 100);

CREATE TABLE doctors (
        doctor_id int PRIMARY KEY,
        doctor_first varchar(50) NOT NULL,
        doctor_last varchar(100) NOT NULL,
        date_of_birth DATE,
        office_id int,
        CONSTRAINT fk_doctors FOREIGN KEY (office_id) REFERENCES offices (office_id),
        CONSTRAINT doctor FOREIGN KEY (doctor_id) REFERENCES users (user_id)
);

insert into doctors (doctor_id, doctor_first, doctor_last, date_of_birth, office_id)
values (5,'Doc', 'Scalpel', '04-26-1972', 1);
insert into doctors (doctor_id, doctor_first, doctor_last, date_of_birth, office_id)
values (6,'Horatio', 'Crunch', '07-04-1958', 2);

CREATE TABLE patients (
        patient_id int NOT NULL,
        first_name varchar(50) NOT NULL,
        last_name varchar(100) NOT NULL,
        date_of_birth DATE,
        address varchar (500),
        doctor_id int,
        CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES users (user_id),
        CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctors (doctor_id)
);

INSERT INTO patients (patient_id, first_name, last_name, date_of_birth, address, doctor_id)
VALUES (3, 'Frank', 'Sinatra', '12-12-1915', '556 East Boulevard Westport PA 15339', 6);
INSERT INTO patients (patient_id, first_name, last_name, date_of_birth, address, doctor_id)
VALUES (4, 'George', 'Castanza', '07-04-1968', '998 West Road Wexford PA 16884', 5);

CREATE TABLE appointments (
        appointment_id serial PRIMARY KEY,
        office_id int,
        patient_id int,
        doctor_id int,
        appointment_date DATE,
        start_time time,
        end_time time,
        CONSTRAINT fk_appointment_patients FOREIGN KEY (patient_id) REFERENCES users (user_id),
        CONSTRAINT fk_appointment_offices FOREIGN KEY (office_id) REFERENCES offices (office_id),
        CONSTRAINT fk_appointment_doctors FOREIGN KEY (doctor_id) REFERENCES users (user_id)
        );
       
INSERT INTO appointments (appointment_id, office_id, patient_id, doctor_id, start_time, end_time, appointment_date)
VALUES (1, 1, 3, 5, '10:00 am', '10:30 am', '10-12-2021');
INSERT INTO appointments (appointment_id, office_id, patient_id, doctor_id, start_time, end_time, appointment_date)
VALUES (2, 2, 4, 6, '12:00 pm', '12:30 pm', '11-12-2021');

CREATE TABLE doctor_availabilities (
        availability_id serial PRIMARY KEY,
        doctor_id int,
        day_of_week DATE,
        start_time time,
        end_time time,
        available boolean,
        CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctors (doctor_id)
);

INSERT INTO doctor_availabilities (availability_id, doctor_id, day_of_week, start_time, end_time, available)
VALUES (1, 5, '2021-12-13', '08:00', '15:00', true);
INSERT INTO doctor_availabilities (availability_id, doctor_id, day_of_week, start_time, end_time, available)
VALUES (2, 5, '2021-12-17', '08:00', '15:00', true);
INSERT INTO doctor_availabilities (availability_id, doctor_id, day_of_week, start_time, end_time, available)
VALUES (3, 5, '2021-12-17', '09:00', '09:30', false);

CREATE TABLE reviews (
        review_id serial PRIMARY KEY,
        title varchar(50),
        score int, 
        patient_id int, 
        doctor_id int, 
        office_id int, 
        review_body varchar(1000),
        response varchar(1000),
        CONSTRAINT patient FOREIGN KEY (patient_id) REFERENCES users (user_id),
        CONSTRAINT doctor FOREIGN KEY (doctor_id) REFERENCES users (user_id),
        CONSTRAINT office FOREIGN KEY (office_id) REFERENCES offices (office_id),
        CONSTRAINT score CHECK (score BETWEEN 1 AND 5)
);

INSERT INTO reviews (review_id, title, score, patient_id, doctor_id, office_id, review_body, response)
VALUES (1, 'Test', 4, 3, 5, 1, 'It was a good visit', 'Thank you');
INSERT INTO reviews (review_id, title, score, patient_id, doctor_id, office_id, review_body, response)
VALUES (2, 'Test', 2, 4, 6, 2, 'It was a bad visit', 'We are sorry');

COMMIT TRANSACTION;

SELECT of.office_address, of.office_phone_number, of.office_open, of.office_close, of.hourly_cost, d.first_name AS Doctor_Name, d.last_name AS Doctor_Lastname FROM offices of
JOIN doctors d ON of.office_id = d.office_id
WHERE doctor_id=5;

SELECT * FROM doctors;

SELECT office_address FROM doctors JOIN offices USING (office_id) WHERE doctor_id=5;

