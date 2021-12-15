import axios from 'axios';

export default {
    getPatientsFullAppointmentList(patientId) {
        return axios.get(`/appointments/patient/${patientId}`);
    },
    getDoctorFullAppointmentList(doctorId) {
        return axios.get(`/appointments/doctor/${doctorId}`);
    }
}
