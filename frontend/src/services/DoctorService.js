
import axios from 'axios';

export default {
    getDoctors() {
        return axios.get(`/doctors`);
    },

    getSpecificDoctor(doctorId) {
        return axios.get(`/doctors/specific`, doctorId)
    },

    getDoctorByPatient(patientId) {
        return axios.get(`/doctors/patient/${patientId}`)
    }
}
