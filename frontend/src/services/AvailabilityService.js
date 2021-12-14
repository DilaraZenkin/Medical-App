import axios from "axios";

export default {
    getAvailability(doctorId) {
        return axios.get(`/availabilities/${doctorId}`)
    },
    addAvailability(availability) {
        return axios.post(`/availabilities/add`, availability)
    },
    updateAvailability(availability) {
        return axios.put(`/availabilities/update`, availability)
    }
}