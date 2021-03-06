SELECT office_address FROM doctors JOIN offices USING (office_id) WHERE doctor_id = 5;
SELECT * FROM offices;

SELECT * FROM doctors WHERE office_id = 1;
select * from doctors;

select * from patients;

SELECT of.office_id, of.office_address, of.office_phone_number, of.office_open, of.office_close, of.hourly_cost, d.first_name, d.last_name FROM offices of
JOIN doctors d ON of.office_id = d.office_id
WHERE first_name ILIKE 'S%';        
SELECT o.office_address, p.first_name AS patient_first_name, p.last_name AS patient_last_name, d.first_name AS doctor_first_name, d.last_name AS doctor_last_name, a.start_time, a.end_time, a.appointment_date
FROM appointments a JOIN patients p ON (p.patient_id = a.patient_id) 
JOIN doctors d ON (d.doctor_id = a.doctor_id)
JOIN offices o ON (o.office_id = a.office_id);  

UPDATE patients SET first_name = 'Test2',
last_name = 'Patient2',
date_of_birth = '1999-01-01',
address = '555 West East Rd. Somewhere PA, 11223',
doctor_id = 6
WHERE patient_id = 7;

select * from doctor_availabilities;

select * from appointments;

DELETE FROM appointments WHERE appointment_id = 4;

delete from appointments where appointment_id = 8;

SELECT appointment_id, appointment_date, start_time, p.patient_id, first_name, last_name, d.doctor_id, doctor_last, office_address 
FROM appointments a JOIN patients p ON a.doctor_id = p.doctor_id JOIN doctors d ON a.doctor_id = d.doctor_id 
JOIN offices o ON a.office_id = o.office_id WHERE doctor_id = ?;