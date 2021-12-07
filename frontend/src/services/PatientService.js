import axios from 'axios';

export default {


    getPatients() {
        return axios.get(`/patients`);
    },

    addPatient() {
        return axios.post(`/patients/register`);
    }
}