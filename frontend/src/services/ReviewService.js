import axios from 'axios';


export default {


    getReviews() {

        return axios.get(`/allreviews`);

    }
}