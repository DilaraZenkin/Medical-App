<template>
  <div>
    <v-container class="text-right">
      <v-btn id="home-login" :to="{name: 'patient-home'}">Home</v-btn>
      <v-btn id="home-logout" :to="{name: 'logout'}">Logout</v-btn>
    </v-container>  

  </div>    
</template>

<script>
import PatientService from '../services/PatientService'
export default {
    name: 'patient-information',
    data: {
        patient: {
            patientId: '',
            firstName: '',
            lastName: '',
            dateOfBirth: '',
            patientAddress: ''
        }
    }

}
</script>

<style>

</style>