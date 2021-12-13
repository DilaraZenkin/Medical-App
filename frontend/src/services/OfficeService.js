import axios from 'axios';

export default {

    getOffices() {
        return axios.get(`/offices`);
    },

    addOffice(office) {
        return axios.post(`/offices/register`, office);
    }
}