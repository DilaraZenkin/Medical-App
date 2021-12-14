import axios from 'axios';

export default {
    getOffices() {
        return axios.get(`/offices`);
    }

    
}


