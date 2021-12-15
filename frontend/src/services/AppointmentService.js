import axios from 'axios';

export default {
    getPatientsFullAppointmentList(patientId) {
        return axios.get(`/appointments/patient/${patientId}`);
    },
    createAppointment(doctor) {
        return axios.post(`/appointments/add`, doctor)
    },
    
    getDoctorFullAppointmentList(doctorId) {
        return axios.get(`/appointments/doctor/${doctorId}`);
    }
}
