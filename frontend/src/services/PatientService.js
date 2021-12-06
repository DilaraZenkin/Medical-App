import axios from 'axios';

export default {
    getPatient() {
        return axios.get(`/patient/${patientId}`);
    },

    getPatients() {
        return axios.get(`/patients`);
    }
}