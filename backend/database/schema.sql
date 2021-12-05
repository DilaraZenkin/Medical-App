BEGIN TRANSACTION;

DROP TABLE IF EXISTS offices;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS patients;
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

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

CREATE TABLE doctors (
        doctor_id serial PRIMARY KEY,
        first_name varchar(50) NOT NULL,
        last_name varchar(100) NOT NULL,
        date_of_birth DATE,
        office_id int
        CONSTRAINT FK
);

INSERT INTO doctors (doctor_id, first_name, last_name, date_of_birth, office_address)
VALUES (1, 'Doc', 'Scapel', '09/04/1970', '543 Sout Avenue Pittsburgh PA 11245');

CREATE TABLE patients (
        patient_id serial PRIMARY KEY,
        first_name varchar(50) NOT NULL,
        last_name varchar(100) NOT NULL,
        date_of_birth DATE,
        address varchar (500)
);

INSERT INTO patients (patient_id, first_name, last_name, date_of_birth, address)
VALUES (1, 'tim', 'ziegler', '12/12/1990', '123 Main St. Pittsburgh PA 11223');

CREATE TABLE offices (
        office_id serial PRIMARY KEY,
        office_address varchar(500),
        phone_number varchar(15),
        office_hours,
        hourly_cost int
);

COMMIT TRANSACTION;
