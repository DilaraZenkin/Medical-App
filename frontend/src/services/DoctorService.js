
import axios from 'axios';

export default {
    getDoctors() {
        return axios.get(`/doctors`);
    },


    addDoctor(doctor) {
        return axios.post(`doctors/register`, doctor);
    }

}