import axios from 'axios';

export default {

    getPatients() {
        return axios.get(`/patients`);
    },

    addPatient(patient) {
        return axios.post(`/patients/register`, patient);
    }
}