import axios from 'axios';

export default {
    getPatientsFullAppointmentList(patientId) {
        return axios.get(`/appointments/patient/${patientId}`);
    },
    createAppointment(doctor) {
        return axios.post(`/appointments/add`, doctor);
    },
    cancelAppointment(appointmentId) {
        return axios.delete(`/appointments/${appointmentId}`);
    },
    getDoctorFullAppointmentList(doctorId) {
        return axios.get(`/appointments/doctor/${doctorId}`);
    }
}
