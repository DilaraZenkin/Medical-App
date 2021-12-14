import axios from 'axios';

export default {
    getPatientsFullAppointmentList(patientId) {
        return axios.get(`/appointments/patient/${patientId}`);
    }
}
