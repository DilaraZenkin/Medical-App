import axios from "axios";

export default {
    addDoctor(doctor) {
        return axios.post(`doctors/register`, doctor);
    }
}