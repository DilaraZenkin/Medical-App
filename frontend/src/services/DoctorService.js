<<<<<<< HEAD
import axios from 'axios';

export default {
    getDoctors() {
        return axios.get(`/doctors`);
    },
=======
import axios from "axios";

export default {
    addDoctor(doctor) {
        return axios.post(`doctors/register`, doctor);
    }
>>>>>>> cb646d27976c522ebd759ebff9bc2d5c1fcd1a9e
}