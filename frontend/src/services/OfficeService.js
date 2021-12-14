import axios from 'axios';


export default {


    getOffices() {

        return axios.get(`/offices`);

    },

    getSpecificOffice(doctorId) {
        return axios.get(`/offices/specific/${doctorId}`)
    },


    addOffice(office) {

        return axios.post(`/offices/create`, office);

    }

}