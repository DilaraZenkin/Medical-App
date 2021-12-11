
import axios from 'axios';

export default {
    getDoctors() {
        return axios.get(`/doctors`);
    },

    getSpecificDoctor(doctorId) {
        return axios.get(`/doctors/specific`, doctorId)
    }
}
