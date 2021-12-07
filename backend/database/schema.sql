BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS offices;
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
	is_doctor boolean NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role,is_doctor) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER',false);
INSERT INTO users (username,password_hash,role,is_doctor) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN',false);

CREATE TABLE offices (
        office_id serial PRIMARY KEY,
        office_address varchar (500),
        office_phone_number varchar (15),
        office_open time,
        office_close time,
        hourly_cost int
);

INSERT INTO offices (office_id, office_address, office_phone_number, office_open, office_close, hourly_cost)
VALUES (1, '769 East Boulevard Wexford PA 16005', '778-996-4345', '10:00 am', '05:00 pm', 120);
INSERT INTO offices (office_id, office_address, office_phone_number, office_open, office_close, hourly_cost)
VALUES (2, '768 East Boulevard Wexford PA 16005', '778-996-4354', '09:00 am', '04:00 pm', 100);

CREATE TABLE doctors (
        doctor_id serial PRIMARY KEY,
        first_name varchar(50) NOT NULL,
        last_name varchar(100) NOT NULL,
        date_of_birth DATE,
        office_id int,
        CONSTRAINT fk_doctors FOREIGN KEY (office_id) REFERENCES offices (office_id)
);

insert into doctors (doctor_id, first_name, last_name, date_of_birth, office_id)
values (1,'Doc', 'Scalpel', '04-26-1972', 1);
insert into doctors (doctor_id, first_name, last_name, date_of_birth, office_id)
values (2,'Horatio', 'Crunch', '07-04-1958', 2);

CREATE TABLE patients (
        patient_id serial PRIMARY KEY,
        first_name varchar(50) NOT NULL,
        last_name varchar(100) NOT NULL,
        date_of_birth DATE,
        address varchar (500)
);

INSERT INTO patients (patient_id, first_name, last_name, date_of_birth, address)
VALUES (1, 'Frank', 'Sinatra', '12-12-1915', '556 East Boulevard Westport PA 15339');
INSERT INTO patients (patient_id, first_name, last_name, date_of_birth, address)
VALUES (2, 'George', 'Castanza', '07-04-196815', '998 West Road Wexford PA 16884');

COMMIT TRANSACTION;
