<template>
  <div>
     <v-container class="text-right">
      <v-btn id="home-logout" :to="{name: 'logout'}">Logout</v-btn>
    </v-container>
    <v-btn id="patient-information" :to="{name: 'patient-information'}">Personal Information</v-btn>
    <v-btn id="patient-appointments" :to="{name: 'patient-appointments'}">Appointments</v-btn>
    <v-btn id="office-list" :to="{name: 'office-list'}">Offices</v-btn>
    <v-btn id="doctor-list" :to="{name: 'doctor-list'}">DoctorList</v-btn>
  </div>  
</template>

<script>
export default {
  name: "patient-home"
}
</script>

<style>

</style>