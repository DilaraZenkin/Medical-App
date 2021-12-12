import axios from 'axios';

export default {

    getPatients() {
        return axios.get(`/patients`);
    },

    addPatient(patient) {
        return axios.post(`/patients/register`, patient);
    },

    getLoggedInPatient(patientId) {
        return axios.get(`/patients/${patientId}`);
    },

    updatePatientInformation(patient) {
        return axios.put(`/patients/update`,patient)
    }
}