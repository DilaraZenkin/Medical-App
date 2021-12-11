import axios from "axios";

export default {
    addDoctor(doctor) {
        return axios.post(`doctors/register`, doctor);
    },

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