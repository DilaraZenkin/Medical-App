import axios from 'axios';

export default {
    getDoctors() {
        return axios.get(`/doctors`);
    },
}