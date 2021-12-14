<template>
   <div>
     <v-container class="text-right">
      <v-btn id="home-logout" :to="{name: 'logout'}">Logout</v-btn>
    </v-container>
    <v-btn id="appointment-list" :to="{name: 'appointment-list'}">Appointments</v-btn>
    <v-btn id="update-doctor-availability" :to="{name: 'doctor-availability'}">Set Availability</v-btn>
    <v-btn id="office-information" :to="{name: 'doctor-office'}">View Office Information</v-btn>
  </div> 
</template>

<script>
export default {
  components: {  
    },

}
</script>

<style>

</style>